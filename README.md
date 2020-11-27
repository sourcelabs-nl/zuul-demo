# zuul-demo

# Introduction
This project contains two applications:
* zuul gateway
* demo application with a few endpoints

# Setup
The zuul gateway is configured to connect to the demo application on ports: `8090` & `9090`. For an optimal experience it's necessary
to start the demo application with two running instances. You can do this by overriding the `server.port` property and then starting the application twice.

# Features
The gateway has the following features implemented:
* Retries
* Client side load balancing with Ribbon
* Rate limiting using spring-cloud-zuul-ratelimit