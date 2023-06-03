import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener, KeyListener {
    JFrame frame;
    JTextField textfield;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[13];
    JButton addButton, subButton, mulButton, divButton, sqrtButton, powButton;
    JButton decButton, equButton, delButton, clrButton, negButton, prctButton, squareButton;
    JPanel panel;

    Font myFont = new Font("Times New Roman", Font.BOLD, 20);

    double num1 = 0, num2 = 0, result = 0;
    char operator;

    Calculator() {
        frame = new JFrame("Calcularor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(445, 600);
        frame.setLayout(null);
        textfield = new JTextField();
        textfield.setBounds(30, 25, 365, 100);
        textfield.setFont(myFont);
        textfield.setEditable(false);
        frame.setFocusable(true);
        frame.requestFocusInWindow();
        frame.addKeyListener(this);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("<-");
        clrButton = new JButton("Clr");
        negButton = new JButton("+/-");
        sqrtButton = new JButton("√");
        //changes
        prctButton = new JButton("%");
        squareButton = new JButton("x²");
        powButton = new JButton("pow");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;
        functionButtons[9] = sqrtButton;
        functionButtons[10] = prctButton;
        functionButtons[11] = squareButton;
        functionButtons[12] = powButton;

        for (int i = 0; i < 13; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
        }
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }
//        negButton.setBounds(50, 430, 70, 50);

        prctButton.setBounds(30, 150, 60, 67);
        delButton.setBounds(30, 460, 67, 67);
        clrButton.setBounds(100, 460, 67, 67);
        sqrtButton.setBounds(30, 381, 60, 67);
        squareButton.setBounds(30, 227, 60, 67);
        powButton.setBounds(30, 304, 60, 67);
        equButton.setBounds(177, 460, 220, 67);
        equButton.setFont(new Font("Ink Free", Font.BOLD, 30));

        panel = new JPanel();
        panel.setBounds(100, 150, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        //panel.setBackground(Color.PINK);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(addButton);

        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(mulButton);

        panel.add(negButton);
        panel.add(numberButtons[0]);
        panel.add(decButton);
        panel.add(divButton);

        frame.add(panel);

        frame.add(powButton);
        frame.add(squareButton);
        frame.add(prctButton);
        frame.add(sqrtButton);
        frame.add(equButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textfield);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            for (int i = 0; i < 10; i++) {
                if (e.getSource() == numberButtons[i]) {
                    textfield.setText(textfield.getText().concat(String.valueOf(i)));
                }
            }
            if (e.getSource() == decButton) {
                if (!textfield.getText().contains(".") && textfield.getText().length() != 0)
                    textfield.setText(textfield.getText().concat("."));
            }
            if (e.getSource() == addButton) {
                num1 = Double.parseDouble(textfield.getText());
                operator = '+';
                textfield.setText("");
            }
            if (e.getSource() == subButton) {
                num1 = Double.parseDouble(textfield.getText());
                operator = '-';
                textfield.setText("");
            }
            if (e.getSource() == sqrtButton) {
                num1 = Double.parseDouble(textfield.getText());
                num1 = Math.sqrt(num1);
                textfield.setText(String.valueOf(num1));
            }
            if (e.getSource() == mulButton) {
                num1 = Double.parseDouble(textfield.getText());
                operator = '*';
                textfield.setText("");
            }
            if (e.getSource() == divButton) {
                num1 = Double.parseDouble(textfield.getText());
                operator = '/';
                textfield.setText("");
            }
            if (e.getSource() == equButton) {
                num2 = Double.parseDouble(textfield.getText());
                switch (operator) {
                    case '+' -> result = num1 + num2;
                    case '-' -> result = num1 - num2;
                    case '*' -> result = num1 * num2;
                    case '/' -> result = num1 / num2;
                    case '^' -> result = Math.pow(num1, num2);
                }
                textfield.setText(String.valueOf(result));
                num1 = result;
            }
            if (e.getSource() == clrButton) {
                textfield.setText("");
            }
            if (e.getSource() == delButton) {
                String string = textfield.getText();
                textfield.setText("");
                for (int i = 0; i < string.length() - 1; i++) {
                    textfield.setText(textfield.getText() + string.charAt(i));
                }
            }
            if (e.getSource() == negButton) {
                double temp = Double.parseDouble(textfield.getText());
                temp *= -1;
                textfield.setText(String.valueOf(temp));
            }
            if (e.getSource() == prctButton) {
                num2 = Double.parseDouble(textfield.getText());
                if (e.getSource() == prctButton) {
                    switch (operator) {
                        case '+' -> result = num1 + num2 * num1 / 100;
                        case '-' -> result = num1 - num2 * num1 / 100;
                        case '*' -> result = num1 * num2 * num1 / 100;
                        case '/' -> result = num1 / num2 * num1 / 100;
                    }
                }
                textfield.setText(String.valueOf(result));
                num1 = result;
            }
            if (e.getSource() == powButton) {
                num1 = Double.parseDouble(textfield.getText());
                operator = '^';
                textfield.setText("");
            }
            if (e.getSource() == squareButton) {
                num1 = Double.parseDouble(textfield.getText());
                num1 *= num1;
                textfield.setText(String.valueOf(num1));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        char symbol = e.getKeyChar();
        if (!Character.isDigit(symbol)) {
            return;
        }
        textfield.setText(textfield.getText() + symbol);
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
