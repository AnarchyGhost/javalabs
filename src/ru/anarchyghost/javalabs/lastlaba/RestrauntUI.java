package ru.anarchyghost.javalabs.lastlaba;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RestrauntUI extends JFrame {
    JMenuBar jMenuBar=new JMenuBar();
    JMenu jMode=new JMenu("Mode");
    JMenuItem clientMode=new JMenuItem("Client");
    JMenuItem waiterMode=new JMenuItem("Waiter");
    RestrauntUI() {
        setSize(1280, 720);
        setLocation((1920 - 1280) / 2, (1080 - 720) / 2);
        setLayout(new GridBagLayout());
        jMode.add(clientMode);
        jMode.add(waiterMode);
        jMenuBar.add(jMode);
        GridBagConstraints jMenuBarConstraints= new GridBagConstraints();
        jMenuBarConstraints.fill=GridBagConstraints.HORIZONTAL;
        jMenuBarConstraints.weightx=1.0f;
        jMenuBarConstraints.weighty=0.05;
        jMenuBarConstraints.anchor=GridBagConstraints.NORTHWEST;
        jMenuBarConstraints.gridx=0;
        jMenuBarConstraints.gridy=0;
        add(jMenuBar,jMenuBarConstraints);
        setVisible(true);
        clientMode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new ClientUI(new TableOrdersManager(),new InternetOrdersManager());
            }
        });
        waiterMode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }

    public static void main(String[] args){
        new RestrauntUI();
    }
}
