package ru.anarchyghost.javalabs.pr11;

public interface Queue {
    void enqueue(Object object);
    Object element();
    Object dequeue();
    int size();
    boolean isEmpty();
    void clear();
}
