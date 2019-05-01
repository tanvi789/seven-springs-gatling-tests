package runner

import io.gatling.core.Predef._
import io.gatling.core.Predef.{Simulation, atOnceUsers, constantUsersPerSec, rampUsersPerSec}
import io.gatling.core.action.builder.PauseBuilder
import io.gatling.core.structure.ScenarioBuilder
import conf.{HttpConfiguration, profileConfig}

import scala.concurrent.duration._

trait PerformanceTestRunner extends Simulation
  with HttpConfiguration {

  def scaledPauseFromSeconds(value: Int) = new PauseBuilder((0.1 * value) seconds, None)

  val MinPause = scaledPauseFromSeconds(30)
  val MedPause = scaledPauseFromSeconds(50)
  val MaxPause = scaledPauseFromSeconds(60)

  def runSimulation(scenario: ScenarioBuilder): Unit = {
    if (profileConfig.profile == "constantUsersLoad") {
      setUp(scenario.inject(
        constantUsersPerSec(2) during (1 minute)))
        .protocols(httpProtocol)
      //.assertions()
      //          global.responseTime.max.lessThan(500),
      //          forAll.failedRequests.count.lessThan(5),
      //          details("Bad Request").successfulRequests.percent.greaterThan(90))
    }
    if (profileConfig.profile == "single") {
      setUp(scenario.inject(
        atOnceUsers(2)
      )        .protocols(httpProtocol))
    }
  }
}

