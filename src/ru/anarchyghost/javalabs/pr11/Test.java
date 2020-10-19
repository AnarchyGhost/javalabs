package ru.anarchyghost.javalabs.pr11;

public class Test {

    public static void main(String[] args){
        ArrayQueue arrayQueue=new ArrayQueue();
        System.out.println("Тестируем ArrayQueue: ");
        System.out.println("Добавим элементы от 0 до 10");
        for (int i=0;i<=10;i++) arrayQueue.enqueue(i);
        System.out.println("Очередь: "+arrayQueue);
        System.out.println("Выведем их при помощи метода dequeue:");
        for (int i=0;i<=10;i++)System.out.println(arrayQueue.dequeue());
        System.out.println("Очередь: "+arrayQueue);
        ArrayQueueADT arrayQueueADT=new ArrayQueueADT();
        System.out.println("Тестируем ArrayQueueADT: ");
        System.out.println("Добавим элементы от 0 до 10");
        for (int i=0;i<=10;i++) ArrayQueueADT.enqueue(arrayQueueADT,i);
        System.out.println("Очередь: "+ArrayQueueADT.toString(arrayQueueADT));
        System.out.println("Выведем их при помощи метода dequeue:");
        for (int i=0;i<=10;i++)System.out.println(ArrayQueueADT.dequeue(arrayQueueADT));
        System.out.println("Очередь: "+ArrayQueueADT.toString(arrayQueueADT));
        LinkedQueue linkedQueue=new LinkedQueue();
        System.out.println("Тестируем LinkedQueue: ");
        System.out.println("Добавим элементы от 0 до 10");
        for (int i=0;i<=10;i++) linkedQueue.enqueue(i);
        System.out.println("Получим один элемент без удаления: "+linkedQueue.element());
        System.out.println("Выведем элементы при помощи метода dequeue:");
        for (int i=0;i<=10;i++)System.out.println(linkedQueue.dequeue());
    }
}
