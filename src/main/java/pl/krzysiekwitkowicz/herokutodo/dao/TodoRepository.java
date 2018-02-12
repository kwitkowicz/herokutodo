package pl.krzysiekwitkowicz.herokutodo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.krzysiekwitkowicz.herokutodo.model.Todo;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, LinkageError> {
    List<Todo> findByCompletedAndUserId(boolean completed, Long id);

    Todo findByName(String name);
}
