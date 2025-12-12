package prac10_to_19.prac12.prac12_1;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Window extends JFrame {
    private MShape[] shapes;

    public Window() {
        setTitle("Random");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        shapes = Rand(20);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.WHITE);
                g.fillRect(0, 0, getWidth(), getHeight());

                for (MShape shape : shapes) {
                    shape.draw(g);
                }
            }
        };

        add(panel);
    }


    private MShape[] Rand(int cnt) {
        Random random = new Random();
        MShape[] shapes = new MShape[cnt];

        for (int i = 0; i < cnt; i++) {
            Color color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));

            int x = random.nextInt(700);
            int y = random.nextInt(500);

            if (random.nextBoolean()) {
                int r = 15 + random.nextInt(50);
                shapes[i] = new Circle(color, x, y, r);
            } else {
                int a = 25 + random.nextInt(70);
                int b = 25 + random.nextInt(70);
                shapes[i] = new MRectangle(color, x, y, a, b);
            }
        }

        return shapes;
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Window().setVisible(true);
        });
    }
}
