package vector_calc;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import TrigVector.TRIG;

public class VectorCalculatorUI extends JFrame { //From Andrew Hale
    private final JLabel calcArea = new JLabel("");

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
        calcAnswer = TrigVector.calculateIt(arg1, mathOp, arg2);
        calcArea.setText(String.valueOf(calcAnswer));
        arg1 = Double.parseDouble(calcArea.getText());
        mathState = STATE.CALC;
        initialCalcAreaInputState = true;
    }

    private void updateCalcArea(String string) {
        if (initialCalcAreaInputState) {  // sets text to string on initial key typed
            calcArea.setText(string);
            initialCalcAreaInputState = false;
        } else  {                         // concatenates string to end of text subsequent keys typed
            calcArea.setText(calcArea.getText() + string);
        }
    }

    /**
     * Save values for Calculator.
     */
    private void saveValueOfArg1() { // method to store 1st value in calculation (arg1)
        arg1 = Double.parseDouble((calcArea.getText()));
        mathState = STATE.SAVE1;
        initialCalcAreaInputState = true;
    }

    private void saveValueOfArg2() { // method to store 2nd value in calculation (arg2)
        if (mathState != STATE.CALC) {
            arg2 = Double.parseDouble((calcArea.getText()));
            mathState = STATE.SAVE2;
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
        calcAnswer = 0.0;
    }

    public VectorCalculatorUI() {
        getContentPane().setBackground(new Color(247, 220, 180));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 418, 315);
        getContentPane().setLayout(null);
        calcArea.setForeground(Color.WHITE);
        calcArea.setFont(new Font("Lucida Grande", Font.PLAIN, 72));
        calcArea.setHorizontalAlignment(SwingConstants.RIGHT);
        calcArea.setBounds(18, 6, 377, 67);
        getContentPane().add(calcArea);

        JTextField textField_horiz = new JTextField("Horizontal Component", 20);
        textField_horiz.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                textField_horiz.setBackground(Color.BLUE);
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
        textField_horiz.addActionListener(e -> updateCalcArea(textField_horiz.getText()));
        textField_horiz.setBounds(35, 86, 75, 40);
        getContentPane().add(textField_horiz);

        JTextField textField_vert = new JTextField("Vertical Component", 20);
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
        textField_vert.setBorder(new MatteBorder(4, 4, 4, 4, Color.WHITE));
        textField_vert.setOpaque(true);
        textField_vert.setForeground(Color.WHITE);
        textField_vert.setBackground(Color.BLUE);
        textField_vert.addActionListener(e -> updateCalcArea(textField_vert.getText()));
        textField_vert.setBounds(35, 86, 75, 40);
        getContentPane().add(textField_vert);

        // Create Vector Button
        JButton button_create = new JButton("Create Vector");
        button_create.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button_create.setBackground(Color.WHITE);
            }

            public void mouseReleased(MouseEvent e) {
                button_create.setBackground(Color.BLUE);
            }
        });
        button_create.addActionListener(e -> {
            saveValueOfArg2();
            calculateAnswer();
        });
        button_create.setOpaque(true);
        button_create.setForeground(Color.WHITE);
        button_create.setBorder(new MatteBorder(4, 4, 4, 4, Color.WHITE));
        button_create.setBackground(Color.BLUE);
        button_create.setBounds(327, 242, 75, 40);
        getContentPane().add(button_create);

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
