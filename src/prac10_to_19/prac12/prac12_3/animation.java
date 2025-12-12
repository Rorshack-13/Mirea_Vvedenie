package prac10_to_19.prac12.prac12_3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;

public class animation extends JPanel implements ActionListener {
    private Image sprite;
    private int frameWidth = 92;
    private int frameHeight = 129;
    private int totalFrames = 8;
    private int currentFrame = 0;
    private Timer timer;
    private boolean isRunning = true;
    private double rotation = 0.0; // Угол поворота в градусах

    public animation() {
        ImageIcon icon = new ImageIcon("C:\\Users\\Эрдем\\Desktop\\2025-09-29_17-30-27.png");
        sprite = icon.getImage();

        timer = new Timer(100, this);
        timer.start();

        setPreferredSize(new Dimension(600, 400));
        setBackground(Color.WHITE);
        setupControls();
    }

    private void setupControls() {
        JButton startButton = new JButton("Старт");
        JButton stopButton = new JButton("Стоп");
        JButton rotateLeftButton = new JButton("Повернуть налево");
        JButton rotateRightButton = new JButton("Повернуть направо");
        JButton rotateUpButton = new JButton("Повернуть вверх");
        JButton rotateDownButton = new JButton("Повернуть вниз");

        startButton.addActionListener(e -> startAnimation());
        stopButton.addActionListener(e -> stopAnimation());
        rotateLeftButton.addActionListener(e -> rotateLeft());
        rotateRightButton.addActionListener(e -> rotateRight());
        rotateUpButton.addActionListener(e -> rotateUp());
        rotateDownButton.addActionListener(e -> rotateDown());

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        controlPanel.add(startButton);
        controlPanel.add(stopButton);
        controlPanel.add(rotateLeftButton);
        controlPanel.add(rotateRightButton);
        controlPanel.add(rotateUpButton);
        controlPanel.add(rotateDownButton);

        setLayout(new BorderLayout());
        add(controlPanel, BorderLayout.SOUTH);
    }

    private void startAnimation() {
        if (!isRunning) {
            timer.start();
            isRunning = true;
        }
    }

    private void stopAnimation() {
        if (isRunning) {
            timer.stop();
            isRunning = false;
        }
    }

    private void rotateLeft() {
        rotation = 180.0;
        normalizeRotation();
        repaint();
    }

    private void rotateRight() {
        rotation = 0;
        normalizeRotation();
        repaint();
    }

    private void rotateUp() {
        rotation = -90.0;
        repaint();
    }

    private void rotateDown() {
        rotation = 90.0;
        repaint();
    }

    private void normalizeRotation() {
        rotation = rotation % 360;
        if (rotation < 0) {
            rotation += 360;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        AffineTransform originalTransform = g2d.getTransform();

        int centerX = getWidth() / 2 - frameWidth / 2;
        int centerY = getHeight() / 2 - frameHeight / 2;

        if (sprite != null) {
            int srcX = currentFrame * frameWidth;
            int srcY = 0;

            AffineTransform transform = new AffineTransform();

            int spriteCenterX = centerX + frameWidth / 2;
            int spriteCenterY = centerY + frameHeight / 2;

            transform.translate(spriteCenterX, spriteCenterY);
            transform.rotate(Math.toRadians(rotation));
            transform.translate(-spriteCenterX, -spriteCenterY);

            g2d.setTransform(transform);

            g2d.drawImage(sprite, centerX, centerY, centerX + frameWidth, centerY + frameHeight,
                    srcX, srcY, srcX + frameWidth, srcY + frameHeight, this);

        } else {
            g2d.setColor(Color.RED);
            g2d.fillRect(centerX, centerY, frameWidth, frameHeight);
            g2d.setColor(Color.BLACK);
            g2d.drawString("Кадр: " + currentFrame, centerX, centerY - 10);
        }

        g2d.setTransform(originalTransform);

        g2d.setColor(Color.BLACK);
        g2d.drawString("Состояние: " + (isRunning ? "Запущено" : "Остановлено"), 10, 20);
        g2d.drawString("Угол поворота: " + (int)rotation + "°", 10, 40);
        g2d.drawString("Направление: " + getDirection(), 10, 60);
        g2d.drawString("Позиция: Центр экрана", 10, 80);
    }

    private String getDirection() {
        if (rotation == 0) return "Вправо";
        if (rotation == 90) return "Вниз";
        if (rotation == 180) return "Влево";
        if (rotation == 270) return "Вверх";
        if (rotation == -90) return "Вверх";
        return "Другое (" + (int)rotation + "°)";
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        currentFrame = (currentFrame + 1) % totalFrames;
        repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Анимация с поворотом");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new animation());
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}