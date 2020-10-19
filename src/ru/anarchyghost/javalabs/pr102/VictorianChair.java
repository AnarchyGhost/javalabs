package ru.anarchyghost.javalabs.pr102;

public class VictorianChair implements Chair {
    private int age;
    public VictorianChair(int age){this.age=age;}
    public VictorianChair(){this.age=0;}
    public int getAge(){return this.age;}

    @Override
    public void sit() {
        System.out.println("You sitting at VictorianChair");
    }
}
