# Monolithic Application
---

- Single application executable
  - Easy to comprehend, difficult to get thoroughly acquainted with		
  - Must be written in a single language
		
- Modularity based on programming language
  - uses the constructs available in that language to encapsulate business function (packages, classes, functions, etc.)		
  - Various storage and service technologies used (RDBMS, Messaging, etc.)

---
## Advantages of Monolithic Apps

- easy to conceptually understand
- easy to test as a single unit (to a point)
- easy to deploy as a single unit (to a point)
- easy to maintain (to a point)
- complexity managed by language constructs

---
## Disadvantages of Monolithic Apps

- large applications are difficult to scale, maintain, and deploy
	
- difficult for a single team to manage to large codebase
  - managing large teams comes with its own challenges (Amazon's "2 Pizza" Rule)
	
- difficult to support new types of requesting devices (mobile, wearables, traditional browser)
	
- language/framework lock
  - refactoring the app into a different language or framework is more work than it is worth

- difficult/impossible to take advantage of new persistence models (bound to the model chosen)
  - Search would be best supported by a model similar to ElasticSearch
  - Product reviews would be best supported by a non-relational DB, like MongoDB
  - Customer information would be best supported by a relational DB, like Oracle
  - Payment processing would be best supported by a third-party provider like PayPal

---
---
# Microservice Architecture (MSA)

- services encapsulate business capabilities
  - not based on technology stack
  - vertical slices by business function (i.e. cart, catalog, checkout, etc.)
  - suitable for cross-functional teams
		
- services are small, independently deployable applications
  - not a single codebase
  - more easily managed, altered, tested, deployed, and comprehended
  - not necessarily a single language or framework 
    - each service uses its own data persistence model (Polyglot Persistance)
		
- changes scoped to their affected service
  - services are independent of one another

- communication based on lightweight protocols
  - HTTP, TCP, UDP, Messaging, etc.
    - Payloads: JSON, BSON, XML, Protocol Buffers, etc.
		
  - forces the design of clear interfaces
			
  - data is transferred between services via APIs - not a common DB

---
## Advantages of MSA

- very easy to thoroughly comprehend each service
- very east to test, deploy, manage, and scale individual services
- services are decoupled from one another; no single-point of failure
- easier for management to scale staffing requirements
- no language/framework or persistence model lock

---
## Disadvantages of MSA

- complexity has moved out of the application, but into the operations layer
  - [Fallacies of Distributed Computing](https://en.wikipedia.org/wiki/Fallacies_of_distributed_computing)

- Services may be unavailable
  - never needed to worry about this in a monolith
  - much more monitoring needed
  - design for failure, circuit breaker patterns
    - "Everything fails all the time" - Werner Vogels, CTO Amazon
				
- Remote calls are more expensive than in-process calls
  - Chatty interfaces
			
- Transactions are absent when data is spread across services
  - Must rely on BASE (**B**asic **A**vailability, **S**oft state, and **E**ventual Consistency)
			
- Some features can span several services
  - makes testing much more difficult
  - change management becomes a separate challenge
  - need to consider the interaction of services
  - dependency management
  - refactoring module boundaries (deconstructing/combining services)