package prac10_to_19.prac16.prac16_2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Text extends JFrame {
    private JTextArea textArea;
    private JMenu colorMenu, fontMenu;

    public Text() {
        setTitle("Текстовый редактор");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        createComponents();
        layoutComponents();
        setupMenuBar();
    }

    private void createComponents() {
        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setText("Введите ваш текст здесь...\nВы можете изменить цвет и шрифт через меню.");
        textArea.setFont(new Font("Times New Roman", Font.PLAIN, 14));
    }

    private void layoutComponents() {
        setLayout(new BorderLayout());

        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void setupMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        colorMenu = new JMenu("Цвет");

        JMenuItem blueItem = new JMenuItem("Синий");
        JMenuItem redItem = new JMenuItem("Красный");
        JMenuItem blackItem = new JMenuItem("Черный");

        blueItem.addActionListener(new ColorAction(Color.BLUE));
        redItem.addActionListener(new ColorAction(Color.RED));
        blackItem.addActionListener(new ColorAction(Color.BLACK));

        colorMenu.add(blueItem);
        colorMenu.add(redItem);
        colorMenu.add(blackItem);

        fontMenu = new JMenu("Шрифт");

        JMenuItem timesItem = new JMenuItem("Times New Roman");
        JMenuItem sansSerifItem = new JMenuItem("MS Sans Serif");
        JMenuItem courierItem = new JMenuItem("Courier New");

        timesItem.addActionListener(new FontAction("Times New Roman"));
        sansSerifItem.addActionListener(new FontAction("MS Sans Serif"));
        courierItem.addActionListener(new FontAction("Courier New"));

        fontMenu.add(timesItem);
        fontMenu.add(sansSerifItem);
        fontMenu.add(courierItem);

        menuBar.add(colorMenu);
        menuBar.add(fontMenu);

        setJMenuBar(menuBar);
    }

    private class ColorAction implements ActionListener {
        private Color color;

        public ColorAction(Color color) {
            this.color = color;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            textArea.setForeground(color);
        }
    }

    private class FontAction implements ActionListener {
        private String fontName;

        public FontAction(String fontName) {
            this.fontName = fontName;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Font currentFont = textArea.getFont();
            Font newFont = new Font(fontName, currentFont.getStyle(), currentFont.getSize());
            textArea.setFont(newFont);
        }
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
                new Text().setVisible(true);
            }
        });
    }
}