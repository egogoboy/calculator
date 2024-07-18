package org.acme;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "expressions")
public class DatabaseExpression {

    @Column
    @Id
    private double firstNum;

    @Column
    private double secondNum;

    @Column
    private String operation;

    public DatabaseExpression(){}

    public void setFirstNum(double firstNum) {
        this.firstNum = firstNum;
    }

    public void setSecondNum(double secondNum) {
        this.secondNum = secondNum;
    }

    public void setOperation(String operation) {
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
