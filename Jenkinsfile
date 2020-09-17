pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh 'gradle --version'
                sh 'java --version'
                sh './gradlew assemble'
            }
        }
        stage('Test') {
            steps {
                sh './gradlew test'
            }
        }
        stage('Deploy') {
            steps {
                sh 'echo Deploy'
            }
        }
    }
}
