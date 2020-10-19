package ru.anarchyghost.javalabs.lastlaba;

import javax.swing.*;
import java.awt.*;

public class OrderUI {
    JLabel number=new JLabel("Number");
    JLabel costs;
    JLabel type;
    JLabel customer;
    JPanel orderPanel;
    JPanel jPanel;
    JButton jButton=new JButton("Look at Order");
    JButton cancelButton=new JButton("Order Has Done");
    OrdersManager ordersManager;
    Order order;
    WaiterUI waiterUI;
    OrderUI(Order order, JPanel jPanel,int i,OrdersManager ordersManager,WaiterUI waiterUI){
        this.jPanel=jPanel;
        this.order=order;
        this.waiterUI=waiterUI;
        orderPanel=new JPanel(new GridBagLayout());
        costs=new JLabel(String.valueOf(order.costTotal()));
        if(order.getCustomer()==null)type=new JLabel("Restraunt order");
        else{
            type=new JLabel("Internet Order");
        }
        GridBagConstraints nameConstraints=new GridBagConstraints();
        nameConstraints.weightx=1.0f;
        nameConstraints.weighty=0.05;
        nameConstraints.anchor=GridBagConstraints.NORTHWEST;
        nameConstraints.gridx=0;
        nameConstraints.gridy=0;
        orderPanel.add(number,nameConstraints);
        nameConstraints.gridy=1;
        orderPanel.add(costs,nameConstraints);
        nameConstraints.gridy=2;
        orderPanel.add(type,nameConstraints);
        nameConstraints.fill=GridBagConstraints.BOTH;
        nameConstraints.gridy=3;
        nameConstraints.weighty=1;
        nameConstraints.weightx=1;
        nameConstraints.gridx=1;
        nameConstraints.gridy=0;
        nameConstraints.gridheight=3;
        orderPanel.add(jButton,nameConstraints);
        nameConstraints=new GridBagConstraints();
        nameConstraints.fill=GridBagConstraints.NONE;
        nameConstraints.weightx=1.0f;
        nameConstraints.weighty=0.05;
        nameConstraints.anchor=GridBagConstraints.NORTHWEST;
        nameConstraints.gridx=0;
        nameConstraints.gridy=4;

        if(order.getCustomer()!=null){
            customer=new JLabel(order.getCustomer().getFirstName()+" "+order.getCustomer().getSecondName());
            orderPanel.add(customer,nameConstraints);
        }
        nameConstraints.gridy=i;
        jPanel.add(orderPanel,nameConstraints);

        jButton.addActionListener(e->{
            LookAtOrder();
        });

        this.ordersManager=ordersManager;
    }

    private void LookAtOrder(){

        JFrame window=new JFrame("Order");
        window.setSize(1280, 720);
        window.setLocation((1920 - 1280) / 2, (1080 - 720) / 2);
        JPanel menuItemsPanel=new JPanel();
        JPanel buttonsPanel=new JPanel();
        window.setLayout(new GridBagLayout());
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel,BoxLayout.Y_AXIS));

        buttonsPanel.add(costs);
        GridBagConstraints textFieldsConstraint= new GridBagConstraints();
        textFieldsConstraint.fill=GridBagConstraints.BOTH;
        textFieldsConstraint.weightx=0.5f;
        textFieldsConstraint.weighty=1f;
        textFieldsConstraint.anchor=GridBagConstraints.SOUTHWEST;
        textFieldsConstraint.gridx=0;
        textFieldsConstraint.gridy=1;
        JScrollPane menuPane=new JScrollPane(menuItemsPanel);
        window.add(menuPane,textFieldsConstraint);
        textFieldsConstraint.gridx=1;
        window.add(buttonsPanel,textFieldsConstraint);

        menuItemsPanel.setLayout(new GridBagLayout());
        DrinkTypeEnum[] typeEnums=DrinkTypeEnum.values();
        int i=0;
        MenuItem[] menuItems=order.getItems();
        for(MenuItem menuItem:menuItems) {
            System.out.println(menuItem.getName());
            new OrderItemUI(menuItem, menuItemsPanel,order,i);
            i++;
        }

        buttonsPanel.add(cancelButton);
        cancelButton.addActionListener(e->{
            ordersManager.remove(order);
            System.out.println(ordersManager.ordersCostSummary());
            window.setVisible(false);
            waiterUI.costs.setText(String.valueOf(waiterUI.tableOrdersManager.ordersCostSummary()+waiterUI.internetOrdersManager.ordersCostSummary()));
            waiterUI.setVisible(false);
            waiterUI.setVisible(true);
            jPanel.remove(orderPanel);

        });

        costs.setText(String.valueOf(order.costTotal()));
        window.setVisible(true);
    }
}
