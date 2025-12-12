package prac10_to_19.prac16.prac16_3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Password extends JFrame {
    private JTextField serviceField, usernameField;
    private JPasswordField passwordField;
    private JButton checkButton;
    private JTextArea resultArea;
    private JCheckBox showPasswordCheckbox;

    public Password() {
        setTitle("Приложение Проверка пароля");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 400); // Увеличим ширину для чекбокса
        setLocationRelativeTo(null);

        createComponents();
        layoutComponentsSimple();
        setupEventHandlers();
    }

    private void createComponents() {
        serviceField = new JTextField(15);
        usernameField = new JTextField(15);
        passwordField = new JPasswordField(15);
        checkButton = new JButton("Проверить пароль");
        resultArea = new JTextArea(6, 25);
        resultArea.setEditable(false);
        resultArea.setLineWrap(true);

        showPasswordCheckbox = new JCheckBox("Показать пароль");
    }

    private void layoutComponentsSimple() {
        setLayout(new BorderLayout(10, 10));

        JPanel inputPanel = new JPanel(new GridLayout(5, 2, 5, 5));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Введите данные"));

        inputPanel.add(new JLabel("Сервис:"));
        inputPanel.add(serviceField);
        inputPanel.add(new JLabel("Имя пользователя:"));
        inputPanel.add(usernameField);
        inputPanel.add(new JLabel("Пароль:"));
        inputPanel.add(passwordField);
        inputPanel.add(new JLabel(""));
        inputPanel.add(showPasswordCheckbox);
        inputPanel.add(new JLabel(""));
        inputPanel.add(checkButton);

        JScrollPane resultScrollPane = new JScrollPane(resultArea);
        resultScrollPane.setBorder(BorderFactory.createTitledBorder("Результат проверки"));

        add(inputPanel, BorderLayout.NORTH);
        add(resultScrollPane, BorderLayout.CENTER);

        ((JPanel)getContentPane()).setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }

    private void setupEventHandlers() {
        checkButton.addActionListener(e -> checkPassword());
        passwordField.addActionListener(e -> checkPassword());

        showPasswordCheckbox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (showPasswordCheckbox.isSelected()) {
                    passwordField.setEchoChar((char)0);
                } else {
                    passwordField.setEchoChar('•');
                }
            }
        });
    }

    private void checkPassword() {
        String service = serviceField.getText().trim();
        String username = usernameField.getText().trim();
        char[] passwordChars = passwordField.getPassword();
        String password = new String(passwordChars);

        java.util.Arrays.fill(passwordChars, ' ');

        if (service.isEmpty() || username.isEmpty() || password.isEmpty()) {
            resultArea.setText("Ошибка: Все поля должны быть заполнены!");
            return;
        }

        StringBuilder result = new StringBuilder();
        result.append("Проверка для пользователя: ").append(username).append("\n");
        result.append("Сервис: ").append(service).append("\n\n");

        if (password.length() < 6) {
            result.append("Слишком короткий пароль!");
        } else if (password.equals("123456") || password.equals("password") || password.equals("пароль")) {
            result.append("Очень слабый пароль!");
        } else if (password.length() < 8) {
            result.append("Пароль приемлемый, но рекомендуется использовать не менее 8 символов");
        } else {
            result.append("Пароль соответствует базовым требованиям безопасности");
        }

        resultArea.setText(result.toString());
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> new Password().setVisible(true));
    }
}