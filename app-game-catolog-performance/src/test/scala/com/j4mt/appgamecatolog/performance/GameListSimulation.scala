package com.j4mt.appgamecatolog.performance

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class GameListSimulation extends Simulation {

  val httpConf = http
    .baseURL("http://localhost:8087") // Here is the root for all relative URLs
    //.acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8") // Here are the common headers
    .acceptHeader("application/json") // Here are the common header
    .acceptEncodingHeader("chunked")

  val scn = scenario("Scenario Name") // A scenario is a chain of requests and pauses
    .exec(http("request_list_of_games")
      .get("/game"))
    .exec(http("request_game_1")
      .get("/game/1")
      .check(status.is(200)))



  setUp(scn.inject(atOnceUsers(1000)).protocols(httpConf))
}
