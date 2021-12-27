pipeline{
  agent {
     label 'agent1'
  }
  stage{
    steps {
      sh 'echo hello'
      sh 'java -version'
      sh 'mvn clean install -dSkipTests=true'
    }
  }
}
