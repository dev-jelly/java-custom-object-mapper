package kr.jellyms.custommapper.controller;

import kr.jellyms.custommapper.dto.TodoDto;
import kr.jellyms.custommapper.model.Todo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todos")
@Slf4j
public class TodoController {

    @PostMapping("")
    public ResponseEntity<Todo> create(@RequestBody TodoDto.Create todo) {

        log.info("Title: " + todo.getTitle());
        log.info("Description: " + todo.getDescription());

        log.info(String.valueOf(
                todo.getTitle().equals(todo.getTitle().trim())));
        log.info(String.valueOf(
                todo.getDescription().equals(todo.getDescription().trim())));


        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
