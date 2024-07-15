package org.acme;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/calculator")
public class CalculatorResource {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    //@Consumes(MediaType.APPLICATION_JSON)
    public ResultOfCalculation Calculate(Expression expression) {
        ResultOfCalculation result = new ResultOfCalculation();
        switch (expression.getOperator()) {
            case '+':
                result.setResult(expression.getFirstNum() + expression.getSecondNum());
            break;
            case '-':
                result.setResult(expression.getFirstNum() - expression.getSecondNum());
            break;
            case '*':
                result.setResult(expression.getFirstNum() * expression.getSecondNum());
            break;
            case '/':
                if (expression.getSecondNum() != 0)
                    result.setResult(expression.getFirstNum() / expression.getSecondNum());
                else {
                    result.setError("Деление на ноль");
                }
            break;
            default:
                result.setError("Неверный оператор");
        }
        return result;
    }
}