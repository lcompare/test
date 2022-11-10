#!groovy

pipeline{
    agent { any{} }
    
    parameters{
        booleanParam(name: 'Test', defaultValue: true, description: 'nothing')
    }
    
    stages{
        stage('Setup environment'){
            steps{
                script{
                    echo "nothing"
                }
            }
        }
        stage('build') {
            steps{
                script{
                    echo "nothing 2"
                }
            }
        }
        
    }
}