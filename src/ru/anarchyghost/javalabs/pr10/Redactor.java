package ru.anarchyghost.javalabs.pr10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

public class Redactor extends JFrame {
    ICreateDocument createDocument;
    IDocument document;
    JMenuBar jMenuBar=new JMenuBar();
    JMenu jMenu=new JMenu("File");
    JMenuItem newItem=new JMenuItem("New");
    JMenuItem openItem=new JMenuItem("Open");
    JMenuItem saveItem=new JMenuItem("Save");
    JMenuItem exitItem=new JMenuItem("Exit");

    private String[] fileFormats = {"Текстовый","Изображение","Музыка"};
    Redactor(){
        setSize(1280,720);
        setLocation((1920-1280)/2,(1080-720)/2);
        setLayout(new GridBagLayout());
        jMenu.add(newItem);
        jMenu.add(openItem);
        jMenu.add(saveItem);
        jMenu.add(exitItem);
        jMenuBar.add(jMenu);

        GridBagConstraints textFieldsConstraint= new GridBagConstraints();
        textFieldsConstraint.fill=GridBagConstraints.HORIZONTAL;
        textFieldsConstraint.weightx=1.0f;
        textFieldsConstraint.weighty=0.05;
        textFieldsConstraint.anchor=GridBagConstraints.NORTHWEST;
        textFieldsConstraint.gridx=0;
        textFieldsConstraint.gridy=0;

        newItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (document != null) {
                    try {
                        document.exit(Redactor.this);
                        createDocument=null;
                        document = null;
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }

                }
                String result = (String) JOptionPane.showInputDialog(
                        null,
                        "Выберите тип файла:",
                        "Выбор файла",
                        JOptionPane.QUESTION_MESSAGE, null, fileFormats, fileFormats[0]);
                if (result != null) {
                    switch (result) {
                        case ("Текстовый"):
                            createDocument = new TextCreateDocument();
                    }
                }
                if(createDocument!=null) {
                    String name = JOptionPane.showInputDialog(null, "<html><h2>Введите название файла");
                    try {
                        if(name!=null)  {document = createDocument.CreateNew(name);
                        document.open(Redactor.this);}
                    } catch (FileAlreadyExistsException E) {
                        JOptionPane.showMessageDialog(null, "File " + name + ".txt Already Exists");
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            }
        });
        openItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (document != null)
                    try {
                        document.exit(Redactor.this);
                        createDocument=null;
                        document = null;
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                String result = (String) JOptionPane.showInputDialog(
                        null,
                        "Выберите тип файла:",
                        "Выбор файла",
                        JOptionPane.QUESTION_MESSAGE, null, fileFormats, fileFormats[0]);

                if (result != null) {
                    switch (result) {
                        case ("Текстовый"):
                            createDocument = new TextCreateDocument();
                    }
                    if (createDocument != null) {
                        String name = JOptionPane.showInputDialog(
                                null,
                                "<html><h2>Введите название файла");
                        if (name != null) {
                            document = createDocument.CreateOpen(name);
                            try {
                                document.open(Redactor.this);
                            } catch (IOException ioException) {
                                document = null;
                                JOptionPane.showMessageDialog(null, "File doesn't exist");
                            }
                        }
                    }
                }
            }
        });
        saveItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(document!=null)
                try {
                    document.save(Redactor.this);
                } catch (IOException ioException) {
                    JOptionPane.showMessageDialog(null,"ERROR");
                }
            }
        });
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(document!=null)
                try {
                    document.exit(Redactor.this);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                document=null;
            }
        });


        add(jMenuBar,textFieldsConstraint);
        setVisible(true);
    }

    public static void main(String[] args){
        new Redactor();
    }
}
