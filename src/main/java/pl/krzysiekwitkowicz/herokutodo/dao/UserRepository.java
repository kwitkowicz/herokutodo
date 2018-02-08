package pl.krzysiekwitkowicz.herokutodo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.krzysiekwitkowicz.herokutodo.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    public User findByLogin(String login);

    @Query("select u.name from User u where u.login = ?1")
    public String findNameByLogin(String login);
}
