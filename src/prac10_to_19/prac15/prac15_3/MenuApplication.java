package prac10_to_19.prac15.prac15_3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class MenuApplication extends JFrame {
    private JTextArea textArea;
    private JButton button1, button2;

    public MenuApplication() {
        setTitle("Приложение");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        createMenuBar();
        createComponents();
        layoutComponents();

        setupEventHandlers();
    }

    private void createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("Файл");
        JMenuItem saveItem = new JMenuItem("Сохранить");
        JMenuItem exitItem = new JMenuItem("Выйти");

        fileMenu.add(saveItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        JMenu editMenu = new JMenu("Правка");
        JMenuItem copyItem = new JMenuItem("Копировать");
        JMenuItem cutItem = new JMenuItem("Вырезать");
        JMenuItem pasteItem = new JMenuItem("Вставить");

        editMenu.add(copyItem);
        editMenu.add(cutItem);
        editMenu.add(pasteItem);

        JMenu helpMenu = new JMenu("Справка");
        JMenuItem aboutItem = new JMenuItem("О программе");
        helpMenu.add(aboutItem);

        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        saveItem.addActionListener(e -> saveFile());
        exitItem.addActionListener(e -> System.exit(0));
        copyItem.addActionListener(e -> textArea.copy());
        cutItem.addActionListener(e -> textArea.cut());
        pasteItem.addActionListener(e -> textArea.paste());
        aboutItem.addActionListener(e -> showMessage("О программе: Приложение Swing\nВерсия 1.0"));
    }

    private void saveFile() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Сохранить файл");

        // Показываем диалог сохранения
        int userSelection = fileChooser.showSaveDialog(this);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileToSave = fileChooser.getSelectedFile();

            // Добавляем расширение .txt если его нет
            if (!fileToSave.getName().toLowerCase().endsWith(".txt")) {
                fileToSave = new File(fileToSave.getAbsolutePath() + ".txt");
            }

            try (FileWriter writer = new FileWriter(fileToSave)) {
                // Записываем текст из текстовой области в файл
                writer.write(textArea.getText());
                showMessage("Файл успешно сохранен!\n" + fileToSave.getAbsolutePath());
            } catch (IOException ex) {
                showMessage("Ошибка при сохранении файла: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }


    private void createComponents() {
        button1 = new JButton("Кнопка 1");
        button2 = new JButton("Кнопка 2");

        textArea = new JTextArea();
        textArea.setFont(new Font("Arial", Font.PLAIN,14));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setText("Это область, в которой вы можете писать текст.\n");
    }

    private void layoutComponents() {
        setLayout(new BorderLayout(10, 10));

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 0));
        buttonPanel.add(button1);
        buttonPanel.add(button2);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(400, 200));

        add(buttonPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        ((JPanel)getContentPane()).setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }

    private void setupEventHandlers() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showMessage("Кнопка 1 нажата!");
                textArea.append("\nКнопка 1 была нажата.");
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showMessage("Кнопка 2 нажата!");
                textArea.append("\nКнопка 2 была нажата.");
            }
        });
    }

    private void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
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
                new MenuApplication().setVisible(true);
            }
        });
    }
}