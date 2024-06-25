# Spring Boot Kafka Message Ingestor

This application is designed to listen to a Kafka topic for incoming messages, and save it to a MongoDB database.
The application consists of a RESTful API for sending messages to Kafka topics and a Kafka listener for consuming messages.

## **Setup**

### Kafka Service
Kafka server should be up and running. Docker is used to run Kafka servers. 
The Docker setup includes both Kafka and Zookeeper services configured to run in a Docker network.
To run Kafka and Zookeeper using Docker, navigate to the directory containing the [docker-compose.yml](docker-compose.yml) file and run:
``docker-compose up -d
``


### MongoDB Service
MongoDB instance should be up and running on MongoDB Atlas.
Create a database named messages in your MongoDB Atlas instance.
Configure the database connection in [application.properties](src%2Fmain%2Fresources%2Fapplication.properties) file.


## **Run the application**
Once the application is up and running, it will listen to the
'polixis' Kafka topic for incoming messages.
When a new message is received,
it will be saved to the messages table in the MongoDB database instance.

### Send Messages:


Send a POST request to http://localhost:8080/api/v1/messages/ingest with a JSON payload:

```
{
"content": "Hello, Kafka!",
"sender": "new-user"
}
```
