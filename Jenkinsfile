pipeline {
    agent any
    tools {
        // Specify the Maven tool to use (must be installed in Jenkins)
        maven 'Maven 3.9.9'  // This is a tool name configured in Jenkins
    }
    stages {
        stage('Checkout') {
            steps {
                // Pull the source code from the Git repository
                git 'https://github.com/Meenakshi-Sundaram-2198/OrangeHRM-Demo-Validation.git'
            }
        }
        stage('Build') {
            steps {
                // Run Maven build command
                sh 'mvn clean install'
            }
        }
        stage('Test') {
            steps {
                // Run tests using Maven
                sh 'mvn test'
            }
        }
        stage('Deploy') {
            steps {
                // Deploy the artifact (optional)
                sh 'mvn deploy'
            }
        }
    }
    post {
        always {
            // Actions to run after the pipeline (e.g., cleanup, notifications)
            echo 'Build process finished.'
        }
    }
}
