package ru.anarchyghost.javalabs.lastlaba;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ClientUI extends JFrame {
    TableOrdersManager tableOrdersManager;
    InternetOrdersManager internetOrdersManager;
    OrdersManager currentOrdersManager;
    JMenuBar jMenuBar=new JMenuBar();
    JMenu jMode=new JMenu("Mode");
    JMenuItem waiterMode=new JMenuItem("Waiter");
    JButton internet=new JButton("Internet Order");
    JButton table=new JButton("Table Order");
    JPanel menuItemsPanel=new JPanel();
    JPanel buttonsPanel=new JPanel();
    JLabel costs=new JLabel("");
    MenuItemUI[] menuItemUIS=new MenuItemUI[18];
    Order current=new RestrauntOrder();
    JButton[] tableButtons=new JButton[20];

    private void toChooseTable(){
        this.getContentPane().removeAll();
        setLayout(new GridLayout(7,3));
        int[] freeTables=tableOrdersManager.freeTableNumbers();
        for (int i=0;i<20;i++){
            tableButtons[i]=new JButton(String.valueOf(i+1));
            tableButtons[i].setEnabled(false);
            int finalI = i;
            tableButtons[i].addActionListener(e -> {
                current.setCustomer(null);
                tableOrdersManager.addOrder(current, finalI);
                setVisible(false);
                toDoOrder();
            });
            add(tableButtons[i]);
        }
        for(int i:freeTables){
            tableButtons[i].setEnabled(true);
        }
        setVisible(true);

    }

    private void toDoOrder(){
        menuItemsPanel=new JPanel();
        buttonsPanel=new JPanel();
        current=new RestrauntOrder();
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
        buttonsPanel.add(internet);
        buttonsPanel.add(table);
        buttonsPanel.add(costs);

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

        menuItemsPanel.setLayout(new BoxLayout(menuItemsPanel,BoxLayout.Y_AXIS));
        DrinkTypeEnum[] typeEnums=DrinkTypeEnum.values();
        int i=0;
        for(DrinkTypeEnum s: typeEnums) {
            menuItemUIS[i]=new MenuItemUI(s, menuItemsPanel,this);
            i++;
        }

        costs.setText(String.valueOf(current.costTotal()));
        internet.addActionListener(e -> toDoClient());
        table.addActionListener(e -> {
//                setVisible(false);
            toChooseTable();
        });
        setVisible(true);
    }

    private void toDoClient(){
        System.out.println();
        this.getContentPane().removeAll();
        JLabel cityLabel=new JLabel("Город:");
        JLabel zipCode=new JLabel("Индекс");
        JLabel streetLabel=new JLabel("Улица");
        JLabel buildingLabel=new JLabel("Строение");
        JLabel buildingLetterLabel=new JLabel("Буква");
        JLabel appartamentLabel=new JLabel("Квартира");
        JLabel firstNameLabel=new JLabel("Имя");
        JLabel secondNameLabel=new JLabel("Фамилия");
        JLabel ageLabel=new JLabel("Возраст");
        JTextField cityField=new JTextField();
        JTextField zipField=new JTextField();
        JTextField streetField=new JTextField();
        JTextField buildingField=new JTextField();
        JTextField letterField=new JTextField();
        JTextField appartamentField=new JTextField();
        JTextField firstNameField=new JTextField();
        JTextField secondNameField=new JTextField();
        JTextField ageField=new JTextField();
        JButton okButton=new JButton("Продолжить");
        JButton cancelButton=new JButton("Отмена");
        setLayout(new GridLayout(10,2));
        add(cityLabel);
        add(cityField);
        add(zipCode);
        add(zipField);
        add(streetLabel);
        add(streetField);
        add(buildingLabel);
        add(buildingField);
        add(buildingLetterLabel);
        add(letterField);
        add(appartamentLabel);
        add(appartamentField);
        add(firstNameLabel);
        add(firstNameField);
        add(secondNameLabel);
        add(secondNameField);
        add(ageLabel);
        add(ageField);
        add(okButton);
        add(cancelButton);
        setVisible(false);
        setVisible(true);
        okButton.addActionListener(e -> {
            InternetOrder internetOrder=new InternetOrder(current);
            internetOrder.setCustomer(new Customer(firstNameField.getText(),secondNameField.getText(), Integer.parseInt(ageField.getText()),new Adress(
                    cityField.getText(), Integer.parseInt(zipField.getText()),streetField.getText(), Integer.parseInt(buildingField.getText()),letterField.getText().toCharArray()[0], Integer.parseInt(appartamentField.getText())
            )));
            internetOrdersManager.add(internetOrder);
            setVisible(false);
            toDoOrder();
        });
        cancelButton.addActionListener(e -> {
            setVisible(false);
            toDoOrder();
        });

    }

    ClientUI(TableOrdersManager tableOrdersManager,InternetOrdersManager internetOrdersManager){
        this();
        this.tableOrdersManager=tableOrdersManager;
        this.internetOrdersManager=internetOrdersManager;
        waiterMode.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                new WaiterUI(tableOrdersManager,internetOrdersManager);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                new WaiterUI(tableOrdersManager,internetOrdersManager);
                setVisible(false);
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
        toDoOrder();
    }

    ClientUI() {
        super("Client");
        setSize(1280, 720);
        setLocation((1920 - 1280) / 2, (1080 - 720) / 2);
    }




}
