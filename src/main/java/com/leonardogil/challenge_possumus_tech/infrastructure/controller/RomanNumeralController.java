package com.leonardogil.challenge_possumus_tech.infrastructure.controller;

import com.leonardogil.challenge_possumus_tech.application.service.IRomanNumeralService;
import com.leonardogil.challenge_possumus_tech.application.validation.annotation.ValidRomanNumeral;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Tag(name = "Conversores", description = "Endpoints para convertir números romanos a enteros y viceversa")
@RequestMapping("/api/roman-numeral")
public class RomanNumeralController {

    private final IRomanNumeralService romanNumeralService;

    @Operation(summary = "Convierte número romano en número entero")
    @GetMapping("/to-int/{romanNumber}")
    public ResponseEntity<Integer> convertRomanToInt(@ValidRomanNumeral @PathVariable String romanNumber){
        return ResponseEntity.ok(romanNumeralService.toInteger(romanNumber));
    }

    @Operation(summary = "Convierte número entero en número romano")
    @GetMapping("/to-roman/{intNumber}")
    public ResponseEntity<String> convertIntToRoman(@PathVariable Integer intNumber){
        return ResponseEntity.ok(romanNumeralService.toRoman(intNumber));
    }

}