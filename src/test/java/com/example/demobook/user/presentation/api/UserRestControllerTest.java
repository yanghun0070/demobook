package com.example.demobook.user.presentation.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserRestControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @Test
    public void join() throws Exception {
        String jsonParam = "{\n" +
                "\"userId\": \"test\"\n" +
                "\"password\": \"test\"\n" +
                "}";

        System.out.println(jsonParam);
        this.mockMvc.perform(
            post("/user/join")
                .contentType(MediaType.APPLICATION_JSON).content(jsonParam))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
