pipeline {
    agent {
        kubernetes {
            yaml '''
                apiVersion: v1
                kind: Pod
                spec:
                  containers:
                  - name: maven
                    image: maven:3.8-openjdk-11
                    command:
                    - /bin/sh
                    - -c
                    - "sleep 900"
                    tty: true
                    resources:
                      requests:
                        memory: "512Mi"
                        cpu: "500m"
                      limits:
                        memory: "1Gi"
                        cpu: "1000m"
            '''
        }
    }

    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/thfai2000/bootcamp-demo-java-app.git',
                    branch: 'main'
            }
        }

        stage('Build') {
            steps {
                container('maven') {
                    sh 'mvn clean compile'
                }
            }
        }

        stage('Test') {
            steps {
                container('maven') {
                    sh 'mvn test'
                }
            }
            post {
                always {
                    junit '**/target/surefire-reports/*.xml'
                }
            }
        }

        stage('Package') {
            steps {
                container('maven') {
                    sh 'mvn package'
                }
            }
        }
    }
}
