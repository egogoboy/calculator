package org.acme;

import com.fasterxml.jackson.annotation.JsonInclude;

public class ResultOfCalculation {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    //private Double result;
    private String result;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String error;

    ResultOfCalculation() {
        result = null;
        error = null;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getError() {
        return this.error;
    }

    public void setResult(double result) {
        this.result = Double.toString(result);
    }
    /*
    public Double getResult() {
        return result;
    }
    */

    public String getResult() {
        return this.result;
    }
}
