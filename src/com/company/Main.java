package com.company;

import com.company.converter.LiteralConverter;
import com.company.exceptions.InvalidInputException;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputString = reader.readLine();
        String inputDataWithoutSpaces = inputString.replaceAll(" ","");
        String[] problemToSolve = inputDataWithoutSpaces.split("[\\+\\-\\*\\/]");
        if (problemToSolve.length != 2) {
            System.exit(0);
        }
        InputValidator validator = new InputValidator();
        String type = null;
        try {
            type = validator.validateTwoNums(problemToSolve[0], problemToSolve[1]);
        } catch (InvalidInputException e) {
            System.exit(0);
        }
        LiteralConverter converter = new LiteralConverter();
        OperPair op = null;
        if (type.equalsIgnoreCase("ROMANIAN")) {
            int firstInt = converter.romanToDecimal(problemToSolve[0]);
            int secondInt = converter.romanToDecimal(problemToSolve[1]);
            op = new OperPair("ROMANIAN", problemToSolve[0], problemToSolve[1], firstInt, secondInt);
        } else {
            op = new OperPair("ARABIC", Integer.parseInt(problemToSolve[0]), Integer.parseInt(problemToSolve[1]));
        }
        String operation = inputDataWithoutSpaces.replaceFirst(problemToSolve[0], "").substring(0, 1);
        System.out.println(op.operate(operation));

    }
}
