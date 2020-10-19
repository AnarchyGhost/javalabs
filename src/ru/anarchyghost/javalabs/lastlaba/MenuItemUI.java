package ru.anarchyghost.javalabs.lastlaba;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MenuItemUI {
    JPanel jPanel=new JPanel();
    JButton plus=new JButton("Plus");
    JButton minus=new JButton("Minus");
    JLabel description=new JLabel();
    int count=0;
    JLabel countField=new JLabel(String.valueOf(count));
    JLabel name=new JLabel("product");

    MenuItemUI(DrinkTypeEnum typeEnum, JPanel panel, ClientUI clientUI){
        name.setText(typeEnum.getName());
        description.setText(typeEnum.getDescription());
        plus.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                count++;
                countField.setText(String.valueOf(count));
                clientUI.current.add(new Drink(typeEnum));
                clientUI.costs.setText(String.valueOf(clientUI.current.costTotal()));
                System.out.println(clientUI.current.costTotal());
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        minus.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if( count>0){
                    count--;
                    countField.setText(String.valueOf(count));
                    clientUI.current.remove(new Drink(typeEnum));
                    clientUI.costs.setText(String.valueOf(clientUI.current.costTotal()));
                    System.out.println(clientUI.current.itemsQuantity());
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        jPanel.setLayout(new GridBagLayout());
        GridBagConstraints nameConstraints=new GridBagConstraints();
        nameConstraints.gridwidth=3;
        nameConstraints.fill=GridBagConstraints.HORIZONTAL;
        nameConstraints.weightx=1.0f;
        nameConstraints.weighty=0.05;
        nameConstraints.anchor=GridBagConstraints.NORTH;
        nameConstraints.gridx=0;
        nameConstraints.gridy=0;

        jPanel.add(name,nameConstraints);

        nameConstraints.gridwidth=1;
        nameConstraints.fill=GridBagConstraints.HORIZONTAL;
        nameConstraints.weightx=0.33f;
        nameConstraints.weighty=0.05f;
        nameConstraints.anchor=GridBagConstraints.NORTH;
        nameConstraints.gridx=0;
        nameConstraints.gridy=2;

        jPanel.add(minus,nameConstraints);

        nameConstraints.gridwidth=1;
        nameConstraints.fill=GridBagConstraints.HORIZONTAL;
        nameConstraints.weightx=0.33f;
        nameConstraints.weighty=0.05f;
        nameConstraints.anchor=GridBagConstraints.NORTH;
        nameConstraints.gridx=1;
        nameConstraints.gridy=2;
        countField.setHorizontalAlignment(SwingConstants.CENTER);
        jPanel.add(countField,nameConstraints);

        nameConstraints.gridwidth=1;
        nameConstraints.fill=GridBagConstraints.HORIZONTAL;
        nameConstraints.weightx=0.33f;
        nameConstraints.weighty=0.05f;
        nameConstraints.anchor=GridBagConstraints.NORTH;
        nameConstraints.gridx=2;
        nameConstraints.gridy=2;

        jPanel.add(plus,nameConstraints);

        panel.add(jPanel);




    }

}
