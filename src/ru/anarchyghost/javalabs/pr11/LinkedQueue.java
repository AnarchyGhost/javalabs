package ru.anarchyghost.javalabs.pr11;

import java.util.LinkedList;

public class LinkedQueue extends AbstractQueue {
    private LinkedList<Object> elements=new LinkedList<>();
    @Override
    public void enqueue(Object object) {
        elements.addFirst(object);
    }

    @Override
    public Object element() {
        return elements.peekLast();
    }

    @Override
    public Object dequeue() {
        return elements.removeLast();
    }

}
