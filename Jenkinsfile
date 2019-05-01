def mypod = "mypod-${UUID.randomUUID().toString()}"
podTemplate(label: mypod, containers: [
    containerTemplate(name: 'maven', image: 'maven:3.3.9-jdk-8-alpine', command: 'cat', ttyEnabled: true),
  ])
  {
  node(mypod) {

  container('maven') {
    stage('Build a project') {
      sh 'env'
          }
          }

    stage('checkout repository') {
      checkout scm
        }

    stage('Maven Build') {
      sh 'mvn gatling:test -DProfile='single' --fail-at-end --batch-mode --update-snapshots'
                }
            }
        }