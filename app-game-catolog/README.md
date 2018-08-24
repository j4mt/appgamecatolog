[![Build Status](https://travis-ci.org/j4mt/appgamecatolog.svg?branch=master)](https://travis-ci.org/j4mt/appgamecatolog)
[![codecov](https://codecov.io/gh/j4mt/appgamecatolog/branch/master/graph/badge.svg)](https://codecov.io/gh/j4mt/appgamecatolog)
# appgamecatolog
Sample spring boot application to catolog a games collections with restful apis 


# Docker

## build

Build a local docker image with maven or docker.

`./mvnw package` or `docker build .` 

Via maven

`./mvnw install dockerfile:build`

## Run

Once build you are start a containerised instance locally with the follwing command

`docker run -p 8080:8080 -t j4mt/game-catalog`

Alternately you can use docker compose. **Note:** this is separate from the build process so you will need to run 
maven package to produce the spring boot jar prior to running docker compose.

To start the stack run ` docker-compose up --build -d ` The build flag will ensure the docker image is rebuilt with each
 run; the -d flag runs the stack in detached mode.

To stop the stack run `docker-compose down -v` The -v will prune volumes which is useful for testing/dev but will remove
 container volumns so may not be desired in all situations 
 
 test for github hook
