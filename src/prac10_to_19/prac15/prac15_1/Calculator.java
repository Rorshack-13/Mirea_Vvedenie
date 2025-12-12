package prac10_to_19.prac15.prac15_1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Calculator extends JFrame {
    JTextField num1 = new JTextField(10);
    JTextField num2 = new JTextField(10);
    JButton plus = new JButton("+");
    JButton minus = new JButton("-");
    JButton division = new JButton("/");
    JButton multiply = new JButton("*");
    Calculator() {
        super("Калькулятор");
        setLayout(new FlowLayout());
        setSize(350, 200);
        add(new JLabel("1 число"));
        add(num1);
        add(new JLabel("2 число"));
        add(num2);
        add(plus);
        plus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double x1 = Double.parseDouble(num1.getText().trim());
                    double x2 = Double.parseDouble(num2.getText().trim());
                    JOptionPane.showMessageDialog(null, "Сумма = " + (x1+x2), "Alert", JOptionPane.INFORMATION_MESSAGE);
                }catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "Ошибка в числах", "Alert", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        add(minus);
        minus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double x1 = Double.parseDouble(num1.getText().trim());
                    double x2 = Double.parseDouble(num2.getText().trim());
                    JOptionPane.showMessageDialog(null, "Разность = " + (x1-x2), "Alert", JOptionPane.INFORMATION_MESSAGE);
                }catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "Ошибка в числах", "Alert", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        add(division);
        division.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double x1 = Double.parseDouble(num1.getText().trim());
                    double x2 = Double.parseDouble(num2.getText().trim());
                    JOptionPane.showMessageDialog(null, "Частное = " + (x1/x2), "Alert", JOptionPane.INFORMATION_MESSAGE);
                }catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "Ошибка в числах", "Alert", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        add(multiply);
        multiply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double x1 = Double.parseDouble(num1.getText().trim());
                    double x2 = Double.parseDouble(num2.getText().trim());
                    JOptionPane.showMessageDialog(null, "Произведение = " + (x1*x2), "Alert", JOptionPane.INFORMATION_MESSAGE);
                }catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "Ошибка в числах", "Alert", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        setVisible(true);
    }
    public static void main(String[] args) {
        new Calculator();
    }
}
