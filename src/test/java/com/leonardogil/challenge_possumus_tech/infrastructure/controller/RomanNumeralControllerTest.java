package com.leonardogil.challenge_possumus_tech.infrastructure.controller;

import com.leonardogil.challenge_possumus_tech.application.service.IRomanNumeralService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@WebMvcTest(RomanNumeralController.class)
class RomanNumeralControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private IRomanNumeralService romanNumeralService;

    @Test
    void convertRomanToInteger() throws Exception {
        when(romanNumeralService.toInteger("X")).thenReturn(10);
        mockMvc.perform(get("/api/roman-numeral/to-int/X"))
                .andExpect(status().isOk())
                .andExpect(content().string("10"));
    }

    @Test
    void convertIntegerToRoman() throws Exception {
        when(romanNumeralService.toRoman(10)).thenReturn("X");
        mockMvc.perform(get("/api/roman-numeral/to-roman/10"))
                .andExpect(status().isOk())
                .andExpect(content().string("X"));
    }

}