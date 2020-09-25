package ru.anarchyghost.javalabs.pr9;

import javax.swing.*;

public class StudentNotFoundException extends Exception {
   StudentNotFoundException(String message){
        JOptionPane.showMessageDialog(null, "Student "+message+" didn't found. Try again please","Student not found",JOptionPane.ERROR_MESSAGE);
    }
}
