package controller;

import model.Model;
import model.QueryResult;
import view.PopUpView;
import view.View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private View view;
    private Model query;

    public Controller() {
        this.view = new View();
        this.query = new Model();
        attachListeners();
    }

    private void attachListeners() {
        view.getButonCalcul().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                QueryResult result = query.select_all();
                PopUpView pop = new PopUpView(result);

                pop.getEnter().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int item = pop.getSelectFood().getSelectedIndex();
                        int calorii = (int) result.getData()[item][1];
                        int proteine =(int) result.getData()[item][2];
                        String um = (String) result.getData()[item][3];
                        int text = 0 ;
                        try {
                            text = Integer.parseInt(pop.getSelectGrams().getText());
                            if(um.equals("gr")){
                                JOptionPane.showMessageDialog(new JOptionPane(), "Calorii: " + (calorii*text/100) + "\nProteine: " + (proteine*text/100));
                            }else{
                                JOptionPane.showMessageDialog(new JOptionPane(), "Calorii: " + (calorii*text) + "\nProteine: " + (proteine*text));
                            }
                        }
                        catch(Exception exception) {
                            JOptionPane.showMessageDialog(new JOptionPane(), "VEZI BA CA TRB NUMAR!!!!!!!!!!!!!!!!!!!");
                        }

                    }
                });
            }
        });


    }

}