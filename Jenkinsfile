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
            steps {
                script {
                    docker.withRegistry(credentialsId: 'ecr:us-west-2:aws_admin', url: '719042170775.dkr.ecr.us-west-2.amazonaws.com/jbaumgartner/web-bff') {
                        def image = docker.build('jbaumgartner/web-bff')
                        image.push('719042170775.dkr.ecr.us-west-2.amazonaws.com/jbaumgartner/web-bff:${env.BUILD_NUMBER}')
                        image.push('719042170775.dkr.ecr.us-west-2.amazonaws.com/jbaumgartner/web-bff:latest')
                    }
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
