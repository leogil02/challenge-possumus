package com.leonardogil.challenge_possumus_tech.infrastructure.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class RomanNumeralControllerIntTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void validRomanToIntInputStatusCode200() throws Exception {
        mvc.perform(get("/api/roman-numeral/to-int/XIX"))
                .andExpect(status().isOk())
                .andExpect(content().string("19"));
    }

    @Test
    void invalidRomanToIntInputStatusCode400() throws Exception {
        mvc.perform(get("/api/roman-numeral/to-int/XXXX"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void validIntToRomanInputStatusCode200() throws Exception {
        mvc.perform(get("/api/roman-numeral/to-roman/19"))
                .andExpect(status().isOk())
                .andExpect(content().string("XIX"));
    }

    @Test
    void invalidIntToRomanInputStatusCode400() throws Exception {
        mvc.perform(get("/api/roman-numeral/to-roman/4000"))
                .andExpect(status().isBadRequest());
    }

}
