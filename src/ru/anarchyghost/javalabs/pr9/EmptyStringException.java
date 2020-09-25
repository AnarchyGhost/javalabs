package ru.anarchyghost.javalabs.pr9;

import javax.swing.*;

public class EmptyStringException extends Exception {
    EmptyStringException(String message){
        JOptionPane.showMessageDialog(null, "Field "+message+" is empty. Try again please","Field is empty",JOptionPane.ERROR_MESSAGE);
    }
}
