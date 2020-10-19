package ru.anarchyghost.javalabs.pr11;

public abstract class AbstractQueue implements Queue{
    int size=0;
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if(size==0)return true;
        else return false;
    }

    @Override
    public void clear() {
        while (size!=0) dequeue();
    }
}
