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
                sh './gradlew assemble'
            }
        }
        stage('Test') {
            steps {
                sh './gradlew test'
            }
        }
        stage('Container-ize and Upload to ECR') {
            when {
                branch 'master'
            }
            environment {
                ECR_URL = 'https://719042170775.dkr.ecr.us-west-2.amazonaws.com/jbaumgartner/web-bff'
                ECR_IMAGE_NAME = '719042170775.dkr.ecr.us-west-2.amazonaws.com/jbaumgartner/web-bff'
            }
            steps {
                withDockerRegistry(credentialsId: 'ecr:us-west-2:aws_admin', url: ECR_URL) {
                    sh './gradlew jibDockerBuild --image=jbaumgartner/web-bff'
                    sh 'docker tag jbaumgartner/web-bff:latest ${ECR_IMAGE_NAME}:latest'
                    sh 'docker push ${ECR_IMAGE_NAME}:latest'
                    sh 'docker tag jbaumgartner/web-bff:latest ${ECR_IMAGE_NAME}:${env.BUILD_NUMBER}'
                    sh 'docker push ${ECR_IMAGE_NAME}:${env.BUILD_NUMBER}'
                }
            }
        }
        stage('Deploy') {
            when {
                branch 'master'
            }
            steps {
                sh 'echo Deploy'
            }
        }
    }
}
