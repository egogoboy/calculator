package org.acme;

public class Expression {

    final private Double firstNum;
    final private Double secondNum;
    final private String operation;

    public Expression(double firstNum, double secondNum, String operation) {
        this.firstNum = firstNum;
        this.secondNum = secondNum;
        this.operation = operation;
    }

    public double getFirstNum() {
        return firstNum;
    }
    public double getSecondNum() {
        return secondNum;
    }
    public String getOperation() {
        return operation;
    }

}
