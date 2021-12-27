pipeline{
  agent {
     label 'china'
  }
  stages{
    stage ('testing'){
       steps {
        sh 'echo hello'
        sh 'java -version'
        sh 'mvn clean install -dSkipTests=true'
      }
    }
  }
}
