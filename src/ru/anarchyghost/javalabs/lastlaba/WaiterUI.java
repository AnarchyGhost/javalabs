package ru.anarchyghost.javalabs.lastlaba;

import javax.swing.*;
import java.awt.*;

public class WaiterUI extends JFrame {
    InternetOrdersManager internetOrdersManager;
    TableOrdersManager tableOrdersManager;
    JMenuBar jMenuBar=new JMenuBar();
    JMenu jMode=new JMenu("Mode");
    JMenuItem waiterMode=new JMenuItem("Client");
    JPanel menuItemsPanel=new JPanel();
    JPanel buttonsPanel=new JPanel();
    JLabel costs=new JLabel("");
    WaiterUI(){
        super("Waiter");
        setSize(1280, 720);
        setLocation((1920 - 1280) / 2, (1080 - 720) / 2);
    }

    WaiterUI(TableOrdersManager tableOrdersManager,InternetOrdersManager internetOrdersManager){
        this();
        this.tableOrdersManager=tableOrdersManager;
        this.internetOrdersManager=internetOrdersManager;
        allOrders();
    }

    private void allOrders(){
        menuItemsPanel=new JPanel();
        menuItemsPanel.setLayout(new GridBagLayout());
        buttonsPanel=new JPanel();
        this.getContentPane().removeAll();
        setLayout(new GridBagLayout());
        jMode.add(waiterMode);
        jMenuBar.add(jMode);

        GridBagConstraints jMenuBarConstraints= new GridBagConstraints();
        jMenuBarConstraints.gridwidth=2;
        jMenuBarConstraints.fill=GridBagConstraints.HORIZONTAL;
        jMenuBarConstraints.weightx=1.0f;
        jMenuBarConstraints.weighty=0.05;
        jMenuBarConstraints.anchor=GridBagConstraints.NORTHWEST;
        jMenuBarConstraints.gridx=0;
        jMenuBarConstraints.gridy=0;

        add(jMenuBar,jMenuBarConstraints);

        buttonsPanel.setLayout(new BoxLayout(buttonsPanel,BoxLayout.Y_AXIS));
        buttonsPanel.add(costs);
        costs.setText(String.valueOf(this.tableOrdersManager.ordersCostSummary()+this.internetOrdersManager.ordersCostSummary()));
        waiterMode.addActionListener(e -> {
            setVisible(false);
            new ClientUI(this.tableOrdersManager,this.internetOrdersManager);
        });

        GridBagConstraints textFieldsConstraint= new GridBagConstraints();
        textFieldsConstraint.fill=GridBagConstraints.BOTH;
        textFieldsConstraint.weightx=0.5f;
        textFieldsConstraint.weighty=1f;
        textFieldsConstraint.anchor=GridBagConstraints.SOUTHWEST;
        textFieldsConstraint.gridx=0;
        textFieldsConstraint.gridy=1;
        JScrollPane menuPane=new JScrollPane(menuItemsPanel);
        add(menuPane,textFieldsConstraint);
        textFieldsConstraint.gridx=1;
        add(buttonsPanel,textFieldsConstraint);

        int i=0;
        for(Order order: this.internetOrdersManager.getOrders()){
            setVisible(false);
            new OrderUI(order,menuItemsPanel,i,internetOrdersManager,this);
            i++;
        }
        for(Order order: this.tableOrdersManager.getOrders()){
            setVisible(false);
            new OrderUI(order,menuItemsPanel,i,tableOrdersManager,this);
            i++;
        }

        this.setVisible(true);
    }
}
