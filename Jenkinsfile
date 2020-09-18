pipeline {
    agent any
    tools {
        jdk 'openjdk-11'
    }
    triggers {
        githubPush()
    }

    stages {
        stage('Build') {
            steps {
                sh 'echo Building, oh boy, take 2'
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
