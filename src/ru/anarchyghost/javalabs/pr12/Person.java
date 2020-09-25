package ru.anarchyghost.javalabs.pr12;

public class Person {
    String name;
    String secondName;
    String surname;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Person(String name, String secondName, String surname) {
        this.name = name;
        this.secondName = secondName;
        this.surname = surname;
    }

    public Person(String surname) {
        this.surname = surname;

    }

    public String fio(){
        String string=new String("%s");
        if(name!=null&&!name.isEmpty())string+=" %.1s.";
        if(secondName!=null&&!secondName.isEmpty())string+=" %.1s.";
        return String.format(string,surname,name,secondName);
    }
}
