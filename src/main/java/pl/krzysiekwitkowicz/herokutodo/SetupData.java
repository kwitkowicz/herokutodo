package pl.krzysiekwitkowicz.herokutodo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import pl.krzysiekwitkowicz.herokutodo.dao.TodoRepository;
import pl.krzysiekwitkowicz.herokutodo.dao.UserRepository;
import pl.krzysiekwitkowicz.herokutodo.model.Todo;
import pl.krzysiekwitkowicz.herokutodo.model.User;

import javax.annotation.PostConstruct;

@Profile("dev")
@Component
public class SetupData {
    @Autowired
    BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    TodoRepository todoRepository;

    @PostConstruct
    public void init() {
        final User user = new User();
        user.setLogin("jan");
        user.setName("Jan Nowak");
        user.setPassword(passwordEncoder.encode("123"));
        user.setRole("USER");

        userRepository.save(user);

        Todo todo = new Todo();
        todo.setName("My task");
        todo.setCompleted(false);
        todo.setUser(user);
        todoRepository.save(todo);

    }
}
