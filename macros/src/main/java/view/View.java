package view;

import javax.swing.*;
import java.awt.*;


public class View extends JFrame{
    private JButton butonCalcul;

    private JPanel panel;
    //private

    public View(){

        this.panel = new JPanel();
        panel.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(900, 900);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        this.butonCalcul = new JButton("Calculate Macros");

        panel.add(butonCalcul, BorderLayout.CENTER);
        this.add(panel);

    }

    public JButton getButonCalcul() {
        return butonCalcul;
    }

    public JPanel getPanel() {
        return panel;
    }



}
