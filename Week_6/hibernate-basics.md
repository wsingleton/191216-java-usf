# Hibernate

Hibernate is an **Object/Relational Mapping (ORM)** solution for Java environments. ORM refers to the technique of mapping data from an object model representation to a relational data model representation (and vice versa). Hibernate not only takes care of the mapping from Java classes to database tables (and from Java data types to SQL data types), but also provides data query and retrieval facilities. It can significantly reduce development time otherwise spent with manual data handling in SQL and JDBC.

---

## Hibernate API - Core Classes and Interfaces

The Hibernate framework is huge, and there are hundreds of classes and interfaces included within it. However, we can condense this massive framework into a set of core classes and interfaces to help us understand it better. The following are these core classes and interfaces, along with brief descriptions of their functionality within the framework.

#### Configuration (class)

Used to specify properties and mapping documents to be used when creating a `SessionFactory`.

#### SessionFactory (interface)

Primarily used for the creation of `Session` instances. An application usually only has a single `SessionFactory` instance and threads servicing client requests obtain `Session` instances from this factory.

#### Session (interface)

The main runtime interface between a Java application and Hibernate. The lifecycle of a `Session` is bounded by the beginning and end of a logical transaction. The main function of the `Session` is to offer create, read, update, and delete operations for instances of mapped entity classes.

#### Transaction (interface)

Defines the contract for abstracting applications from the configured underlying means of transaction management. Allows the application to define units of work, while maintaining abstraction from the underlying transaction implementation. A transaction is associated with a `Session` and is usually initiated by a call to `beginTransaction()`.

#### Query (interface)

Represents an HQL/JPQL query, whether it be a HQL/JPQL string literal, a pre-declared named query or named native query, or a compiled `Criteria` query. 

#### CriteriaQuery, CriteriaUpdate, CriteriaDelete (interfaces)

Introduced in Hibernate v5 as a replacement to the Hibernate-specific `Criteria` API. These APIs adhere to the JPA sepcification as a way to build queries in a programmatic manner, allowing for the addition of `Restrictions` (comparisons and conditional clauses) and `Projections` (aggregate functions), for more advanced data fetching and manipulation.
