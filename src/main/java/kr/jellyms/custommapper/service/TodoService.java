package kr.jellyms.custommapper.service;

import kr.jellyms.custommapper.dto.TodoDto;
import kr.jellyms.custommapper.model.Todo;
import kr.jellyms.custommapper.repository.TodoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    private final ModelMapper modelMapper;
    private final TodoRepository todoRepository;

    public TodoService(final ModelMapper modelMapper, final TodoRepository todoRepository) {
        this.modelMapper = modelMapper;
        this.todoRepository = todoRepository;
    }

    public Todo create(final TodoDto.Create todo) {
        Todo toCreate = modelMapper.map(todo, Todo.class);
        return todoRepository.save(toCreate);
    }
}
