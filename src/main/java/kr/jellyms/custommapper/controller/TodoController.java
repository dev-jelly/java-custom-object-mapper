package kr.jellyms.custommapper.controller;

import kr.jellyms.custommapper.dto.TodoDto;
import kr.jellyms.custommapper.model.Todo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @PostMapping("")
    public ResponseEntity<Todo> create(@RequestBody TodoDto.Create todo) {
        System.out.println("Title: " + todo.getTitle());
        System.out.println("Description: " + todo.getDescription());

        System.out.println(todo.getTitle().equals(todo.getTitle().trim()));
        System.out.println(todo.getDescription().equals(todo.getDescription().trim()));


        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
