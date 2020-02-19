# SQS
---
## Introduction
SQS is the Simple Queue Service provided by AWS. With SQS we can push messages into the queue and which are stored for a specified amount of time or until deleted. It does not follow a pub/sub model, but rather a polling model - where messages have to explicitly be requested. AWS SQS is a serverless messaging queue. This means that we have no server to manage. However, as a distributed queue system our messages are actually stored across a number of AWS SQS servers. You do not pay for SQS queues based on duration of operation, but per request (which could be up to 10 messages). Under AWS Free Tier, users can send 1 million requests across any number of queues per month for free. After free tier, costs range from $0.40 - $0.50 per 1 million requests (costs vary depending on the type of queue).''

[AWS SQS Documentation](https://docs.aws.amazon.com/sqs/index.html)

---

## Queue Types

### Standard Queue

***Unlimited Throughput***
- Standard queues support a nearly unlimited number of transactions per second (TPS) per API action.
- API Actions: `SendMessage`, `ReceiveMessage`, or `DeleteMessage`

***At-Least-Once Delivery***
- A message is delivered at least once, but occasionally more than one copy of a message is delivered.

***Best-Effort Ordering***
- Occasionally, messages might be delivered in an order different from which they were sent.


### FIFO Queue
***High Throughput***
- By default, with batching, FIFO queues support up to 3,000 messages per second, per API action.
- Without batching, FIFO queues support up to 300 messages per second, per API action.
- API Actions: `SendMessage`, `ReceiveMessage`, or `DeleteMessage`

***Exactly-Once Processing***
- A message is delivered once and remains available until a consumer processes and deletes it. Duplicates aren't introduced into the queue.

***First-In-First-Out Delivery***
- The order in which messages are sent and received is strictly preserved.


### Choosing a Queue Type
Choose a Standard Queue when you need to send data between applications and the throughput is important, for example:
- Decouple live user requests from intensive background work: let users upload media while resizing or encoding it.
- Allocate tasks to multiple worker nodes: process a high number of credit card validation requests.
- Batch messages for future processing: schedule multiple entries to be added to a database.

Choose a FIFO Queue when you need to send data between applications and the order of events is important, for example:
- Ensure that user-entered commands are executed in the right order.
- Display the correct product price by sending price modifications in the right order.
- Prevent a student from enrolling in a course before registering for an account.

---

## Visibility Timeout

When a consumer receives and processes a message from a queue, the message remains in the queue. Amazon SQS doesn't automatically delete the message. Because Amazon SQS is a distributed system, there's no guarantee that the consumer actually receives the message (for example, due to a connectivity issue, or due to an issue in the consumer application). Thus, the consumer must delete the message from the queue after receiving and processing it.

Immediately after a message is received, it remains in the queue. To prevent other consumers from processing the message again, Amazon SQS sets a visibility timeout, a period of time during which Amazon SQS prevents other consumers from receiving and processing the message. The default visibility timeout for a message is 30 seconds, the maximum is 12 hours, and the minimum is 0 seconds.

---

## Dead Letter Queues

Amazon SQS supports dead-letter queues, which other queues (source queues) can target for messages that can't be processed (consumed) successfully. Dead-letter queues are useful for debugging your application or messaging system because they let you isolate problematic messages to determine why their processing doesn't succeed.

---

## Compatibility with JMS

The Amazon SQS Java Messaging Library is a JMS interface for Amazon SQS that lets you take advantage of Amazon SQS in applications that already use JMS. The interface lets you use Amazon SQS as the JMS provider with minimal code changes. Together with the AWS SDK for Java, the Amazon SQS Java Messaging Library lets you create JMS connections and sessions, as well as producers and consumers that send and receive messages to and from Amazon SQS queues.

The library supports sending and receiving messages to a queue (the JMS point-to-point model) according to the JMS 1.1 specification. The library supports sending text, byte, or object messages synchronously to Amazon SQS queues. The library also supports receiving objects synchronously or asynchronously.
