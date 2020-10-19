package ru.anarchyghost.javalabs.pr11;

import java.util.Arrays;

public class ArrayQueue extends AbstractQueue{
    private int size=0;
    private Object[] elements = new Object[1];

    private void ensureCapacity(int capacity,int mod) {
        if (capacity > elements.length&&mod==1) elements = Arrays.copyOf(elements, capacity);
        if(mod==2) elements = Arrays.copyOf(elements, capacity);
    }


    @Override
    public void enqueue(Object object) {
        ensureCapacity(size + 1,1);
        for(int i=size;i>0;i--){
            elements[i]=elements[i-1];
        }
        elements[0] = object;
        size++;
    }

    @Override
    public Object element() {
        if(size!=0)return elements[size-1];
        else return null;
    }

    @Override
    public Object dequeue() {
        if(size==0)return null;
        Object obj=elements[size-1];
        ensureCapacity(size--,2);
        return obj;
    }

    public String toString(){
        String res="";
        for(int i=0;i<size;i++)res+=elements[i]+" ";
        return res+"Size: "+size;
    }

}
