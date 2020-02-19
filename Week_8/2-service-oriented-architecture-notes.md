# Service-Oriented Architecture (SOA)
---

SOA is a style of software design where services are provided to the other components by application components, through a communication protocol over a network. The basic principles of service-oriented architecture are independent of vendors, products and technologies. A service is a discrete unit of functionality that can be accessed remotely and acted upon and updated independently, such as retrieving a credit card statement online.

A service has four properties according to one of many definitions of SOA:

- Services logically represents a business activity with a specified outcome
- Loosely-coupled; individual services are self-contained and not dependent upon other services
- Abstraction; a black box for its consumers
- It may consist of other underlying services.

---
## Priorities of SOA

- Business value over technical strategy 
- Strategic goals over project-specific benefits 
- Intrinsic interoperability over custom integration 
- Shared services over specific-purpose implementations 
- Flexibility over optimization 
- Evolutionary refinement over pursuit of initial perfection

---
## Enterprise Service Bus (ESB)

An ESB is a middleware tool used to distribute work among connected components of an application. ESBs are designed to provide a uniform means of moving work, offering applications the ability to connect to the bus and subscribe to messages based on simple structural and business policy rules.

As such, it's a tool that has use in both distributed computing and component integration. The best way to think of this tool is to visualize it as a set of switches that can direct a message along a specific route between application components based on message contents and implementation or business policies.

![Enterprise Service Bus Diagram](https://www.hcltech.com/sites/default/files/images/esb_architecture.png?itok=tt5gIUR4)

### References

[SOA Manifesto](http://www.soa-manifesto.org/)
[Enterprise Service Bus](https://searchmicroservices.techtarget.com/definition/enterprise-service-bus-ESB)