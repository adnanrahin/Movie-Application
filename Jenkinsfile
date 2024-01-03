pipeline {
    agent any

    environment {
        JAVA_HOME = '/usr/local/jvm/jdk-11.0.1'  // Specify the path to your JDK installation
        MAVEN_HOME = '/usr/share/maven'  // Specify the path to your Maven installation
        PATH = "${env.JAVA_HOME}/bin:${env.MAVEN_HOME}/bin:${env.PATH}"
    }

    stages {
        stage('Build') {
            steps {
                script {
                    // Display JDK and Maven versions
                    sh 'java -version'
                    sh 'mvn -version'

                    // Run Maven clean install
                    sh 'mvn clean install'
                }
            }
        }
        stage('Deploy To the Container') {
                    steps {
                        script {
                            sh 'docker compose up -d --build'
                        }
                    }
                }
    }

    post {
        success {
            echo 'Build successful!'
        }
        failure {
            echo 'Build failed!'
        }
    }
}