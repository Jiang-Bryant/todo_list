package com.tddtest.romanTest;


import com.tddtest.service.IRomanNumerals;
import com.tddtest.service.RomanNumerals;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RomanNumeralsTest {


    IRomanNumerals romanNumerals = new RomanNumerals(); // 待测试的对象
    // 1.测试用例命名统一使用小写加下划线命名方式，而且遵循以下格式：
// 2.should_return_sth_when_toRoman_given_input
// 3.以下测试用例可以描述为：当我输入数字1是，期望得到罗马数字I
    @Test
    public void should_return_I_when_to_roman_given_1() {
        //断言
        assertEquals("I", romanNumerals.toRoman(1));
    }
    // 4.以下测试用例可以描述为：当我输入数字2是，期望得到罗马数字II
    @Test
    public void should_return_II_when_to_roman_given_2() {
        assertEquals("II", romanNumerals.toRoman(2));
    }
    // 5.以下测试用例可以描述为：当我输入数字3是，期望得到罗马数字III
    @Test
    public void should_return_III_when_to_roman_given_3() {
        assertEquals("III", romanNumerals.toRoman(3));
    }
}
