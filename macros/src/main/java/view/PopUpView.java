package view;

import model.QueryResult;

import javax.swing.*;
import java.awt.*;

public class PopUpView extends JFrame{

    private JTextField selectGrams;
    private JComboBox selectFood;
    private JPanel panel;
    private JLabel label;
    private JButton enter;

    public PopUpView(QueryResult result){
        this.selectGrams = new JTextField();
        this.selectFood = new JComboBox();
        this.enter = new JButton("ENTER");
        this.label = new JLabel("Select grams/nr buc");
        this.panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1, 100, 100));

        for (Object[] i : result.getData())
        {
            selectFood.addItem(i[0]);
        }

        panel.add(selectFood);
        panel.add(label);
        panel.add(selectGrams);
        panel.add(enter);

        this.add(panel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(900, 900);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    public JTextField getSelectGrams() {
        return selectGrams;
    }

    public JComboBox getSelectFood() {
        return selectFood;
    }

    public JPanel getPanel() {
        return panel;
    }

    public JLabel getLabel() {
        return label;
    }

    public JButton getEnter() {
        return enter;
    }
}

