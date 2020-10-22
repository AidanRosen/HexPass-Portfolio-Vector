package util;
import java.util.ArrayList;

import View_Control.GraphingCalculatorAJ;
import java.util.ArrayList;
public class Point {
    public static char[] Mfns = {'+', '-', '*', '/'};

    double number[];
    int totalNumbers = 0;

    ArrayList<Math.OPERATOR> holder;

    double x;
    double y;


    public Point(double x, double y) {
        number[totalNumbers] = 0;
        this.x = x;
        this.y = calculate(x);
        GraphingCalculatorAJ.JBar.setText(String.valueOf(this.y));
        //Convert(GraphingCalculatorUI.input);

    }
    public double calculate(double x) {
        int numbers = 0;

        seperator(x);
        while (numbers < totalNumbers) {
            number[numbers+1] = Math.calculateIt(number[numbers], holder.get(numbers), number[numbers+1]);
            numbers++;
        }
        return number[numbers];

    }

    public void seperator(double x) {

        for (int length = 0; length < GraphingCalculatorAJ.input.length(); length++) {
            char iterator = GraphingCalculatorAJ.input.charAt(length);

            String itS = String.valueOf(iterator);
            GraphingCalculatorAJ.JBar.setText(itS);
            do {
                if (itS.equals("x")) {
                    String xIn = String.valueOf(x);
                    itS = xIn;
                }
                setNumber(Double.valueOf(itS));
            } while (!itS.equals(Mfns));
            totalNumbers++;

/* if (GraphingCalculatorUI.input.contains("*")) {
        GraphingCalculatorUI.input.replaceFirst("*", "");
    }
    */
        }

    }

    public boolean operatorTest(String itS) {
        if (itS.equals(Mfns)) {
            switch (itS) {
                case "+":
                    holder.add(Math.OPERATOR.PLUS);
                    break;

                case "-":
                    holder.add(Math.OPERATOR.MINUS);
                    break;

                case "*":
                    holder.add(Math.OPERATOR.MULTIPLY);
                    break;

                case "/":
                    holder.add(Math.OPERATOR.DIVIDE);
                    break;
                default:
                    holder.add(Math.OPERATOR.NOOP);
                    break;
            }
            return true;

        }
        return false;
    }



    public void setNumber(double nextNumber) {
        if (number[totalNumbers] != 0) {
            number[totalNumbers] = number[totalNumbers]*10 + nextNumber;
        }
        else {
            number[totalNumbers] = nextNumber;
        }
    }

}

/*class Seperator() {
    public static char[] Mfns = {'+', '-', '*', '/'};
    double number[];
    int totalNumbers = -1;


    public Seperator(double x) {
        String xIn = String.valueOf(x);
        GraphingCalculatorUI.input.replace("x", xIn);
        for (int length = 0; length < GraphingCalculatorUI.input.length(); length++) {
            char iterator = GraphingCalculatorUI.input.charAt(length);

            String itS = String.valueOf(iterator);
        do {
            setNumber(Double.valueOf(itS));
        } while (!itS.equals(Mfns));
        totalNumbers++;

    }


}
*/
