package prac10_to_19.prac15.prac15_2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Vibor extends JFrame {
    private JComboBox<String> countrybox;
    private JTextArea infocountry;

    public Vibor() {
        setTitle("Страны");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,250);
        setLocationRelativeTo(null);
        createComponents();
        layoutCompanents();
    }

    private void createComponents() {
        String[] countries = {"Россия", "США", "Германия", "Франция", "Япония", "Китай", "Бразилия", "Индия"};
        countrybox = new JComboBox<>(countries);

        infocountry = new JTextArea();
        infocountry.setEditable(false);
        infocountry.setLineWrap(true);
        infocountry.setWrapStyleWord(true);

        countrybox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateCountryInfo();
            }
        });

        updateCountryInfo();
    }

    private void layoutCompanents() {
        setLayout(new BorderLayout(10,10));

        JPanel toppanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        toppanel.add(new JLabel("Выбери страну"));
        toppanel.add(countrybox);

        JScrollPane scrollPane = new JScrollPane(infocountry);

        add(toppanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        ((JPanel)getContentPane()).setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
    }

    private void updateCountryInfo() {
        String selectedCountry = (String) countrybox.getSelectedItem();
        String info = "";

        switch (selectedCountry) {
            case "Россия":
                info = "Российская Федерация\n\n" +
                        "Столица: Москва\n" +
                        "Население: ~146 млн человек\n" +
                        "Площадь: 17 098 246 км²\n" +
                        "Язык: русский\n" +
                        "Валюта: российский рубль (RUB)";
                break;

            case "США":
                info = "Соединённые Штаты Америки\n\n" +
                        "Столица: Вашингтон\n" +
                        "Население: ~331 млн человек\n" +
                        "Площадь: 9 833 520 км²\n" +
                        "Язык: английский\n" +
                        "Валюта: доллар США (USD)";
                break;

            case "Германия":
                info = "Федеративная Республика Германия\n\n" +
                        "Столица: Берлин\n" +
                        "Население: ~83 млн человек\n" +
                        "Площадь: 357 588 км²\n" +
                        "Язык: немецкий\n" +
                        "Валюта: евро (EUR)";
                break;

            case "Франция":
                info = "Французская Республика\n\n" +
                        "Столица: Париж\n" +
                        "Население: ~67 млн человек\n" +
                        "Площадь: 643 801 км²\n" +
                        "Язык: французский\n" +
                        "Валюта: евро (EUR)";
                break;

            case "Япония":
                info = "Япония\n\n" +
                        "Столица: Токио\n" +
                        "Население: ~126 млн человек\n" +
                        "Площадь: 377 975 км²\n" +
                        "Язык: японский\n" +
                        "Валюта: японская иена (JPY)";
                break;

            case "Китай":
                info = "Китайская Народная Республика\n\n" +
                        "Столица: Пекин\n" +
                        "Население: ~1,4 млрд человек\n" +
                        "Площадь: 9 596 961 км²\n" +
                        "Язык: китайский\n" +
                        "Валюта: китайский юань (CNY)";
                break;

            case "Бразилия":
                info = "Федеративная Республика Бразилия\n\n" +
                        "Столица: Бразилиа\n" +
                        "Население: ~213 млн человек\n" +
                        "Площадь: 8 515 767 км²\n" +
                        "Язык: португальский\n" +
                        "Валюта: бразильский реал (BRL)";
                break;

            case "Индия":
                info = "Республика Индия\n\n" +
                        "Столица: Нью-Дели\n" +
                        "Население: ~1,38 млрд человек\n" +
                        "Площадь: 3 287 263 км²\n" +
                        "Языки: хинди, английский\n" +
                        "Валюта: индийская рупия (INR)";
                break;
        }

        infocountry.setText(info);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getLookAndFeel());
        } catch (Exception e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Vibor().setVisible(true);
            }
        });
    }
}
