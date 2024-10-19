import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator {

    private double total = 0.0;
    private double total2 = 0.0;
    private char math_operator;

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

    public Calculator() {
        Button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Button1Text = Display.getText() + Button1.getText();
                Display.setText(Button1Text);

            }
        });
        Button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Button2Text = Display.getText() + Button2.getText();
                Display.setText(Button2Text);

            }
        });
        Button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Button3Text = Display.getText() + Button3.getText();
                Display.setText(Button3Text);

            }
        });
        Button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Button4Text = Display.getText() + Button4.getText();
                Display.setText(Button4Text);

            }
        });
        Button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Button5Text = Display.getText() + Button5.getText();
                Display.setText(Button5Text);

            }
        });
        Button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Button6Text = Display.getText() + Button6.getText();
                Display.setText(Button6Text);

            }
        });
        Button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Button7Text = Display.getText() + Button7.getText();
                Display.setText(Button7Text);

            }
        });
        Button8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Button8Text = Display.getText() + Button8.getText();
                Display.setText(Button8Text);

            }
        });
        Button9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Button9Text = Display.getText() + Button9.getText();
                Display.setText(Button9Text);

            }
        });
        ButtonMAS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               total = total + Double.parseDouble(Display.getText());
                Display.setText("");
            }
        });
        ButtonIGUAL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                total2 = total + Double.parseDouble(Display.getText());
                Display.setText(Double.toString(total2));
                total = 0;
            }
        });
        ButtonDEL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                total2 = 0;
                Display.setText("");
            }
        });
        ButtonPUNTO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Display.getText().equals("")){
                    Display.setText("0.");
                }else if (Display.getText().contains(".")){
                    ButtonPUNTO.setEnabled(false);
                }else {
                    String ButtonPtext = Display.getText() + ButtonPUNTO.getText();
                    Display.setText(ButtonPtext);
                }
                ButtonPUNTO.setEnabled(true);

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
