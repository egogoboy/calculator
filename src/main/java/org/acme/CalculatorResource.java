package org.acme;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/calculator")
public class CalculatorResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<DatabaseExpression> getAllExpressions() {
        return DatabaseExpression.findAll().list();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    //@Consumes(MediaType.APPLICATION_JSON)
    public ResultOfCalculation Calculate(Expression expression) throws NumberFormatException {
        try {
            ResultOfCalculation result = new ResultOfCalculation();
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
                        result.setError("Деление на ноль");
                    }
                    break;
                case "":
                    result.setError("where is operator?");
                    break;
                default:
                    result.setError("Неверный оператор");
                    break;
            }
            return result;
        }
        catch (NullPointerException e) {
            System.out.println(e.getMessage());
            System.out.println(expression.getFirstNum());
            System.out.println(expression.getSecondNum());
            System.out.println(expression.getOperator());
            return new ResultOfCalculation();
        }
    }
}