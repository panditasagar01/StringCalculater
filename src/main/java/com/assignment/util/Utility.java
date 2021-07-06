package com.assignment.util;

public class Utility {

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
    public static String parseDelimiter(String input) {
        for(int i = 1; i < input.length(); i++) {
            if (!isNumeric(input.substring(i,i+1))) {
                return input.substring(i, i+1);
            }
        }
        return null;
    }
}
