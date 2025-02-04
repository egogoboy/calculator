package org.acme;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/calculator")
public class CalculatorResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public List<DatabaseExpression> getAllExpressions() {

        return DatabaseExpression.findAll().list();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    //@Consumes(MediaType.APPLICATION_JSON)
    public ResultOfCalculation Calculate(Expression expression) throws NumberFormatException {
        try {
            ResultOfCalculation result = new ResultOfCalculation();
            switch (expression.getOperation()) {
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
            DatabaseExpression.persist(new DatabaseExpression(expression));
            return result;
        }
        catch (NullPointerException e) {
            System.out.println(e.getMessage());
            return new ResultOfCalculation();
        }
    }
}