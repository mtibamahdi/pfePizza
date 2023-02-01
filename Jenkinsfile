pipeline{
    agent any
    tools {
        maven 'maven'
    }
    environment {
        //Git config
        REPO_URL= 'https://github.com/mtibamahdi/pfePizza.git'
        // Nexus 3 config
        NEXUS_VERSION = 'nexus3'
        NEXUS_PROTOCOL = 'http'
        NEXUS_URL = 'host.docker.internal:7020'
        NEXUS_REPOSITORY = 'pizza4u'
        NEXUS_CREDENTIAL_ID = 'Nexus-credentials'
        // Sonarcube config
        SONARQUBE_URL = 'http://host.docker.internal'
        SONARQUBE_PORT = '7010'
    }
    stages {
        stage ('SCM'){
            steps{
                git credentialsId: 'GIT-CREDENTIALS',
                url: REPO_URL
            }
        }
        stage ('Maven Build'){
            steps{
                sh "mvn clean package -Dmaven.test.skip=true -X"
            }
        }
        stage ('Tests'){
            steps{
                sh "mvn test"
            }
        }
        stage('SonarQube') {
            steps {
                sh " mvn sonar:sonar -Dsonar.host.url=$SONARQUBE_URL:$SONARQUBE_PORT"
            }
        }
        stage('Deploy Artifact To Nexus') {
            steps {
                sh "mvn deploy -DskipTests -Dmaven.install.skip=true --settings my-settings.xml"
            }
        }
        stage('Sanity Check') {
            steps {
                script {
                    def retryCount = 0
                    def response = ""
                    def apiURL = "http://localhost:8001/actuator/health/sanity-check"
                    while (response != "200" && retryCount < 3) {
                        retryCount++
                        sleep 10000
                        response = sh(returnStdout: true, script: "curl -s -o /dev/null -w '%{http_code}' ${apiURL}")
                    }
                    if (response != "200") {
                        error("REST API deployment failed with HTTP status code: ${response}")
                    }
                }
            }
        }
    }
}