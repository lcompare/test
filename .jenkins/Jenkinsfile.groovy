#!groovy

changes = []

pipeline{
    agent { any{} }
    
    parameters{
        booleanParam(name: 'Test', defaultValue: true, description: 'nothing')
    }
    
    stages{
        stage('Setup environment'){
            steps{
                script{
                    changes.add('####1')
                    changes.add('####2')
                    result = getCRs('log.log').trim()
                    
                    if(result == '1'){
                        echo "2"
                    }
                }
            }
        }
        stage('build') {
            steps{
                script{
                    changes.each{
                        //echo "${it}"
                        echo "hola como andas ${it}"
                    }
                }
            }
        }
        
    }
}

def getCRs(logName){
    sh label: 'Checking something', script: 'echo "this is a bash script."'
    result = sh(returnStdout: true, script: 'echo "CHG000128271 CHG11223344"').trim()
    str = []
    str = result.split(" ")
    changes.add(str[0].trim())
    changes.add(str[1].trim())
    return result
}