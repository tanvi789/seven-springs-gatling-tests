package conf

import scala.concurrent.duration._


object profileConfig {

  val profile = System.getProperty("Profile")

  /** Load Profiles**/
  val load = 1
  val noLoad = 0
  val rampDownTime = 2 minute
  val rampUpTime = 5 minutes
  val mean = 100
  val percentile95 = 200
  val percentile99 = 300
  val requestsPerSecond = 1000

  var base = "https://www.itqaworld.com"
}
