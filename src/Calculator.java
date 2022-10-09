// IMPORTING REQUIRED PACKAGES

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Calculator implements ActionListener {


    // PRE-DECLARATION OF NEEDED VARIABLES
    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[8];
    JButton addButton , subButton , mulButton , divButton;
    JButton decButton , equButton , delButton , clrButton;
    JPanel panel;

    Font myFont = new Font("Monospaced",Font.BOLD,20);
    double num1=0, num2=0, result=0;
    char operator;


    //BUILDING CONSTRUCTOR
    Calculator(){


        //SETTING UP FRAME
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,600);
        frame.setLayout(null);


        //MAKING TEXTAREA
        textField = new JTextField();
        textField.setBounds(50,50,300,50);
        textField.setFont(myFont);
        textField.setEditable(false);


        //ADDING-UP BUTTONS AND BUILDING OBJECTS
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Delete");
        clrButton = new JButton("Clear");


        //ASSEMBLE BUTTONS SEQUENTIALLY
        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;


        //USING FOR LOOP TO SAVE UP SOME TIME
        for (int i=0;i<8;i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
        }

        for (int i=0;i<10;i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }


        //DEFINE BUTTON SIZE AND ITS AREA
        delButton.setBounds(50, 510 ,145, 50);
        clrButton.setBounds(210, 510 ,145, 50);


        // BUILDING PANEL AND IT'S OBJECT
        panel = new JPanel();
        panel.setBounds(50,120,300,350);
        panel.setLayout(new GridLayout(4,4,10,10));
        //panel.setBackground(Color.DARK_GRAY);


        // ADDING NUMBER'S AND FUNCTIONAL CHARACTERS TO PANEL
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(functionButtons[0]);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(functionButtons[1]);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(functionButtons[2]);
        panel.add(functionButtons[4]);
        panel.add(numberButtons[0]);
        panel.add(functionButtons[5]);
        panel.add(functionButtons[3]);




        frame.add(panel);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textField);
        frame.setVisible(true);


    }


    //MAIN METHOD FOR CALLING INSTRUCTION
    public static void main(String[] args) {

        Calculator calc = new Calculator();

    }


    //IMPLEMENTED METHOD ACTION-HANDLER
    @Override
    public void actionPerformed(ActionEvent e) {

        //MAKING NUMBERS FULLY FUNCTIONAL
        for(int i=0;i<10;i++) {
            if(e.getSource() == numberButtons[i]) {

            textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }


        //MAKING BUTTONS FUNCTIONAL
        if (e.getSource() == decButton) {
            textField.setText(textField.getText().concat("."));
        }
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }


        // USING LOOP TO PERFORM OUR EQUATION:
        if (e.getSource()== equButton) {
            num2 = Double.parseDouble(textField.getText());

            switch (operator) {
                case'+' :
                    result = num1 + num2;
                    break;
                case'-' :
                    result = num1 - num2;
                    break;
                case'*' :
                    result = num1 * num2;
                    break;
                case'/' :
                    result = num1 / num2;
                    break;
            }
            textField.setText(String.valueOf(result));
            num1 = result;
        }

        if (e.getSource() == clrButton) {
            textField.setText("");
        }

        if (e.getSource() == delButton) {
            String string = textField.getText();
            textField.setText("");
            for (int i=0;i<string.length()-1;i++) {
                textField.setText(textField.getText()+string.charAt(i));
            }
        }



    }
}
