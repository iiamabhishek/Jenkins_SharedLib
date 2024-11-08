def call(String Project, String ImageTag, String dockerhubuser){
  withCredentials([usernamePassword(credentialsId: 'docker-hub', passwordVariable: 'dockerhubpass', usernameVariable: 'dockerhubuser')]) {
  //     sh "echo ${dockerhubpass} | docker login --username ${dockerhubuser} --password-stdin"
    sh "docker login -u ${dockerhubuser} -p ${dockerhubpass}"

  }
 sh "docker push ${dockerhubuser}/${Project}:${ImageTag}"
}
