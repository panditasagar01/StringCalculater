package com.assignment;

import com.assignment.exception.DelimiterNotFoundException;
import com.assignment.exception.NegativeNumberFoundException;
import com.assignment.service.StringCalculatorService;
import com.assignment.service.StringCalculatorServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringCalculatorApplication {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringCalculatorService stringCalculatorService = new StringCalculatorServiceImpl();
        System.out.println("String Calculator started successfully, To Stop type exit");
        do {
            System.out.println("Enter the Input in String format");
            String input = reader.readLine();
            if (input.equalsIgnoreCase("exit")) {
                System.exit(0);
            }
            try {
                int output = stringCalculatorService.calculate(input);
                System.out.println("Sum = " + output);
            } catch (NegativeNumberFoundException | DelimiterNotFoundException e) {
                System.out.println(e.getMessage());
            }

        } while (true);
    }
}
