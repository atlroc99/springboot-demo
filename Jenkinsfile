pipeline{
  agent {
     label 'agent1'
  }
  stages{
    stage{
       steps {
        sh 'echo hello'
        sh 'java -version'
        sh 'mvn clean install -dSkipTests=true'
      }
    }
  }
}
