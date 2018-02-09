package pl.krzysiekwitkowicz.herokutodo.service;

import org.springframework.beans.factory.annotation.Autowired;
import pl.krzysiekwitkowicz.herokutodo.dao.TodoRepository;

public class TodServiceImpl implements TodoService {
    @Autowired
    TodoRepository todoRepository;
}
