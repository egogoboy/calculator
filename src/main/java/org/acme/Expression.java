package org.acme;

public class Expression {

    final private Double firstNum;
    final private Double secondNum;
    final private String operator;

    public Expression(double firstNum, double secondNum, String operator) {
        this.firstNum = firstNum;
        this.secondNum = secondNum;
        this.operator = operator;
    }

    public double getFirstNum() {
        return firstNum;
    }
    public double getSecondNum() {
        return secondNum;
    }
    public String getOperator() {
        return operator;
    }

}
