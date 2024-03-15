pipeline {
    agent any

    environment {
        JAVA_HOME = '/usr/local/jvm/jdk-11.0.1'  // Specify the path to your JDK installation
        MAVEN_HOME = '/usr/share/maven'  // Specify the path to your Maven installation
        PATH = "${env.JAVA_HOME}/bin:${env.MAVEN_HOME}/bin:${env.PATH}"
    }

    stages {
        stage('Git PULL') {
            steps {
                script {
                    sshagent(credentials: ['dev_server']) {
                        def remoteCommand = """cd /home/rahin/source-code/java/full-stack/Movie-Application && git pull"""
                        sh "ssh -o StrictHostKeyChecking=no ${server_user}@${dev_server} '${remoteCommand}'"
                    }
                }
            }
        }
     stage('Build The Project') {
                 steps {
                     script {
                         sshagent(credentials: ['dev_server']) {
                             def remoteCommand = """cd /home/rahin/source-code/java/full-stack/Movie-Application"""
                             sh "'${remoteCommand}'"
                             sh 'mvn clean install'
                         }
                     }
                 }
             }
    }
}
