package AJGraphingCalculator.Model;

import java.util.ArrayList;

import AJGraphingCalculator.View.GraphingCalculatorUI;
import java.util.ArrayList;


public class Point
{

    public double x;
    public double y;

    private ArrayList<AJGraphingCalculator.Model.FnStorer> listOfFns;
    private int totalNumbers;



    public Point() {
        this.x = 0;
        this.y = 0;
        //   this.listOfFns.clear();
        //  this.totalNumbers = 0;
    }

    public Point(double x, Seperator mathData) {


        //number[totalNumbers] = 0;
        setX(x);
        this.y = calculate(mathData);

        //Convert(GraphingCalculatorUI.input);

    }

    public double calculate(Seperator mathData) {


        ArrayList<AJGraphingCalculator.Model.FnStorer> listOfFns = mathData.functions;

        AJGraphingCalculator.Model.FnStorer currentFunction = new AJGraphingCalculator.Model.FnStorer(0, AJGraphingCalculator.Model.Math.OPERATOR.NOOP, 0);

        // number = mathData.numbersList;



        totalNumbers = mathData.totalAmountNumbers;

        // number = mathData.numbersList;

        //  GraphingCalculatorUI.JBar.setText(String.valueOf(number.get(totalNumbers)));

        // ArrayList<Math.OPERATOR> operator = mathData.holder;
        //   GraphingCalculatorUI.JBar.setText(String.valueOf(totalNumbers));

        for (int orderer = 0; orderer < 4; orderer++) {
            for (int numbers = 0; numbers < totalNumbers; numbers++) {


                currentFunction = listOfFns.get(numbers);


                if (currentFunction.order == orderer) {

                    //want loop that moves through number boxes, tests orders, if finds no match moves to next order and restarts number loop.
                    currentFunction.setcalculatedAnswer(AJGraphingCalculator.Model.Math.calculateIt(currentFunction.getNumber1(), currentFunction.getOperator(), currentFunction.getNumber2()));


                    listOfFns = remakeFn(numbers, listOfFns, currentFunction.getAnswer());


                    totalNumbers--;



                    listOfFns.remove(numbers);


                    numbers = -1;


                }

            }


        }


        GraphingCalculatorUI.JBar.setText(String.valueOf(currentFunction.getAnswer()));
        return currentFunction.getAnswer();

    }


    void setX(double x) {
        this.x = x;
    }


    public ArrayList<AJGraphingCalculator.Model.FnStorer> remakeFn(int index, ArrayList<AJGraphingCalculator.Model.FnStorer> functions, double replacer) {

        AJGraphingCalculator.Model.FnStorer firstTerm;
        AJGraphingCalculator.Model.FnStorer thirdTerm;

        if (index > 0) {
            firstTerm = functions.get(index - 1);
            firstTerm.setNumber2(replacer);
            functions.set(index-1, firstTerm);
        }

        try {

            thirdTerm = functions.get(index+1);
            thirdTerm.setNumber1(replacer);

            functions.set(index + 1, thirdTerm);

        } catch(IndexOutOfBoundsException indexOutOfBoundsException) {}

        return functions;




    }
}



