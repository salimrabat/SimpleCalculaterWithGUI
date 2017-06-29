package calc;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by srabb on 2017-06-29.
 */

public class Calculator {

    public String calculate(String input) {
        String[] operandsArray = input.trim().split("[\\-+/*]");
        String[] operatorsArray = input.trim().split("(\\d+)");
        ArrayList<String> operands = new ArrayList<>(Arrays.asList(operandsArray));
        ArrayList<String> operators = new ArrayList<>(Arrays.asList(operatorsArray));
        if (operators.contains("")) {
            operators.remove("");
        }
        double result = 0;
        String value;
        while (!operators.isEmpty()) {
            if (operators.contains("*")) {
                int i = operators.indexOf("*");
                result = Double.parseDouble(operands.get(i)) * Double.parseDouble(operands.get(i+1));
                operands.remove(i+1);
                operands.remove(i);
                operators.remove(i);
                operands.add(i, Double.toString(result));
            }
            else if (operators.contains("/")) {
                int i = operators.indexOf("/");
                if (Double.parseDouble(operands.get(i+1)) == 0) {
                    operators.clear();
                    operands.clear();
                    return "ERROR!! DIVISION BY ZERO";
                }
                result = Double.parseDouble(operands.get(i)) / Double.parseDouble(operands.get(i+1));
                operands.remove(i+1);
                operands.remove(i);
                operators.remove(i);
                operands.add(i, Double.toString(result));
            }
            else if (operators.contains("-")) {
                int i = operators.indexOf("-");
                result = Double.parseDouble(operands.get(i)) - Double.parseDouble(operands.get(i+1));
                operands.remove(i+1);
                operands.remove(i);
                operators.remove(i);
                operands.add(i, Double.toString(result));
            }
            else if (operators.contains("+")) {
                int i = operators.indexOf("+");
                result = Double.parseDouble(operands.get(i)) + Double.parseDouble(operands.get(i+1));
                operands.remove(i+1);
                operands.remove(i);
                operators.remove(i);
                operands.add(i, Double.toString(result));
            }
        }

        value = Double.toString(result);
        operands.clear();
        operators.clear();
        return value;
    }
}
