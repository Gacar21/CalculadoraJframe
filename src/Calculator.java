import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator {

    private double total = 0.0;
    private char math_operator;
    private boolean startNewNumber = true;
    private boolean StarNewResult = true;
    private boolean hasOperator = false;

    private JPanel Calculator;
    private JTextField Display;
    private JButton ButtonIGUAL;
    private JButton ButtonMULT;
    private JButton Button8;
    private JButton Button9;
    private JButton Button5;
    private JButton Button2;
    private JButton ButtonPUNTO;
    private JButton ButtonMAS;
    private JButton Button6;
    private JButton Button1;
    private JButton ButtonDEL;
    private JButton ButtonMenos;
    private JButton ButtonDIVI;
    private JButton Button7;
    private JButton Button4;
    private JButton Button3;
    private JButton Button0;

    private String formatNumber(double number) {
        if (number == (long) number) {
            return String.format("%d", (long) number);
        } else {
            return String.format("%s", number);
        }
    }

    private void getOperator(String Button) {
        if (hasOperator) {
            calculateResult();
        }
        math_operator = Button.charAt(0);
        hasOperator = true;
        startNewNumber = true;
        Display.setText(Display.getText() + " " + Button + " ");
    }

    private void calculateResult() {
        String[] parts = Display.getText().split(" ");
        if (parts.length >= 3) {
            double num1 = Double.parseDouble(parts[0]);
            double num2 = Double.parseDouble(parts[2]);
            switch (math_operator) {
                case '+':
                    total = num1 + num2;
                    break;
                case '-':
                    total = num1 - num2;
                    break;
                case '*':
                    total = num1 * num2;
                    break;
                case '/':
                    if (num2 != 0) {
                        total = num1 / num2;
                    } else {
                        Display.setText("Error: División por cero");
                        return;
                    }
                    break;
            }
            Display.setText(formatNumber(total));
            hasOperator = false;
        }
    }

    public Calculator() {
        ActionListener numberListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton source = (JButton) e.getSource();
                if (startNewNumber) {
                    if (hasOperator) {
                        Display.setText(Display.getText() + source.getText());
                    } else {
                        Display.setText(source.getText());
                    }
                    startNewNumber = false;
                } else {
                    Display.setText(Display.getText() + source.getText());
                }
            }
        };

        Button0.addActionListener(numberListener);
        Button1.addActionListener(numberListener);
        Button2.addActionListener(numberListener);
        Button3.addActionListener(numberListener);
        Button4.addActionListener(numberListener);
        Button5.addActionListener(numberListener);
        Button6.addActionListener(numberListener);
        Button7.addActionListener(numberListener);
        Button8.addActionListener(numberListener);
        Button9.addActionListener(numberListener);

        ButtonMAS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getOperator(ButtonMAS.getText());
            }
        });

        ButtonIGUAL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (hasOperator) {
                    calculateResult();
                    StarNewResult = true;
                }
            }
        });

        ButtonDEL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Display.setText("");
                total = 0;
                startNewNumber = true;
                hasOperator = false;
            }
        });

        ButtonPUNTO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (startNewNumber) {
                    Display.setText(Display.getText() + "0.");
                    startNewNumber = false;
                } else if (!Display.getText().contains(".")) {
                    Display.setText(Display.getText() + ".");
                }
            }
        });

        ButtonMenos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getOperator(ButtonMenos.getText());
            }
        });

        ButtonDIVI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getOperator(ButtonDIVI.getText());
            }
        });

        ButtonMULT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getOperator(ButtonMULT.getText());
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator");
        frame.setContentPane(new Calculator().Calculator);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}