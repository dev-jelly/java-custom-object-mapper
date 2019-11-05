package kr.jellyms.custommapper.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import kr.jellyms.custommapper.dto.TodoDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
class TodoControllerTests {

    @Autowired
    private MockMvc mvc;

    @Test
    void createTodoTrim() throws Exception {
        TodoDto.Create todo = new TodoDto.Create();

        todo.setTitle(" blah~~~~             ");
        todo.setDescription(" blah~~~~  blah~~~~blah~~~~blah~~~~                                      ");
        todo.setDone(false);

        final String trimTitle = todo.getTitle().trim();
        final String trimDescription = todo.getDescription().trim();

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(todo);

        mvc.perform(post(TodoController.RESOURCES_PREFIX)
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isCreated())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.title", is(trimTitle)))
                .andExpect(jsonPath("$.description", is(trimDescription)))
                .andExpect(jsonPath("$.done", is(false)));


    }
}
