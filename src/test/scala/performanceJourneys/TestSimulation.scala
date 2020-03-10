package performanceJourneys

import io.gatling.core.Predef._
import conf.HttpConfiguration
import conf.profileConfig._
import runner.PerformanceTestRunner

class TestSimulation extends PerformanceTestRunner
  with HttpConfiguration {

  val GithubGet = scenario("Test Service")
    .exec(ServiceRequests.GithubGet).pause(5)

  runSimulation(GithubGet)

}
