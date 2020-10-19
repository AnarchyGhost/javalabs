package ru.anarchyghost.javalabs.pr102;

public class Client {
    Chair chair;

    public void setChair(Chair chair){
        this.chair=chair;
    }

    public void sit(){
        chair.sit();
    }
}
