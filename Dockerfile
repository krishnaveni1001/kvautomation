FROM maven:alpine as BUILDER

RUN apk add curl postgresql jq coreutils chromium chromium-chromedriver

# Arguments for connecting the maven project to nexus server
ARG nexus_profile=ibm
ARG nexus_gcp_addr=nexus.cargosphere.in

# Install updates to image, ssh and make directories
RUN apk add --no-cache bash git openssh && \
    mkdir -p /usr/local/cargosphere && \
    mkdir /root/.ssh && mkdir /root/.m2 && \
    ssh-keyscan github.com >> ~/.ssh/known_hosts

# Copy over settings.xml to enable dependency retrieval
ADD settings.xml /root/.m2/settings.xml

WORKDIR /usr/local/cargosphere/qa-automation
ADD ./pom.xml pom.xml

# Create layer with all the maven dependencies
RUN mvn dependency:go-offline -Dnexus.active_profile=${nexus_profile} -Dnexus.gcp_addr=${nexus_gcp_addr}

# build the project
ADD ./src src
RUN mvn clean package -DskipTests -Dnexus.active_profile=${nexus_profile} -Dnexus.gcp_addr=${nexus_gcp_addr}

RUN pwd && ls -la target


FROM alpine:latest
RUN apk add openjdk8 curl postgresql jq coreutils chromium chromium-chromedriver libexif udev
WORKDIR /usr/local/cargosphere/qa-automation
ADD ./contracts /usr/local/cargosphere/contracts
ADD ./scripts /usr/local/cargosphere/scripts
COPY --from=BUILDER /usr/local/cargosphere/qa-automation/target/Cargosphere-Automation-0.0.1-SNAPSHOT-jar-with-dependencies.jar /Cargosphere-Automation-0.0.1-SNAPSHOT-jar-with-dependencies.jar

RUN chmod 700 /usr/local/cargosphere/scripts/*.sh
# --workdir
CMD ["java", "-jar /Cargosphere-Automation-0.0.1-SNAPSHOT-jar-with-dependencies.jar", "--features classpath:features/ratesearch","--base-url proxy","--protocol http","--chrome-driver-path /usr/bin/chromedriver","--headless", "--report-directory-path /tmp"]
