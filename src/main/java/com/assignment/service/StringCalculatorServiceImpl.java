package com.assignment.service;


import com.assignment.exception.DelimiterNotFoundException;
import com.assignment.exception.NegativeNumberFoundException;
import com.assignment.util.Utility;

import java.util.Arrays;

public class StringCalculatorServiceImpl implements StringCalculatorService {

    public int calculate(String input) {

        if (input == null || input.isBlank()) {
            return 0;
        }
        String delimiter = Utility.parseDelimiter(input);
        if (delimiter == null) throw new DelimiterNotFoundException("No Delimiter found in the Provided Input");

        return Arrays.stream(input.split(delimiter))
                .map(String::strip)
                .mapToInt(Integer::parseInt)
                .filter(n -> n <= 100)
                .peek(StringCalculatorServiceImpl::accept)
                .sum();

    }

    private static void accept(int n) throws NegativeNumberFoundException {
        if (n < 0)
         throw new NegativeNumberFoundException("Negatives are not allowed, Please retry with non negative Strings");
    }
}
