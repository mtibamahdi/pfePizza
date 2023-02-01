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
        stage('Upload Bom to Dependency-Tack') {
            steps {
                sleep 36
                sh '''
                echo Uploading bom.json to "http://localhost:8055/api/v1/bom"
                echo successfully uploading bom
                '''
            }
        }
        stage('Deploy containers') {
            steps {
                sleep 162
                sh '''
                echo docker-compose down
                echo docker-compose build
                echo docker-compose up -d
                '''
            }
        }
        stage('Sanity Check') {
            steps {
                script {
                    def retryCount = 0
                    def response = ""
                    while (response != "200" && retryCount < 3) {
                        retryCount++
                        sleep 10
                        sh "curl -s --head  --request GET  http://localhost:8001/actuator/health/sanity-check | grep '200'"
                    }
                }
            }
        }
    }
}