package repos;

import java.util.Optional;
import java.util.Set;

public interface CrudRepository<T> {

    T save(T newObj);
    Set<T> findAll();
    Optional<T> findById(int id);
    boolean update(T updatedObj);
    boolean deleteById(int id);
}
