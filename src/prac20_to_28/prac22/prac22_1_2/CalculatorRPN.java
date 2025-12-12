package prac20_to_28.prac22.prac22_1_2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Stack;

public class CalculatorRPN extends JFrame {

    private JTextField displayField;
    private JTextArea stackArea;
    private JButton[] numberButtons;
    private JButton[] operationButtons;

    private Stack<Double> stack;
    private StringBuilder currentInput;

    private final String[] BUTTON_LABELS = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "+", "=",
             "Clear", "Swap","Sqrt", "^",
            "Dup", "Drop", "Back", "Enter"
    };

    public CalculatorRPN() {
        stack = new Stack<>();
        currentInput = new StringBuilder();

        setupUI();
        setupListeners();

        setTitle("RPN Calculator");
        setSize(400, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void setupUI() {
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel displayPanel = new JPanel(new BorderLayout(5, 5));

        displayField = new JTextField("0");
        displayField.setFont(new Font("Arial", Font.BOLD, 24));
        displayField.setHorizontalAlignment(JTextField.RIGHT);
        displayField.setEditable(false);
        displayField.setBackground(new Color(240, 240, 240));
        displayField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));

        displayPanel.add(displayField, BorderLayout.CENTER);

        JPanel stackPanel = new JPanel(new BorderLayout(5, 5));

        stackArea = new JTextArea(6, 20);
        stackArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        stackArea.setEditable(false);
        stackArea.setBackground(new Color(245, 245, 245));
        stackArea.setBorder(BorderFactory.createTitledBorder("Стек (снизу вверх):"));

        JScrollPane scrollPane = new JScrollPane(stackArea);

        stackPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new GridLayout(6, 4, 5, 5));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

        for (int i = 0; i < BUTTON_LABELS.length; i++) {
            JButton button = new JButton(BUTTON_LABELS[i]);
            button.setFont(new Font("Arial", Font.BOLD, 16));
            button.setFocusPainted(false);

            if (BUTTON_LABELS[i].matches("[0-9.]")) {
                button.setBackground(new Color(240, 240, 255));
            } else if (BUTTON_LABELS[i].matches("[+\\-*/^=]")) {
                button.setBackground(new Color(255, 240, 240));
            } else if (BUTTON_LABELS[i].equals("Sqrt")) {
                button.setBackground(new Color(255, 240, 240));
            } else {
                button.setBackground(new Color(240, 255, 240));
            }

            button.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createRaisedBevelBorder(),
                    BorderFactory.createEmptyBorder(5, 5, 5, 5)
            ));

            final String buttonText = BUTTON_LABELS[i];
            button.addActionListener(e -> handleButtonClick(buttonText));

            buttonPanel.add(button);
        }

        mainPanel.add(displayPanel, BorderLayout.NORTH);
        mainPanel.add(stackPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        updateStackDisplay();

        add(mainPanel);
    }

    private void setupListeners() {
        displayField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                char keyChar = e.getKeyChar();
                int keyCode = e.getKeyCode();

                if (keyChar >= '0' && keyChar <= '9') {
                    currentInput.append(keyChar);
                    updateDisplay();
                } else if (keyChar == '.') {
                    if (!currentInput.toString().contains(".")) {
                        if (currentInput.length() == 0) {
                            currentInput.append("0");
                        }
                        currentInput.append(".");
                        updateDisplay();
                    }
                } else if (keyCode == KeyEvent.VK_ENTER) {
                    pushToStack();
                } else if (keyCode == KeyEvent.VK_BACK_SPACE) {
                    handleBackspace();
                } else if (keyCode == KeyEvent.VK_ESCAPE) {
                    clearAll();
                }
            }
        });
    }

    private void handleButtonClick(String buttonText) {
        switch (buttonText) {
            case "0": case "1": case "2": case "3": case "4":
            case "5": case "6": case "7": case "8": case "9":
                currentInput.append(buttonText);
                updateDisplay();
                break;

            case ".":
                if (!currentInput.toString().contains(".")) {
                    if (currentInput.length() == 0) {
                        currentInput.append("0");
                    }
                    currentInput.append(".");
                    updateDisplay();
                }
                break;

            case "+": case "-": case "*": case "/": case "^":
                if (currentInput.length() > 0) {
                    pushToStack();
                }
                performBinaryOperation(buttonText);
                break;

            case "Sqrt":
                handleSqrt();
                break;

            case "=":
                if (currentInput.length() > 0) {
                    pushToStack();
                }
                showResult();
                break;

            case "Enter":
                pushToStack();
                break;

            case "Clear":
                clearAll();
                break;

            case "Swap":
                swapStack();
                break;

            case "Drop":
                dropFromStack();
                break;

            case "Dup":
                duplicateStack();
                break;

            case "Back":
                handleBackspace();
                break;
        }
    }

    private void handleSqrt() {
        if (currentInput.length() > 0) {
            pushToStack();
        }

        if (stack.isEmpty()) {
            showError("Стек пуст для операции sqrt");
            return;
        }

        double number = stack.pop();

        if (number < 0) {
            stack.push(number);
            showError("Квадратный корень из отрицательного числа: " + number);
            return;
        }

        double result = Math.sqrt(number);

        stack.push(result);

        updateStackDisplay();

        displayField.setText(String.format("√%.2f = %.6f", number, result));
    }

    private void performBinaryOperation(String op) {
        if (stack.size() < 2) {
            showError("Недостаточно операндов для операции " + op);
            return;
        }

        try {
            double b = stack.pop();
            double a = stack.pop();
            double result = 0;

            switch (op) {
                case "+": result = a + b; break;
                case "-": result = a - b; break;
                case "*": result = a * b; break;
                case "/":
                    if (b == 0) {
                        stack.push(a);
                        stack.push(b);
                        showError("Деление на ноль");
                        return;
                    }
                    result = a / b;
                    break;
                case "^": result = Math.pow(a, b); break;
            }

            stack.push(result);
            updateStackDisplay();

            displayField.setText(String.format("%.2f %s %.2f = %.6f", a, op, b, result));

        } catch (Exception e) {
            showError("Ошибка: " + e.getMessage());
        }
    }

    private void pushToStack() {
        try {
            if (currentInput.length() == 0) {
                return;
            }

            double value = Double.parseDouble(currentInput.toString());
            stack.push(value);
            currentInput.setLength(0);
            updateDisplay();
            updateStackDisplay();

            displayField.setText("0");

        } catch (NumberFormatException e) {
            showError("Некорректное число: " + currentInput.toString());
            currentInput.setLength(0);
            updateDisplay();
        }
    }

    private void showResult() {
        if (stack.isEmpty()) {
            showError("Стек пуст");
        } else if (stack.size() == 1) {
            double result = stack.peek();
            displayField.setText("Результат: " + result);
        } else {
            showError("В стеке " + stack.size() + " значений. Используйте операции.");
        }
    }

    private void swapStack() {
        if (stack.size() < 2) {
            showError("Для обмена нужно минимум 2 значения в стеке");
            return;
        }

        double a = stack.pop();
        double b = stack.pop();
        stack.push(a);
        stack.push(b);
        updateStackDisplay();

        displayField.setText("Обмен: " + a + " ↔ " + b);
    }

    private void dropFromStack() {
        if (stack.isEmpty()) {
            showError("Стек пуст");
            return;
        }

        double dropped = stack.pop();
        updateStackDisplay();

        displayField.setText("Удалено: " + dropped);
    }

    private void duplicateStack() {
        if (stack.isEmpty()) {
            showError("Стек пуст");
            return;
        }

        double value = stack.peek();
        stack.push(value);
        updateStackDisplay();

        displayField.setText("Дублировано: " + value);
    }

    private void handleBackspace() {
        if (currentInput.length() > 0) {
            currentInput.deleteCharAt(currentInput.length() - 1);
            updateDisplay();
        } else {
            displayField.setText("Нет ввода для удаления");
        }
    }

    private void clearAll() {
        stack.clear();
        currentInput.setLength(0);
        displayField.setText("0");
        updateStackDisplay();
    }

    private void updateDisplay() {
        if (currentInput.length() == 0) {
            displayField.setText("0");
        } else {
            displayField.setText(currentInput.toString());
        }
    }

    private void updateStackDisplay() {
        StringBuilder sb = new StringBuilder();

        if (stack.isEmpty()) {
            sb.append("Стек пуст\n");
        } else {
            Object[] stackArray = stack.toArray();
            for (int i = 0; i < stackArray.length; i++) {
                double value = (Double) stackArray[i];
                sb.append(String.format("[%d] %12.6f\n", i, value));
            }
        }

        sb.append("\nВсего элементов: ").append(stack.size());
        stackArea.setText(sb.toString());
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Ошибка калькулятора",
                JOptionPane.ERROR_MESSAGE);
        displayField.setText("Ошибка: " + message);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CalculatorRPN calculator = new CalculatorRPN();
            calculator.setVisible(true);

            JOptionPane.showMessageDialog(calculator,
                    "RPN Калькулятор - Инструкция:\n\n" +
                            "1. Введите число\n" +
                            "2. Нажмите Enter (или введите следующее число)\n" +
                            "3. Выберите операцию (+, -, *, /, ^, Sqrt)\n" +
                            "4. Для sqrt: введите число → Enter → Sqrt\n\n" +
                            "Пример: √25 = 5\n" +
                            "   Введите: 25 → Enter → Sqrt",
                    "Инструкция", JOptionPane.INFORMATION_MESSAGE);
        });
    }
}