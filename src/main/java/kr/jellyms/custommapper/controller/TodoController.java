package kr.jellyms.custommapper.controller;

import kr.jellyms.custommapper.dto.TodoDto;
import kr.jellyms.custommapper.model.Todo;
import kr.jellyms.custommapper.service.TodoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(TodoController.RESOURCES_PREFIX)
@Slf4j
public class TodoController {
    static final String RESOURCES_PREFIX = "/todos";

    private final TodoService todoService;

    public TodoController(final TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping("")
    public ResponseEntity<Todo> create(@RequestBody final TodoDto.Create todo) {
        log.info("Title: " + todo.getTitle());
        log.info("Description: " + todo.getDescription());

        log.info(String.valueOf(
                todo.getTitle().equals(todo.getTitle().trim())));
        log.info(String.valueOf(
                todo.getDescription().equals(todo.getDescription().trim())));

        final Todo created = todoService.create(todo);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

}
