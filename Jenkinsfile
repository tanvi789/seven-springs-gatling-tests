def mypod = "mypod-${UUID.randomUUID().toString()}"
podTemplate(label: mypod, containers: [
    containerTemplate(name: 'git', image: 'alpine/git', ttyEnabled: true, command: 'cat'),
    containerTemplate(name: 'maven', image: 'maven:3.5.2-jdk-8-alpine', command: 'cat', ttyEnabled: true),
    containerTemplate(name: 'docker', image: 'docker', command: 'cat', ttyEnabled: true)
  ],
   volumes: [
    emptyDirVolume(mountPath: '/opt/gatling/results')])
  {
  node(mypod) {

    stage('Build a project') {
      sh 'env'
          }

    stage('checkout repository') {
      checkout scm
        }

    stage('Maven Build') {
        container('maven') {
      sh 'mvn clean compile'
      }

    stage('Run Tests') {
      sh './runTests.sh'
        }
        }
        }
        }