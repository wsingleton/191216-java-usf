# Software Architecture

ISO/IEC/IEEE 42010:2011 defines software arechitecture as: 

> The fundamental concepts or properties of a system in its environment embodied in its elements, relationships, and in the principles of its design and evolution. The environment of the system can be described as the context determining the setting and circumstances of all influences upon a system.

![software-arch-fig-1](https://revature-note-assets.s3.amazonaws.com/software-architecture-fig-1.png)

---

## Common Architectural Patterns

An architectural pattern or style defines an organized structure of subsystems, a vocabulary of components and connectors, with constraints on how they can be combined. Common architectural patterns include:

- Object-Oriented Architecture
- Component-Based Architecture
- Service-Based Architecture

#### Object-Oriented Architecture

Systems developed based on object-oriented methodologies, modeling notions, and programming languages are often structured as a kind of Object-Oriented Architecture (OOA). Major characteristics of OOA include: 

- Based on OO principles, most notably encapsulation, inheritance, and polymorphism.

- Classes of objects are the software units of modeling, design and implementation.

- Objects and their interactions are the center of concerns in architecture design.

- Separation of interfaces from implementations.

- Transparency of distributed objects (i.e. remote objects can be referenced and used in the same way as local objects)


#### Component-Based Architecture 

Large scale distributed systems are complex and labor intensive to develop and maintain. This gave rise to the idea that large scale distributed systems should be integrated from independently developed, well-tested, reusable software components. 

> Component-based software development (CBSD) considers components as both a modeling concept and an implementation unit in software development.

Component-based application servers and integration servers based on component models like J2EE, Pivotal Spring, and Microsoft .NET offer standard platforms and services for deploying business components in distributed enterprise systems. Systems developed based on CBSD are often structured as a kind of Component-Based Architecture (CBA). Major characteristics of CBA include: 

- Based on component models.

- Interfaces and interactions are the center of concerns in architecture design.

- Separation of interfaces from implementations.

- Introspection, which is the ability of a program to examine the type or properties of an object at runtime.

- Emphasize design patterns and the principle of separation of concerns for defining component roles and responsibilities. 

---

#### Service-Based Architecture

Enterprise systems face a number of challenges including seamless integration of various systems, allowing data access from anywhere anytime, and providing services to customers and partners inside and outside the enterprise. In addition to system functionality, quality considerations like extensibility, flexibility, connectivity, and interoperability also demand enterprise functions to be easily accessed via published interfaces and to be easily composed in order to offer value-added services. Services are the software units of modeling, design and implementation. 

> A service is a software entity that encapsulates business functionality and provides the functionality to others through well-defined and published interfaces. 

One way to meet these challenges and demands is to consider a system as a composition of a collection of interacting services. Each service provides mechanism to access its functionality via well-defined interfaces. Systems developed based on such services are often structured as a kind of Service-Based Architecture (SBA). The characteristics of SBA include: 

- ***Loose coupling***

  - A service can receive and respond to requests from any source. The functionality of the service can be expanded or replaced, independent of its requesters. Requesters can dynamically discover and utilize services, any time and anywhere.

- ***Statelessness***
  - A service is not required to remember anything from one invocation to another. States are either stored as part of service data in database or passed from requesters. This not only helps with scalability and testability, but also allows for better maintenance.

- ***Service Abstraction***
  - The services act as black boxes, that is their inner logic is hidden from the consumers.

- ***Standardized service contract***
  
  - Service definitions, descriptions, discovery, access protocols, and their quality aspects (e.g., security) are the central concerns in architectural design.
  
  - Services are self-describing. A service exposes its capabilities including functionality, data, and Quality of Services (QoS) characteristics through service descriptions in languages such as Web Services Description Language (WSDL).
  
- ***Service Discovery***
  - Services can be independently and dynamically discovered and
used through the use of any one of various discovery mechanism (e.g. UDDI)

---

## Choosing An Architecture

OOA, CBA, and SBA have different features and benefits and may be used in a complementary manner. From an implementation perspective, a service’s functionality is implemented by components and how it is implemented affects its quality properties. Similarly, a component’s functionality is decomposed into one or more objects as it is implemented in an object-oriented programming language. It is clear that these paradigms can co-exist in enterprise systems and they have different roles in terms of features and benefits. However, these paradigms have different focuses with regard to architectural design decisions. They have different but related concepts and they have different features, benefits and concerns, as listed in the table below.

![software-arch-fig-2](https://revature-note-assets.s3.amazonaws.com/software-architecture-fig-2.png)

Each of the architecture paradigms has its unique concepts, characteristics, features, and benefits. Separation of concerns, modularity, abstraction, anticipation of change, and evaluation of design alternatives are some of the general software engineering principles useful in designing an application architecture based on one of the three paradigms. Because every one of the paradigms has embodied these principles, we need additional practical principles to guide us to make sound architectural design decisions. We can derive three principles from the software engineering practices:

1. Understand the ***Purpose and Scope*** of the application. 

   - Define the intended customers, boundaries with other applications, operating environments, and properties of application domains. 
   
    - This principle requires us to understand issues like what the customers want, what constraints the operating environments have, and how the application intends to interact with others. 

2. Know the ***Desired Quality Attributes***. 

    - Key attributes to focus on particularly are the performance, flexibility, extensibility, sustainability, openness, and interoperability, from the stakeholders. 
    
    - The desired quality attributes are then matched against the features and benefits of the architecture paradigms as summarized in the above table.

3. Define ***Use Case Scenarios for Interfaces***. 
  
    - Interfaces are a key concept common to all of the paradigms, yet it is independent of the core concept of Object, Component, and Service, respectively in each of them. A software unit, an object, a component, or a service implements interfaces. 
    
    - Use case scenarios for interfaces help clarify the roles, responsibilities, interaction characteristics, and expected properties of the software units and thus help identify which of the three types of software units is best suited for the application.


---

### Bibliography

[Guijun Wang and C. K. Fung, "Architecture paradigms and their influences and impacts on component-based software systems," 37th Annual Hawaii International Conference on System Sciences, 2004. Proceedings of the, Big Island, HI, 2004, pp. 10 pp.](https://sci-hub.tw/10.1109/HICSS.2004.1265643)

["ISO/IEC/IEEE 42010:2011 - Systems and software engineering - Architecture description". International Organization for Standardization. 2011-11-24. Retrieved 2020-02-15.](http://cabibbo.dia.uniroma3.it/asw/altrui/iso-iec-ieee-42010-2011.pdf)