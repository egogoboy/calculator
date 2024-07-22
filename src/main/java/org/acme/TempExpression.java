package org.acme;

public class TempExpression {

    private Double firstNum;
    private Double secondNum;
    private String operator;
    private String result;

    public TempExpression(double firstNum, double secondNum, String operator, String result) {
        this.firstNum = firstNum;
        this.secondNum = secondNum;
        this.operator = operator;
        this.result = result;
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
    public String getResult() { return result; }

    public void setFirstNum(double firstNum) {
        this.firstNum = firstNum;
    }

    public void setSecondNum(double secondNum) {
        this.secondNum = secondNum;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public void setResult(double result) {
        this.result = Double.toString(result);
    }

    public void setResult(String result) {
        this.result = result;
    }

}
