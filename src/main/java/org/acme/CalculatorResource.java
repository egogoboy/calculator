package org.acme;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.jboss.resteasy.reactive.server.multipart.MultipartPartReadingException;

@Path("/calculator")
public class CalculatorResource {

    @POST
    @Produces(MediaType.APPLICATION_JSON)

    public String Calculate(Expression expression) throws MultipartPartReadingException {
        try {
            String result = "{\n    \"result\": ";
            result = switch (expression.getOperator()) {
                case '+' -> result + (expression.getFirstNum() + expression.getSecondNum());
                case '-' -> result + (expression.getFirstNum() - expression.getSecondNum());
                case '*' -> result + (expression.getFirstNum() * expression.getSecondNum());
                case '/' -> result + (expression.getFirstNum() / expression.getSecondNum());
                default -> result + "Wrong operator";
            };
            result = result  + "\n}";
            return result;
        }
        catch (MultipartPartReadingException e) {
            return e.getMessage();
        }
    }

}
