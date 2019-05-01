package conf

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import profileConfig._

trait HttpConfiguration {

  val httpProtocol = http
    .baseUrl(base)
    .inferHtmlResources(BlackList(
      """.*\.js""",
      """.*\.css""",
      """.*\.gif""",
      """.*\.jpeg""",
      """.*\.jpg""",
      """favicon.ico""",
      """.*\.ico""",
      """.*\.svg""",
      """.*\.png""",
      """favicon.ico?v=2""",
      """$_118.JPG"""), WhiteList())
    .acceptHeader("*/*")
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("en-GB,en;q=0.5")
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.12; rv:54.0) Gecko/20100101 Firefox/54.0")

}
