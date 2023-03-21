package com.example.calculator;



import org.junit.Test;

import static org.junit.Assert.*;

import com.example.calculator.utils.Calculator;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        Calculator calculator = new Calculator();
        System.out.println(isDoubleEquals(-39.5, calculator.executeExpression(" -9 + 8 ")));

    }
    private static boolean isDoubleEquals (double value1, double value2) {
        System.out.println("正确结果=" + value1 + ", 实际计算结果=" + value2);
        return Math.abs(value1 - value2) <= 0.0001;
    }
}