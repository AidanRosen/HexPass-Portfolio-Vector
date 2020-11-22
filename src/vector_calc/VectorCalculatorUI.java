package vector_calc;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.*;
import javax.swing.border.MatteBorder;


public class VectorCalculatorUI extends JFrame { //From Andrew Hale
    private final JLabel calcArea = new JLabel("");
    private final JLabel direction = new JLabel("");
    private final JTextField textField_horiz = new JTextField("Type the magnitude of the Horizontal Component", 20);
    private final JTextField textField_vert = new JTextField("Type the magnitude of the Vertical Component", 20);

    //You MUST move these text fields to here so that they can be accessed throughout the whole file instead of getting an "unknown symbol" error



    // calculator values
    private double arg1;
    private double arg2;
    private double calcAnswer;

    /**
     * Launch the application.
     */



    public void calculateAnswer(double mag, double direc)  // method to perform calculation
    {
        String degrees = String.valueOf(direc);
        calcAnswer = mag;
        calcArea.setText(String.valueOf(calcAnswer));
        direction.setText(degrees + " \nDEGREES");

        //This section DRAWS the vector - Aidan

        //Note that calcAnswer is magnitude, and resultant.resultantDirec() is directionality

        System.out.println("\n\nEnd of vector painting");
        //End of vector drawing - Aidan

        //arg1 = Double.parseDouble(calcArea.getText());

    }


    /**
     * Save values for Calculator.
     */
    private void resetBoxText(JTextField textfield) { // method to store 1st value in calculation (arg1)
        textfield.setText("100.0");

    }



    public void clearCalculator() {  // helper method to clear and update calculator to default
        // calculator control
        String calcAreaDefault = "0.0";
        calcArea.setText(calcAreaDefault);
        resetBoxText(textField_horiz);
        resetBoxText(textField_vert);
        direction.setText("BLANK Radians");
        calcAnswer = 0.0;
    }

    public VectorCalculatorUI(VectorControl control) {
        System.out.println("Calculating answer...");
        getContentPane().setBackground(new Color(143, 0, 255));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 500, 500);
        getContentPane().setLayout(null);
        calcArea.setForeground(Color.WHITE);
        calcArea.setFont(new Font("Lucida Grande", Font.PLAIN, 45));
        calcArea.setHorizontalAlignment(SwingConstants.RIGHT);
        calcArea.setBounds(18, 36, 377, 67);
        getContentPane().add(calcArea);




        //Label to show where magnitude is presented
        JLabel magLabel = new JLabel("Magnitude:");
        magLabel.setOpaque(true);
        magLabel.setForeground(Color.WHITE);
        magLabel.setFont(new Font("Lucida Grande", Font.BOLD, 12));
        magLabel.setBackground(new Color(247, 220, 180));
        magLabel.setBounds(18, 26, 130, 15);
        getContentPane().add(magLabel);

        //label for organization
        JLabel label1 = new JLabel("Vertical Component");
        label1.setText("Vertical Component");
        label1.setOpaque(true);
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("Lucida Grande", Font.BOLD, 12));
        label1.setBackground(new Color(247, 220, 180));
        label1.setBounds(169, 105, 130, 15);
        getContentPane().add(label1);


        textField_horiz.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                textField_horiz.setBackground(Color.BLUE);
                System.out.println("After mouse press: this is the value of Arg1" + arg1);
            }


            @Override
            public void mouseReleased(MouseEvent e) {
                textField_horiz.setBackground(Color.BLUE);
            }

        });

        textField_horiz.setText("100.0");
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
        textField_horiz.setBounds(165, 126, 130, 100);
        //Error fixed: wrong x location
        getContentPane().add(textField_horiz);


        //label for organization
        JLabel label2 = new JLabel("Horizontal Component");
        label2.setText("Horizontal Component");
        label2.setOpaque(true);
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("Lucida Grande", Font.BOLD, 12));
        label2.setBackground(new Color(247, 220, 180));
        label2.setBounds(35, 105, 130, 15);
        getContentPane().add(label2);


        textField_vert.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                textField_vert.setBackground(Color.BLUE);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                 textField_vert.setBackground(Color.BLUE);
            }
        });

        textField_vert.setText("100.0");
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
        textField_vert.setBounds(35, 126, 130, 100);
        getContentPane().add(textField_vert);








        // Create Vector Button. Calculates magnitude and direction
        JButton button_create = new JButton("Click me to get \n the magnitude of \nthe vector");
        button_create.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                //This code is for making sure arguments are consistent with what is typed in the text box
                control.saveValueOfArg1(textField_vert);
                control.saveValueOfArg2(textField_horiz);
                button_create.setBackground(Color.WHITE);
            }

            public void mouseReleased(MouseEvent e) {
                //This code is for making sure the value updates after the key is pressed
                button_create.setBackground(Color.BLUE);
            }
        });
        button_create.addActionListener(e -> {
            System.out.println("Calculating answer...");
            control.calculateProperties();
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
        direction.setText("BLANK Degrees");
        direction.setBorder(new MatteBorder(4, 4, 4, 4,new Color(61, 237, 151)));
        direction.setBackground(new Color(61, 237, 151));
        direction.setBounds(35, 242, 260, 30);
        getContentPane().add(direction);

        //Label to show where directionality is presented
        JLabel dirLabel = new JLabel("Directionality ^^^^");
        dirLabel.setOpaque(true);
        dirLabel.setForeground(Color.WHITE);
        dirLabel.setFont(new Font("Lucida Grande", Font.BOLD, 12));
        dirLabel.setBackground(Color.GREEN);
        dirLabel.setBounds(35, 280, 130, 15);
        //Must place in y=350 because the button fpr direction is so large
        getContentPane().add(dirLabel);




        JButton button_clear = new JButton("AC");
        button_clear.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button_clear.setBackground(Color.BLUE);
            }

            public void mouseReleased(MouseEvent e) {
                button_clear.setBackground(new Color(221, 160, 221));
            }
        });
        button_clear.addActionListener(e -> control.clearMath());
        button_clear.setOpaque(true);
        button_clear.setForeground(Color.WHITE);
        button_clear.setBorder(new MatteBorder(4, 4, 4, 4, Color.WHITE));
        button_clear.setBackground(new Color(221, 160, 221));
        button_clear.setBounds(327, 126, 75, 40);
        getContentPane().add(button_clear);



    }


}
