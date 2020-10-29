package vector_calc;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.*;
import javax.swing.border.MatteBorder;

import vector_calc.VectorCreate.TRIG;

public class VectorCalculatorUI extends JFrame { //From Andrew Hale
    private final JLabel calcArea = new JLabel("");
    private final JLabel direction = new JLabel("");
    private JTextField textField_horiz = new JTextField("Type the magnitude of the Horizontal Component", 20);
    private JTextField textField_vert = new JTextField("Type the magnitude of the Vertical Component", 20);
//You MUST move these text fields to here so that they can be accessed throughout the whole file instead of getting an "unknown symbol" error

    private boolean initialCalcAreaInputState;
    private enum STATE { INITIAL, SAVE1, SAVE2, CALC }

    private STATE mathState;

    // calculator values
    private TRIG mathOp;
    private double arg1;
    private double arg2;
    private double verticalComponent;
    private double horinzComponet;
    private double calcAnswer;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                VectorCalculatorUI frame = new VectorCalculatorUI();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private void calculateAnswer()  // method to perform calculation
    {
        System.out.println("This is the value of arg1:" + String.valueOf(arg1));
        System.out.println("\nThis is the value of arg1:" + String.valueOf(arg1));
        VectorCreate resultant = new VectorCreate(arg1, arg2);
        calcAnswer = resultant.resultantMag("magnitude");
        String degrees = String.valueOf(resultant.resultantDirec());
        System.out.println("\n\nThis is the value of resultant.resultant " + String.valueOf(resultant.resultantMag("magnitude")));
        System.out.println("\n\n CalcAnswer value: " + String.valueOf(calcAnswer));
        calcArea.setText(String.valueOf(calcAnswer));
        direction.setText(degrees + " \ndegrees out of 360");
        arg1 = Double.parseDouble(calcArea.getText());
        mathState = STATE.CALC;
        initialCalcAreaInputState = true;
    }

    /*
    private void updateCalcArea(String string) {
        if (initialCalcAreaInputState) {  // sets text to string on initial key typed
            calcArea.setText(string);
            initialCalcAreaInputState = false;
        } else  {                         // concatenates string to end of text subsequent keys typed
            calcArea.setText(calcArea.getText() + string);
        }
    }
*/ //Commenting out because this vector calculator works too differently from the previous one to be involved in updating
    //the calc area
    /**
     * Save values for Calculator.
     */
    private void saveValueOfArg1(JTextField textfield) { // method to store 1st value in calculation (arg1)
        arg1 = Double.parseDouble((textfield.getText()));
        mathState = STATE.SAVE1;
        initialCalcAreaInputState = true;
    }

    private void saveValueOfArg2(JTextField textfield) { // method to store 2nd value in calculation (arg2)
        if (mathState != STATE.CALC) {
            arg2 = Double.parseDouble((textfield.getText()));
            mathState = STATE.SAVE2;
            initialCalcAreaInputState = true;
        }
    }



    private void saveValueOfMathOp(TRIG op) { // method to store operator
        mathOp = op;
    }

    private void clearCalculator() {  // helper method to clear and update calculator to default
        // calculator control
        String calcAreaDefault = "0.0";
        calcArea.setText(calcAreaDefault);
        mathState = STATE.INITIAL;
        initialCalcAreaInputState = true;
        arg1 = 0.0;
        arg2 = 0.0;
        saveValueOfArg1(textField_horiz);
        saveValueOfArg2(textField_horiz);
        direction.setText("BLANK degrees out of 360");
        calcAnswer = 0.0;
    }

    public VectorCalculatorUI() {
        System.out.println("Calculating answer...");
        getContentPane().setBackground(new Color(247, 220, 180));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 500, 500);
        getContentPane().setLayout(null);
        calcArea.setForeground(Color.WHITE);
        calcArea.setFont(new Font("Lucida Grande", Font.PLAIN, 72));
        calcArea.setHorizontalAlignment(SwingConstants.RIGHT);
        calcArea.setBounds(18, 6, 377, 67);
        getContentPane().add(calcArea);





