# Messaging Queuing

Message queuing allows applications to communicate by sending messages to each other. The message queue provides temporary message storage when the destination program is busy or not connected.

A queue is a sequence of objects waiting to be processed by a consumer, starting with the first object put into the queue and processing them in sequential order. A message queue is a queue of messages sent between applications. It includes a sequence of work objects that are waiting to be processed.

A message is the data transported between the sender and the receiver application; it's essentially a byte array with some headers at the top. An example of a message could be something that tells one system to start processing a task, it could contain information about a finished task or just be a plain message.

Message queues provide an asynchronous communications protocol, meaning that the sender and receiver of the message do not need to interact with the message queue at the same time. Messages placed onto the queue are stored until the recipient retrieves them. Message queues have implicit or explicit limits on the size of data that may be transmitted in a single message and the number of messages that may remain outstanding on the queue.

---

# JMS

## Introduction

Java Message Service (JMS) is a Java API for sending messages between two or more clients. It is an implementation to handle the producer–consumer problem. JMS is a part of the Jakarta/J2EE platform, and is a messaging standard that allows application components based on Java EE (includes Spring) to create, send, receive, and read messages. It allows the communication between different components of a distributed application to be loosely coupled, reliable, and asynchronous.

## Messaging Models

***Point-to-point***
- messages are routed to individual consumers who maintain queues of incoming messages
- any number of producers can send messages to the queue, each message is guaranteed to be delivered, and consumed by one consumer
- queues retain all messages sent to them until the messages are consumed or until the messages expire
- producer is directly aware of consumer, although consumers are not necessarily aware of producers

***Publisher-subscriber***
- subscribers may register interest in receiving messages published on a particular message topic
- neither the producers nor the consumers are aware of one another; a broker is used as intermediary
- zero or more consumers will receive a message posted to a topic


## Provider Implementations

- Amazon SQS's Java Messaging Library [Reference](http://docs.aws.amazon.com/AWSSimpleQueueService/latest/SQSDeveloperGuide/jmsclient.html)
- Pivotal RabbitMQ [Reference](https://rabbitmq.docs.pivotal.io/37/index.html)
- Apache Kafka [Reference](https://kafka.apache.org/intro)
- Oracle WebLogic [Reference](https://docs.oracle.com/middleware/1212/wls/index.html)