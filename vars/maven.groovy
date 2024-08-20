def call(Map config) {
    pipeline {
    agent any
    tools {
        maven "${config.maven}"
    }
    stages {
        stage('git'){
            steps {
                git url: "${config.url}",
                    branch: "${config.branch}"
            }
        }
        stage('build') {
            steps {
                sh "mvn ${config.goals}"
            }
        }
    }
}
}