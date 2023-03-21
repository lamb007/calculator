package com.example.calculator.utils;

import com.eclipsesource.v8.V8;

public class Calculator {

    private V8 v8;

    public Calculator() {
        v8 = V8.createV8Runtime();
    }

    public double executeExpression(String expression) {
        String script = "function calculate() {\n" +
                "   return " + expression + ";\n" +
                "}\n" +
                "calculate();";
        Object result = v8.executeScript(script);
        double resultNum = ((Number)result).doubleValue();
        return resultNum;
    }

    public void release() {
        v8.release();
    }
}
