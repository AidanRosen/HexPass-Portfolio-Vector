package vector_calc;
import java.util.Stack;

public class VectorData {
    private double arg1;
    private double arg2;

    private double magnitude;
    //Calculated to be placed in JLabel

    private double direction;
    //Calculated to be placed on the lower, green JLabel

    public void clear(){
        arg1 = 0.0;
        arg2 = 0.0;
        magnitude = 0.0;
        direction = 0.0;
    }

    public void setArg1 (double number){
        arg1 = number;
    }

    public void setArg2 (double number){
        arg2 = number;
    }

    public void calculations () {
        VectorCreate resultant = new VectorCreate(arg1, arg2);
        magnitude = resultant.resultantMag();
        direction = resultant.resultantDirec();
    }

    public double getMag(){
        return magnitude;
    }

    public double getDirection(){
        return direction;
    }



    public static void stackCreate(String[] args) {
            // Creating a Stack
        //Referred to this tutorial online: https://www.geeksforgeeks.org/stack-class-in-java/
            Stack<String> stackOfCards = new Stack<>();

        //Notice the "<>". This defines the object type to create a stack of. This is critical because
        //it means that Stacks are not objects, but like meta-objects that can stack objects on top of objects


        // Pushing new items to the Stack
            stackOfCards.push("Jack");
        //Stack is originally empty. The push method puts the string
            stackOfCards.push("Queen");
            stackOfCards.push("King");
            stackOfCards.push("Ace");

            System.out.println("Stack => " + stackOfCards);
            System.out.println();

            // Popping items from the Stack
        //Gets the top of the stack AND removes it from the top at the same time
            String cardAtTop = stackOfCards.pop();  // Throws EmptyStackException if the stack is empty
            System.out.println("Stack.pop() => " + cardAtTop);
            System.out.println("Current Stack => " + stackOfCards);
            System.out.println();

            // Get the item at the top of the stack without removing it
            cardAtTop = stackOfCards.peek();
            System.out.println("Stack.peek() => " + cardAtTop);
            System.out.println("Current Stack => " + stackOfCards);

        }



}
