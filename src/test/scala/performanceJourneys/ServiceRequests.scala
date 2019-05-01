package performanceJourneys

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object ServiceRequests {
  val GithubGet = exec(http("Service Get")
    .get("/")
    .check(status.is(200)))
    .pause(7)

}
