package br.com.mazonhenrique.controllers;

import br.com.mazonhenrique.exception.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    //http://localhost:8080/math/sum/3/5
    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(@PathVariable("numberOne") String numberOne,
                      @PathVariable("numberTwo") String numberTwo) throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw
                new UnsupportedMathOperationException("Please set a numeric value!");
        return converToDouble(numberOne) + converToDouble(numberTwo);
    }

    //http://localhost:8080/math/subtraction/3/5
    @RequestMapping("/subtraction/{numberOne}/{numberTwo}")
    public Double subtraction(@PathVariable("numberOne") String numberOne,
                              @PathVariable("numberTwo") String numberTwo) throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw
                new UnsupportedMathOperationException("Please set a numeric value!");
        return converToDouble(numberOne) - converToDouble(numberTwo);
    }

    //http://localhost:8080/math/multiplication/3/5
    @RequestMapping("/multiplication/{numberOne}/{numberTwo}")
    public Double multiplication(@PathVariable("numberOne") String numberOne,
                              @PathVariable("numberTwo") String numberTwo) throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw
                new UnsupportedMathOperationException("Please set a numeric value!");
        return converToDouble(numberOne) * converToDouble(numberTwo);
    }

    //http://localhost:8080/math/division/3/5
    @RequestMapping("/division/{numberOne}/{numberTwo}")
    public Double division(@PathVariable("numberOne") String numberOne,
                              @PathVariable("numberTwo") String numberTwo) throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw
                new UnsupportedMathOperationException("Please set a numeric value!");
        if (Double.parseDouble(numberTwo) <= 0) throw
                new UnsupportedMathOperationException("Please enter a number greater than zero for division");
        return converToDouble(numberOne) / converToDouble(numberTwo);
    }

    //http://localhost:8080/math/mean/3/5
    @RequestMapping("/mean/{numberOne}/{numberTwo}")
    public Double mean(@PathVariable("numberOne") String numberOne,
                           @PathVariable("numberTwo") String numberTwo) throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw
                new UnsupportedMathOperationException("Please set a numeric value!");
        return (converToDouble(numberOne) + converToDouble(numberTwo)) / 2;
    }

    //http://localhost:8080/math/squareRoot/81
    @RequestMapping("/squareRoot/{number}")
    public Double squareRoot(@PathVariable("number") String number) throws Exception {
        if(!isNumeric(number)) throw
                new UnsupportedMathOperationException("Please set a numeric value!");
        return Math.sqrt(converToDouble(number));
    }

    private Double converToDouble(String strNumber) throws IllegalArgumentException {
        if (strNumber==null || strNumber.isEmpty()) throw
                new UnsupportedMathOperationException("Please set a numeric value!");
        String number = strNumber.replace(",", ".");
        return Double.parseDouble(number);
    }

    private boolean isNumeric(String strNumber) {
        if (strNumber==null || strNumber.isEmpty()) return false;
        String number = strNumber.replace(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

}
