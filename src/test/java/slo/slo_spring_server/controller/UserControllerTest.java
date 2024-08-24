package slo.slo_spring_server.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void 유저생성_유효성실패() throws Exception {
        String userJson = "{ \"username\": \"testuser\", " +
                "\"password\": \"ValidPass123!\", " +
                "\"nickname\": \"\", " +
                "\"email\": \"test@example.com\", " +
                "\"role\": \"USER\", " +
                "\"gender\": \"MALE\", " +
                "\"status\": \"ACT\", " +
                "\"weight\": 70, " +
                "\"height\": 175, " +
                "\"age\": 25 }";

        ResultActions resultActions = mockMvc.perform(post("/join")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(userJson))
                .andExpect(status().isBadRequest());
    }

    @Test
    void 유저생성_유효성통과() throws Exception {
        String userJson = "{ \"username\": \"tester\", " +
                "\"password\": \"ValidPass123!\", " +
                "\"nickname\": \"tester\", " +
                "\"email\": \"test@example.com\", " +
                "\"role\": \"USER\", " +
                "\"gender\": \"MALE\", " +
                "\"status\": \"ACT\", " +
                "\"weight\": 70, " +
                "\"height\": 175, " +
                "\"age\": 25 }";

        ResultActions resultActions = mockMvc.perform(post("/join")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(userJson))
                .andExpect(status().isOk());
    }
}