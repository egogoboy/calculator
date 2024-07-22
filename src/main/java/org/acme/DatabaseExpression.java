package org.acme;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

import java.util.Objects;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "expressions")
public class DatabaseExpression extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "first_num")
    private Double firstNum;

    @Column(name = "second_num")
    private Double secondNum;

    @Column
    private String operation;

    public DatabaseExpression() {
    }

    public DatabaseExpression(Expression expression) {
        this.firstNum = expression.getFirstNum();
        this.secondNum = expression.getSecondNum();
        this.operation = expression.getOperation();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getFirstNum() {
        return firstNum;
    }

    public void setFirstNum(Double firstNum) {
        this.firstNum = firstNum;
    }

    public Double getSecondNum() {
        return secondNum;
    }

    public void setSecondNum(Double secondNum) {
        this.secondNum = secondNum;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DatabaseExpression that = (DatabaseExpression) o;
        return Objects.equals(id, that.id) && Objects.equals(firstNum, that.firstNum) && Objects.equals(secondNum, that.secondNum) && Objects.equals(operation, that.operation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstNum, secondNum, operation);
    }
}
