package com.assignment.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringCalculatorServiceImplTest {

    private StringCalculatorService stringCalculatorService;

    @BeforeEach
    void setup() {
        stringCalculatorService = new StringCalculatorServiceImpl();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "''; 0",
            "; 0",
            "7,7;14",
            "'22,11,45,22,101';100",
            "'144,6';6",
            "'1%2%3';6",
            "'1 20 3';24",
            "'12345%';0",
            "'1!2!3';6"
    }, delimiter = ';')
    void shouldReturnCorrectOutput(String input, int output) {
        assertEquals(output, stringCalculatorService.calculate(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"199", "1%-4%3"})
    void shouldThrowException(String input) {
        assertThrows(RuntimeException.class, () -> stringCalculatorService.calculate(input));
    }
}
