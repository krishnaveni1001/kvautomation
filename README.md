# QA Automation

# Driver paths
	- drivers/mac/76/chromedriver
	- drivers/mac/77/chromedriver
	- drivers/mac/78/chromedriver
	- drivers/linux/77/chromedriver
	- drivers/windows/chromedriver.exe

# build
## docker build
```bash
docker build . -t gcr.io/awesomecstools/system-tests/qa-automation:latest
```
## local build
### requirements
1. Maven
2. Java

Be sure to add the jitback-proxy repo to your local `~/.m2/settings.xml` file
```xml
<settings ...>
	<profiles>
		<profile>
			<repositories>
				...
				<repository>
					<id>jitpack-proxy</id>
					<url>http://nexus.cargosphere.us/repository/jitpack-proxy/</url>
					<releases>
						<enabled>true</enabled>
					</releases>
					<snapshots>
						<enabled>true</enabled>
					</snapshots>
				</repository>
				...
			</repositories>
		</profile>
	</profiles>
</settings>
```
### build command
`mvn clean package`

# run
## local build and run
```bash
mvn -o clean test \
	-Dselenium_headless=true \
	-Dwebdriver.chrome.driver=/usr/bin/chromedriver
```
In Eclipse, use `src/main/resources/features` to specify the feature(s)

## run the selenium tests
```bash
java -jar Cargosphere-Automation-0.0.1-SNAPSHOT-jar-with-dependencies.jar \
	--features classpath:features/maeu \
	--base-url proxy \
	--protocol http \
	--chrome-driver-path /usr/bin/chromedriver \
	--headless \
    --ui-data-load-path /usr/contracts/
	--report-directory-path /tmp
```

You can pass any additional Cucumber CLI arguments to the end of your java command. For example, you can run specific scenarios using tags:
```bash
java -jar Cargosphere-Automation-0.0.1-SNAPSHOT-jar-with-dependencies.jar \
	--features classpath:features/maeu \
	--base-url proxy \
	--protocol http \
	--chrome-driver-path /usr/bin/chromedriver \
	--headless \
	--report-directory-path /tmp \
	--tags "@CreateFCLContract1,@CreateFCLContract2"
```

## load esuds contract (.csv)
```bash
# run this from the system-tests project
docker run \
	--volume $(pwd)/esuds/mnt/in:/home/cron/mnt/in \
	--network system-tests_corenet \
	--env DB_ADDR=psql \
	--env DB_DB=local \
	--env DB_USER=cs_user \
	gcr.io/awesomecstools/system-tests/qa-automation:latest /usr/local/cargosphere/scripts/load-esuds-contracts.sh maeu
```

## approve rates and surcharges for a contract before running tests
```bash
docker run 
	--network system-tests 
	--env DB_ADDR=psql 
	--env DB_DB=local 
	--env DB_USER=cs_user 
	gcr.io/awesomecstools/system-tests/qa-automation:latest /usr/local/cargosphere/scripts/approve-contract.sh '<contract_number>'
```

## load tariff and contract data (.json) via the API
```bash
# run this from the system-tests project
docker run \
	--volume $(pwd)/esuds/mnt/in:/home/cron/mnt/in \
	--network system-tests_corenet \
	--env DB_ADDR=psql \
	--env DB_DB=local \
	--env DB_USER=cs_user \
	gcr.io/awesomecstools/system-tests/qa-automation:latest /usr/local/cargosphere/scripts/load-esuds-json-tariff.sh oney-json ONEY oney_super
```

## Load contracts through the UI before feature tests:
You can define contract data that will be loaded in through the UI before any scenario in a feature file runs.  You must provide
this data in the form of a .json file located in the directory defined by the `ui-data-load-path` argument.  Refer to `example-json.md` for an example
of the structure with explanations for each field's behavior.  In order to associate a UI Load .json with a feature, include the
following step first in the `background` section for that .feature:

```
Background:
    Given test data has been loaded for "compact_view_lcl"
    # remaining background steps

Scenario:
   # steps for scenario dependant on "compact_view_lcl" data being loaded
``` 

The corresponding step will only run once per feature and will check the test database if a contract already exists
before performing any UI data load.  This means developers will not have to rerun the UI data loads every time
they run feature tests so long as their database persists between runs.

This method also requires certain environment variables be present in order to communicate with the test database,
although they have default values matching the preconfigured system-tests.  Here they are with their default values:
```
TEST_DB_HOST=localhost
TEST_DB_NAME=local
TEST_DB_PASS=cs123
TEST_DB_USER=postgres
TEST_DB_PORT=5433
```