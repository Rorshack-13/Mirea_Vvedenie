package prac10_to_19.prac16.prac16_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Ugadaika extends JFrame {
    private JTextField guessField;
    private JButton guessButton;
    private JLabel infoLabel;
    private int secretNumber;
    private int attemptsLeft;
    private Random random;

    public Ugadaika() {
        setTitle("Игра-угадайка");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);

        random = new Random();
        secretNumber = random.nextInt(21); // Число от 0 до 20
        attemptsLeft = 3;

        createComponents();
        layoutComponents();
        setupEventHandlers();

        updateInfo();
    }

    private void createComponents() {
        guessField = new JTextField(10);
        guessButton = new JButton("Угадать");
        infoLabel = new JLabel("", SwingConstants.CENTER);

        Font bigFont = new Font("Arial", Font.PLAIN, 14);
        infoLabel.setFont(bigFont);
        guessField.setFont(bigFont);
        guessButton.setFont(bigFont);
    }

    private void layoutComponents() {
        setLayout(new BorderLayout(10, 10));

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JPanel infoPanel = new JPanel(new FlowLayout());
        infoPanel.add(infoLabel);

        JPanel inputPanel = new JPanel(new FlowLayout());
        inputPanel.add(new JLabel("Ваш ответ:"));
        inputPanel.add(guessField);
        inputPanel.add(guessButton);

        mainPanel.add(infoPanel);
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(inputPanel);

        add(mainPanel, BorderLayout.CENTER);
    }

    private void setupEventHandlers() {
        guessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processGuess();
            }
        });

        guessField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processGuess();
            }
        });
    }

    private void processGuess() {
        try {
            int guess = Integer.parseInt(guessField.getText().trim());

            if (guess < 0 || guess > 20) {
                JOptionPane.showMessageDialog(this, "Введите число от 0 до 20!", "Ошибка", JOptionPane.ERROR_MESSAGE);
                guessField.setText("");
                guessField.requestFocus();
                return;
            }

            attemptsLeft--;

            if (guess == secretNumber) {
                JOptionPane.showMessageDialog(this,
                        "Поздравляем! Вы угадали число " + secretNumber + "!",
                        "Победа!",
                        JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            } else {
                if (attemptsLeft > 0) {
                    String hint = guess < secretNumber ? "больше" : "меньше";
                    JOptionPane.showMessageDialog(this,
                            "Неверно! Загаданное число " + hint + " чем " + guess +
                                    "\nОсталось попыток: " + attemptsLeft,
                            "Подсказка",
                            JOptionPane.WARNING_MESSAGE);
                    guessField.setText("");
                    guessField.requestFocus();
                } else {
                    JOptionPane.showMessageDialog(this,
                            "Вы проиграли! Загаданное число было: " + secretNumber,
                            "Конец игры",
                            JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                }
            }

            updateInfo();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Введите корректное число!", "Ошибка", JOptionPane.ERROR_MESSAGE);
            guessField.setText("");
            guessField.requestFocus();
        }
    }

    private void updateInfo() {
        infoLabel.setText("Угадайте число от 0 до 20. Попыток: " + attemptsLeft);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Ugadaika().setVisible(true);
            }
        });
    }
}