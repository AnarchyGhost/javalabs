package ru.anarchyghost.javalabs.lastlaba;

import javax.swing.*;

public class BusyTablesException extends Exception {
    public BusyTablesException(){
        JOptionPane.showMessageDialog(null,"Все столы заняты. Подождите или закажите доставку, пожалуйста.","All tables are busy",JOptionPane.ERROR_MESSAGE);
    }
}
