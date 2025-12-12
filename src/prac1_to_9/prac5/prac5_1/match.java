package prac1_to_9.prac5.prac5_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class match extends JFrame{
    private int milanscore;
    private int madridscore;

    private JButton milanbutton;
    private JButton madridbutton;
    private JLabel resultLabel;
    private JLabel lastscoreLabel;
    private JLabel winnerLabel;

    public match() {
        setTitle("Football match: AC Milan vs Real Madrid");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,250);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5,1,10,10));

        milanbutton = new JButton("AC Milan");
        madridbutton = new JButton("Real Madrid");
        resultLabel = new JLabel("Result: 0 x 0", SwingConstants.CENTER);
        lastscoreLabel = new JLabel("Last Scorer: N/A", SwingConstants.CENTER);
        winnerLabel = new JLabel("Draw", SwingConstants.CENTER);

        milanbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                milanscore++;
                updateScore("AC Milan");
            }
        });

        madridbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                madridscore++;
                updateScore("Real Madrid");
            }
        });

        add(milanbutton);
        add(madridbutton);
        add(resultLabel);
        add(lastscoreLabel);
        add(winnerLabel);
    }

    private void updateScore(String lastScorer) {
        resultLabel.setText("Result:" + milanscore + "X" + madridscore);
        lastscoreLabel.setText("Last Scorer:" + lastScorer);

        if (milanscore > madridscore) {
            winnerLabel.setText("Winner: AC Milan");
        } else if (madridscore>milanscore) {
            winnerLabel.setText("Winner: Real Madrid");
        }else {
            winnerLabel.setText("Draw");
        }
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                match app = new match();
                app.setVisible(true);
            }
        });
    }
}