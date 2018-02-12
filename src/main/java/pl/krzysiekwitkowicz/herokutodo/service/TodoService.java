package pl.krzysiekwitkowicz.herokutodo.service;

import org.springframework.ui.Model;

import java.security.Principal;

public interface TodoService {
    void findTodoByUserIdAndCompleted(Model model, Principal principal);

    void addTodo(String value, Principal principal);

    void updateTodo(String value);
}
