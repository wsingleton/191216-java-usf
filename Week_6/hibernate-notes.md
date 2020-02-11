# Entity lifecycle

- Detach
  - The entity is not associated with a Hibernate session
	

- Merge
  - If the entity is detached from a session, then merge will reattach it to a session


- Persist
  - Transitions new instances to managed stated. The next flush or commit will save it to the DB
  - Flushing the session forces Hibernate to synchronize the in-memory state of the Session with the database


- Remove
  - Transitions managed entity to be removed. The next flush or commit will delete it from the DB


- Refresh
  - Reloads, or syncs, the object with data from the DB. Prevents stale data

---

# Cascade Types

- PERSIST
  - If the entity is persisted/saved, the related entity will also be persisted


- REMOVE
  - If the entity is removed/deleted, the related entity will also be deleted


- REFRESH
  - If the entity is refeshed, the related entity will also be refreshed		


- DETACH
  - If the entity is detached from the session, the related entity will also be detached


- MERGE
  - If the entity is merged, the related entity will also be merged


- ALL
  - All of the above cascade types

---

# Common Session methods

- persist()
  - does not guarantee that the identifier value will be assigned to the persistent object immediately. The assignment might happen on the next flush(). 
  - does guarantee that it will not execute an INSERT statement if it is called outside of transaction boundaries. This is useful in long-running conversations with an extended Session/persistence context.


- save()
  - does guarantee that the identifier value will be assigned to the object immediately
  - does not require INSERT statements to be executed within transaction boundaries. This is not good in a long-running conversation with an extended Session/persistence context.


- saveOrUpdate()
  - results into insert or update queries based on the provided data. If the data is present in the DB, update query is executed.


- update()
  - should be used where we know that we are only updating the entity information
  - acts upon passed object; the update method transitions the passed object from detached to persistent state;
  - throws an exception if you pass it a transient entity.


- merge()
  - finds an entity instance by id taken from the passed object (either an existing entity instance from the persistence context is retrieved, or a new instance loaded from the database);
  - copies fields from the passed object to this instance;
  - returns newly updated instance.

---

### Extra References

[Baeldung - Hibernate: save, persist, update, merge, saveOrUpdate](https://www.baeldung.com/hibernate-save-persist-update-merge-saveorupdate)