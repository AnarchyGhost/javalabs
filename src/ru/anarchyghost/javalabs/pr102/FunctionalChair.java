package ru.anarchyghost.javalabs.pr102;

public class FunctionalChair implements Chair{
    int sum(int a,int b){return a+b;}

    @Override
    public void sit() {
        System.out.println("You sitting at FunctionalChair");
    }
}
