package br.com.mazonhenrique.service;

import br.com.mazonhenrique.exception.UnsupportedMathOperationException;
import org.springframework.stereotype.Service;

@Service
public class MathOperations {

    public Double sum(String numberOne, String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) throw
                new UnsupportedMathOperationException("Please set a numeric value!");
        return converToDouble(numberOne) + converToDouble(numberTwo);
    }

    public Double subtraction(String numberOne, String numberTwo) throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw
                new UnsupportedMathOperationException("Please set a numeric value!");
        return converToDouble(numberOne) - converToDouble(numberTwo);
    }

    public Double multiplication(String numberOne, String numberTwo) throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw
                new UnsupportedMathOperationException("Please set a numeric value!");
        return converToDouble(numberOne) * converToDouble(numberTwo);
    }

    public Double division(String numberOne, String numberTwo) throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw
                new UnsupportedMathOperationException("Please set a numeric value!");
        if (Double.parseDouble(numberTwo) <= 0) throw
                new UnsupportedMathOperationException("Please enter a number greater than zero for division");
        return converToDouble(numberOne) / converToDouble(numberTwo);
    }

    public Double mean(String numberOne, String numberTwo) throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw
                new UnsupportedMathOperationException("Please set a numeric value!");
        return (converToDouble(numberOne) + converToDouble(numberTwo)) / 2;
    }

    public Double squareRoot(String number) throws Exception {
        if(!isNumeric(number)) throw
                new UnsupportedMathOperationException("Please set a numeric value!");
        return Math.sqrt(converToDouble(number));
    }

    Double converToDouble(String strNumber) throws IllegalArgumentException {
        if (strNumber==null || strNumber.isEmpty()) throw
                new UnsupportedMathOperationException("Please set a numeric value!");
        String number = strNumber.replace(",", ".");
        return Double.parseDouble(number);
    }

    boolean isNumeric(String strNumber) {
        if (strNumber==null || strNumber.isEmpty()) return false;
        String number = strNumber.replace(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
