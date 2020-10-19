package ru.anarchyghost.javalabs.pr11;

import java.util.Arrays;

public class ArrayQueueADT {
    private int size=0;
    private Object[] elements = new Object[1];

    private static void ensureCapacity(ArrayQueueADT arrayQueueADT,int capacity,int mod) {
        if (capacity > arrayQueueADT.elements.length&&mod==1) arrayQueueADT.elements = Arrays.copyOf(arrayQueueADT.elements, capacity);
        if(mod==2) arrayQueueADT.elements = Arrays.copyOf(arrayQueueADT.elements, capacity);
    }


    public static void enqueue(ArrayQueueADT arrayQueueADT,Object object) {
        ensureCapacity(arrayQueueADT,arrayQueueADT.size + 1,1);
        for(int i=arrayQueueADT.size;i>0;i--){
            arrayQueueADT.elements[i]=arrayQueueADT.elements[i-1];
        }
        arrayQueueADT.elements[0] = object;
        arrayQueueADT.size++;
    }

    public static Object element(ArrayQueueADT arrayQueueADT) {
        if(arrayQueueADT.size!=0)return arrayQueueADT.elements[arrayQueueADT.size-1];
        else return null;
    }

    public static Object dequeue(ArrayQueueADT arrayQueueADT) {
        if(arrayQueueADT.size==0)return null;
        Object obj=arrayQueueADT.elements[arrayQueueADT.size-1];
        ensureCapacity(arrayQueueADT,arrayQueueADT.size--,2);
        return obj;
    }

    public static int size(ArrayQueueADT arrayQueueADT) {
        return arrayQueueADT.size;
    }


    public static boolean isEmpty(ArrayQueueADT arrayQueueADT) {
        if(arrayQueueADT.size==0)return true;
        else return false;
    }


    public static void clear(ArrayQueueADT arrayQueueADT) {
        while (arrayQueueADT.size!=0) dequeue(arrayQueueADT);
    }

    public static String toString(ArrayQueueADT arrayQueueADT){
        String res="";
        for(int i=0;i<arrayQueueADT.size;i++)res+=arrayQueueADT.elements[i]+" ";
        return res;
    }
}
