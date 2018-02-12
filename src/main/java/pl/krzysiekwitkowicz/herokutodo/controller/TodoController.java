package pl.krzysiekwitkowicz.herokutodo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import pl.krzysiekwitkowicz.herokutodo.service.TodoServiceImpl;

import java.security.Principal;

@Controller
@RequestMapping("/todoList")
public class TodoController {

    @Autowired
    TodoServiceImpl todoService;

    @RequestMapping(method = RequestMethod.GET)
    public String readTodo(Model model, Principal principal) {
        todoService.findTodoByUserIdAndCompleted(model, principal);

        return "todoListPage";
    }

    @RequestMapping(value = "/{value}", method = RequestMethod.POST, produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public void addTodo(@PathVariable("value") String value, Principal principal) {
        todoService.addTodo(value, principal);
        //return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/{value}", method = RequestMethod.PUT, produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public void updateTodo(@PathVariable("value") String value, Principal principal) {
        todoService.updateTodo(value);
    }
}
