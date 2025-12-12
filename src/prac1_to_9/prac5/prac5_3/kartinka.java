package prac1_to_9.prac5.prac5_3;

import javax.swing.*;
import java.awt.*;

public class kartinka extends JFrame {
    private String imagepath;

    public kartinka(String imagepath) {
        this.imagepath = imagepath;

        setTitle("Картинка");
        setSize(463,460);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        if (imagepath != null && !imagepath.isEmpty()) {
            ImageIcon icon = new ImageIcon(imagepath);
            Image image = icon.getImage();

            if (image.getWidth(null) != -1) {
                int width = 463;
                int height = 460;
                g.drawImage(image,5,5, width, height,this);
            }else {
                g.drawString("Image not found:" + imagepath,50,50);
            }
        }else {
            g.drawString("No image path provided",50,50);
        }
    }

    public static void main(String[] args) {
        String imagepath = args.length > 0 ? args[0] : "";

        SwingUtilities.invokeLater(() -> {
            new kartinka(imagepath).setVisible(true);
        });
    }
}
