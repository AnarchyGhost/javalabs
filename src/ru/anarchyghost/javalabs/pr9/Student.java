package ru.anarchyghost.javalabs.pr9;

public class Student implements Comparable<Student>{
    private String name;
    private int ID;
    private double GPA;

    public Student(String name, int id, double gpa) {
        this.name = name;
        ID = id;
        GPA = gpa;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    @Override
    public String toString(){
        return "ID: "+this.getID()+" Name: "+this.getName()+" GPA: "+this.getGPA()+"\n";
    }

    @Override
    public int compareTo(Student o) {
        if(this.getName().equals(o.getName()))return 0;
        return (int)((this.getGPA()-o.getGPA())*1000);
    }
}
