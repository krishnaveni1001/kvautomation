
pipeline {
	agent any


	stages {
		stage ('Build') {
			steps {
				sh 'mvn clean package'
				slackSend (color: '#04b886', message: "Successfully built qa-automation.")
			}
		}
	}

	post {
		failure {
			slackSend (color: '#a30200', message: "Failed to build qa-automation.")
			
		}
	}
}
