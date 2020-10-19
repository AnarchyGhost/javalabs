package ru.anarchyghost.javalabs.pr9;

import java.util.ArrayList;

public class StudentBD {
    private ArrayList<Student> students=new ArrayList<>();
    private StudentDBDriver studentDBDriver=new StudentDBDriver();

    public String toString(){
        String string="";
        for(int i=0;i<students.size();i++)
        string+= students.get(i);
        return string;
    }

    public Student getStudent(String name,String id,String gpa) throws EmptyStringException{
        if(name.equals("")){throw new EmptyStringException("Name");
        }
        if(id.equals("")){
            throw new EmptyStringException("ID");
        }
        if(gpa.equals("")){
            throw new EmptyStringException("GPA");
        }
        if(Integer.valueOf(id)==null) {
            throw new NumberFormatException();
        }
        if(Double.isNaN(Double.parseDouble(gpa))||Double.parseDouble(gpa)<0||Double.parseDouble(gpa)>5) {
            throw new NumberFormatException();
        }

        return new Student(name,Integer.valueOf(id),Double.valueOf(gpa));
    }

    public void add(Student student){
        students.add(student);
    }

    public void sortStudents(){
        studentDBDriver.sort(students);
    }

    public Student find(String name) throws StudentNotFoundException {
        if(studentDBDriver.find(students, new Student(name,0,-1000))==null) throw new StudentNotFoundException(name);
        else return studentDBDriver.find(students, new Student(name,0,-1000));
    }
}
