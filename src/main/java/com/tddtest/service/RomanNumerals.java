package com.tddtest.service;

public class RomanNumerals implements  IRomanNumerals {

    @Override
    public String toRoman(int number) {
        String returnStr = "";
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < number; i++) {
            returnStr = builder.append("I").toString();
        }
        return returnStr;
    }
}
