package com.registerapp.registerServerAPI;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@WithMockUser(username = "grazyna@kalman.pl", password = "12345") //scisle tajny user testowy
public class GetClassTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldGetSingleClassOfStudents() throws Exception{
        //given

        //when
        MvcResult mvcResult = mockMvc.perform(get("/api/v1/students/class/1").header(HttpHeaders.AUTHORIZATION, "Bearer eyJhbGciOiJIUzUxMiJ9.eyJyb2xlcyI6WyJST0xFX1VTRVIiLCJST0xFX1RFQUNIRVIiXSwic3ViIjoiZ3JhenluYUBrYWxtYW4ucGwiLCJpYXQiOjE2Njk2NzM3ODIsImV4cCI6MTY2OTc2MDE4Mn0.6SJe0uNxSkotR9QipWk6KTpvVcKfTh70h-3DyKQ9l8iIHg7bXDrJ5K5GAXZcACe6Am2uYiCmvjt8WjwdGLgiKg"))
                .andDo(print())
                .andExpect(status().is(200))
                .andReturn();
        //then
        Class klasa = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), Class.class);
        assertThat(klasa).isNotNull();

    }
}
