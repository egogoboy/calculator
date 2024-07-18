package org.acme;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/calculator")
public class CalculatorResource {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    //@Consumes(MediaType.APPLICATION_JSON)
    public TempExpression Calculate(Expression expression) throws NumberFormatException {
        try {
            TempExpression result = new TempExpression(expression.getFirstNum(), expression.getSecondNum(), expression.getOperator(), "");
            switch (expression.getOperator()) {
                case "+":
                    result.setResult(expression.getFirstNum() + expression.getSecondNum());
                    break;
                case "-":
                    result.setResult(expression.getFirstNum() - expression.getSecondNum());
                    break;
                case "*":
                    result.setResult(expression.getFirstNum() * expression.getSecondNum());
                    break;
                case "/":
                    if (expression.getSecondNum() != 0)
                        result.setResult(expression.getFirstNum() / expression.getSecondNum());
                    else {
                        result.setResult("Деление на ноль");
                    }
                    break;
                case "":
                    result.setResult("where is operator?");
                    break;
                default:
                    result.setResult("Неверный оператор");
                    break;
            }
            return result;
        }
        catch (NullPointerException e) {
            System.out.println(e.getMessage());
            System.out.println(expression.getFirstNum());
            System.out.println(expression.getSecondNum());
            System.out.println(expression.getOperator());
            return new TempExpression(expression.getFirstNum(), expression.getSecondNum(), expression.getOperator(), "");
        }
    }
}