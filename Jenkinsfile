
pipeline {

    agent any

    tools {
        jdk 'JDK21'
        maven 'Maven310'
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean compile'
            }
        }

        stage('Run Selenium Tests') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Run API Tests - Newman') {
            steps {
                bat '"C:\\Users\\Dharani Madhu\\AppData\\Roaming\\npm\\newman.cmd" --version'

                bat '"C:\\Users\\Dharani Madhu\\AppData\\Roaming\\npm\\newman.cmd" run "postman\\Herokuapp_API_automation.json"'
            }
        }
    }

    post {

        always {

            junit allowEmptyResults: true,
                  testResults: 'target/surefire-reports/*.xml'

            archiveArtifacts artifacts: 'target/surefire-reports/**, target/allure-results/**',
                             allowEmptyArchive: true

            allure([
                includeProperties: false,
                jdk: '',
                results: [[path: 'target/allure-results']]
            ])
        }
    }
}
