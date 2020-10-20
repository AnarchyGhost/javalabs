package ru.anarchyghost.javalabs.lastlaba;

import javax.swing.*;

public class EmptyOrderException extends Exception{
    EmptyOrderException(){
        JOptionPane.showMessageDialog(null,"Ваш заказ пуст. Добавьте предметы","Your Order is Empty",JOptionPane.ERROR_MESSAGE);
    }
}
