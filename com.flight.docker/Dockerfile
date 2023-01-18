FROM openjdk:14-alpine
RUN apk add curl jq
WORKDIR /usr/share
ADD target/com.flight.docker.jar com.flight.docker.jar
ADD target/com.flight.docker-tests.jar com.flight.docker-tests.jar
ADD target/libs libs
ADD search-module.xml search-module.xml
ADD testng.xml testng.xml
ADD healthcheck.sh healthcheck.sh
RUN dos2unix healthcheck.sh
ENTRYPOINT sh healthcheck.sh