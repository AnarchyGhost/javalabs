package ru.anarchyghost.javalabs.pr9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class StudentDBUI extends JFrame {
    JTextArea studentsList=new JTextArea(30,30);
    JScrollPane jScrollPane=new JScrollPane(studentsList);
    JButton sortButton=new JButton("Sort");
    JButton addButton=new JButton("Add");
    JButton findByNameButton=new JButton("Find by name");
    JTextField idField=new JTextField(20);
    JTextField nameField=new JTextField(20);
    JTextField gpaField=new JTextField(20);
    JLabel idLabel= new JLabel("ID: ");
    JLabel nameLabel= new JLabel("Name: ");
    JLabel gpaLabel=new JLabel("GPA: ");
    JPanel buttonsPanel=new JPanel();
    JPanel textPanel=new JPanel();
    StudentBD studentBd=new StudentBD();

    private void fillWindow(){
        studentsList.setEditable(false);
        buttonsPanel.add(sortButton);
        buttonsPanel.add(addButton);
        buttonsPanel.add(findByNameButton);
        textPanel.add(idLabel);
        textPanel.add(idField);
        textPanel.add(nameLabel);
        textPanel.add(nameField);
        textPanel.add(gpaLabel);
        textPanel.add(gpaField);
        setLayout(new GridBagLayout());
        GridBagConstraints textFieldsConstraint= new GridBagConstraints();
        textFieldsConstraint.fill=GridBagConstraints.HORIZONTAL;
        textFieldsConstraint.weightx=1.0f;
        textFieldsConstraint.weighty=0.1f;
        textFieldsConstraint.anchor=GridBagConstraints.SOUTH;
        textFieldsConstraint.gridx=0;
        textFieldsConstraint.gridy=1;
        GridBagConstraints textFieldsConstraint2= new GridBagConstraints();
        textFieldsConstraint2.fill=GridBagConstraints.HORIZONTAL;
        textFieldsConstraint2.weightx=1.0f;
        textFieldsConstraint2.weighty=0.1f;
        textFieldsConstraint2.gridx=0;
        textFieldsConstraint2.gridy=2;
        textFieldsConstraint2.anchor=GridBagConstraints.SOUTH;
        GridBagConstraints scrollConstraint=new GridBagConstraints();
        scrollConstraint.fill=GridBagConstraints.HORIZONTAL;
        scrollConstraint.anchor=GridBagConstraints.NORTH;
        scrollConstraint.weightx=1.0f;
        scrollConstraint.weighty=0.8f;
        scrollConstraint.gridx=0;
        scrollConstraint.gridy=0;
        add(jScrollPane,scrollConstraint);
        add(textPanel,textFieldsConstraint,1);
        add(buttonsPanel,textFieldsConstraint2,2);
    }

    public void setClickers(){
       addButton.addMouseListener(new MouseListener() {
           @Override
           public void mouseClicked(MouseEvent e) {

           }

           @Override
           public void mousePressed(MouseEvent e) {
               try{
                   studentBd.add(studentBd.getStudent(nameField.getText(),idField.getText(),gpaField.getText()));
               }catch (EmptyStringException EE){

               }catch (NumberFormatException E){
                   JOptionPane.showMessageDialog(null, "Not correct input. Try again please","Input Not Correct",JOptionPane.ERROR_MESSAGE);
               }

               studentsList.setText(studentBd.toString());
               idField.setText("");
               nameField.setText("");
               gpaField.setText("");
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
       sortButton.addMouseListener(new MouseListener() {
           @Override
           public void mouseClicked(MouseEvent e) {

           }

           @Override
           public void mousePressed(MouseEvent e) {
               studentBd.sortStudents();
               studentsList.setText(studentBd.toString());
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
       findByNameButton.addMouseListener(new MouseListener() {
           @Override
           public void mouseClicked(MouseEvent e) {

           }

           @Override
           public void mousePressed(MouseEvent e) {
               try {
                   JOptionPane.showMessageDialog(null,"Your Student: "+ studentBd.find(nameField.getText()));
               } catch (StudentNotFoundException studentNotFoundException) {
               }
               nameField.setText("");
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
    }

    StudentDBUI(){
        JFrame.setDefaultLookAndFeelDecorated(true);
        JDialog.setDefaultLookAndFeelDecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1280, 720);
        setLocation((1920-1280)/2,(1080-720)/2);

        this.fillWindow();
        this.setClickers();
        setVisible(true);
    }
}
