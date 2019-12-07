# cloud-native-microservices

An interactive session on building cloud-native-microservices using spring boot and spring cloud. 
Dockerizeing and deploying on Amazon AWS


Steps to follow:
1. Setup infrastructure maven project with pom packaging, this controls all major dependency versions
2. Develop Cloud Config server, use infrastructure as parent
3. Develop Eureka service, use infrastructure as parent
4. Create config-service-repository
5. Develop book-service, with H2 db in dev, mySQL in prod
6. Develop user-service, with H2 db in dev, mySQL in prod
6. Develop library-service, with H2 db in dev, mySQL in prod : This is the client service. UI interaction.
7. Develop api gateway, route all calls through gateway
8. Add Feign CLient and Ribbon to alll API calls
9. Add sleuth to all services
10. Add Hystrix to all services/API calls
11. Add Hystrix dashboard capability
12. Add zipkin server for distributed tracing mechanism

Advanced:
13. Implement async logging capabilities using Grey-logging.
14. Implement spring cloud bus for context refresh on properties change using RabbitMQ/ActiveMQ


## Next Session : Transaction Management throughout the architecture.
### The SAGA begins...

stay tuned :-) see you soon


Multi submodule repository in bitbucket: https://bitbucket.org/account/user/crystalark/projects/JPOP2


