package pl.krzysiekwitkowicz.herokutodo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import pl.krzysiekwitkowicz.herokutodo.dao.TodoRepository;
import pl.krzysiekwitkowicz.herokutodo.model.Todo;
import pl.krzysiekwitkowicz.herokutodo.model.User;

import java.security.Principal;
@Service
public class TodoServiceImpl implements TodoService {
    @Autowired
    TodoRepository todoRepository;
    @Autowired
    UserService userService;

    @Override
    public void findTodoByUserIdAndCompleted(Model model, Principal principal) {
        Long userId = userService.findByLogin(principal.getName()).getId();
        model.addAttribute("myTodosList",
                todoRepository.findByCompletedAndUserId(false, userId));
        model.addAttribute("myCompletedTodosList",
                todoRepository.findByCompletedAndUserId(true,userId));
    }

    @Override
    public void addTodo(String value, Principal principal) {
        User user = userService.findByLogin(principal.getName());

        Todo todo = new Todo();
        todo.setId((long) 0);
        todo.setName(value);
        todo.setCompleted(false);
        todo.setUser(user);

        todoRepository.save(todo);
    }

    @Override
    public void updateTodo(String value) {
        Todo todo = todoRepository.findByName(value);
        todo.setCompleted(true);

        todoRepository.save(todo);
    }
}