        textField_horiz.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                textField_horiz.setText("0.0"); textField_horiz.setBackground(Color.BLUE);
                System.out.println("After mouse press: this is the value of Arg1" + String.valueOf(arg1));
            }


            @Override
            public void mouseReleased(MouseEvent e) {
                textField_horiz.setBackground(Color.BLUE);
            }

        });


        textField_horiz.setBorder(new MatteBorder(4, 4, 4, 4, Color.WHITE));
        textField_horiz.setOpaque(true);
        textField_horiz.setForeground(Color.WHITE);
        textField_horiz.setBackground(Color.BLUE);
        //textField_horiz.addActionListener(e -> updateCalcArea(textField_horiz.getText()));
        /*
        * This line is being commented out so that the calculator can rely on typed in values instead of pressed buttons
        * - Aidan
        *
        * */
        textField_horiz.setBounds(165, 86, 130, 100);
        //Error fixed: wrong x location
        getContentPane().add(textField_horiz);





        textField_vert.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                textField_vert.setText("0.0");textField_vert.setBackground(Color.BLUE);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                 textField_vert.setBackground(Color.BLUE);
            }
        });

        textField_vert.setBorder(new MatteBorder(4, 4, 4, 4, Color.WHITE));
        textField_vert.setOpaque(true);
        textField_vert.setForeground(Color.WHITE);
        textField_vert.setBackground(Color.BLUE);
        //textField_vert.addActionListener(e -> updateCalcArea(textField_vert.getText()));
        /*
        * This line is being commented out so that the calculator can rely on typed in values instead of pressed buttons
         * - Aidan
        *
        *
        * */
        textField_vert.setBounds(35, 86, 115, 100);
        getContentPane().add(textField_vert);








        // Create Vector Button. Calculates magnitude and direction
        JButton button_create = new JButton("Click me to get \n the magnitude of \nthe vector");
        button_create.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                //This code is for making sure arguments are consistent with what is typed in the text box
                saveValueOfArg1(textField_vert);
                saveValueOfArg2(textField_horiz);
                button_create.setBackground(Color.WHITE);
            }

            public void mouseReleased(MouseEvent e) {
                //This code is for making sure the value updates after the key is pressed
                button_create.setBackground(Color.BLUE);
            }
        });
        button_create.addActionListener(e -> {
            System.out.println("Calculating answer...");
            calculateAnswer();
            //The above action saves the value AND then calculates the answer
        });
        button_create.setOpaque(true);
        button_create.setForeground(Color.WHITE);
        button_create.setBorder(new MatteBorder(4, 4, 4, 4, Color.WHITE));
        button_create.setBackground(Color.BLUE);
        button_create.setBounds(327, 242, 115, 100);
        getContentPane().add(button_create);


        direction.setOpaque(true);
        direction.setForeground(Color.WHITE);
        direction.setBorder(new MatteBorder(4, 4, 4, 4,new Color(61, 237, 151)));
        direction.setBackground(new Color(61, 237, 151));
        direction.setBounds(60, 242, 250, 100);
        getContentPane().add(direction);






        JButton button_clear = new JButton("AC");
        button_clear.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button_clear.setBackground(Color.BLUE);
            }

            public void mouseReleased(MouseEvent e) {
                button_clear.setBackground(Color.BLUE);
            }
        });
        button_clear.addActionListener(e -> clearCalculator());
        button_clear.setOpaque(true);
        button_clear.setForeground(Color.BLACK);
        button_clear.setBorder(new MatteBorder(4, 4, 4, 4, Color.WHITE));
        button_clear.setBackground(new Color(221, 160, 221));
        button_clear.setBounds(327, 85, 75, 40);
        getContentPane().add(button_clear);



        JLabel lblElliesCalculator = new JLabel("Sample Calculator -- design by Ellie");
        lblElliesCalculator.setBounds(6, 6, 134, 16);
        getContentPane().add(lblElliesCalculator);

    }


}
