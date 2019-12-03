package com.tddtest.lambda;

import org.apache.commons.lang.WordUtils;

/**
 * @author Frank Yu
 * @date 8/23/2019
 */
public class LambdaTwo {
    public static void main(String[] args) {
        String test = "jjjjj";
        String test1 = "JJJJJ";
        String test2 = "Jjjjj";
        String test3 = "";

//        System.out.println(test);
//        System.out.println(test1.toUpperCase());
//        System.out.println(WordUtils.uncapitalize(test1));
        System.out.println(WordUtils.capitalizeFully(test1));
        System.out.println(WordUtils.capitalizeFully(test));
        System.out.println(WordUtils.capitalizeFully(test2));
        System.out.println("t"+WordUtils.capitalizeFully(test3));

    }
}
