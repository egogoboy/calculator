package org.acme;

public class Expression {

    private int firstNum;
    private int secondNum;
    private char operator;

    public Expression(int firstNum, int secondNum, char operator) {
        this.firstNum = firstNum;
        this.secondNum = secondNum;
        this.operator = operator;
    }

    public int getFirstNum() {
        return firstNum;
    }
    public int getSecondNum() {
        return secondNum;
    }
    public char getOperator() {
        return operator;
    }

}
