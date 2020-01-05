package com.softuni.entity;

public class Calculator {
    private double leftOperand;
    private double rightOperand;
    private String operator;
    private double result;

    public Calculator() {
    }

    public Calculator(double leftOperand, double rightOperand, String operator) {
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
        this.operator = operator;
    }

    public double calculateResult(){
        double result = 0.0;
        if(operator.equals("+")){
            result = leftOperand + rightOperand;
        }else if(operator.equals("-")){
            result = leftOperand - rightOperand;
        }else if(operator.equals("*")){
            result = leftOperand * rightOperand;
        }else if(operator.equals("/")){
            result = leftOperand / rightOperand;
        }
        this.result = result;
        return result;
    }

    public double getLeftOperand() {
        return leftOperand;
    }

    public double getRightOperand() {
        return rightOperand;
    }

    public String getOperator() {
        return operator;
    }

    public double getResult() {
        return result;
    }
}
