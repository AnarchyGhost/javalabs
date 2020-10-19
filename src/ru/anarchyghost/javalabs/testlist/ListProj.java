package ru.anarchyghost.javalabs.testlist;

import ru.anarchyghost.javalabs.lastlaba.MenuItem;

import java.util.Arrays;

public class ListProj {
    private int size;
    private ListNode head;
    private ListNode tail;

    ListProj(){
        size=0;
        this.head=new ListNode(null,null,null);
        this.tail=new ListNode(null,null,null);
        this.head.setNext(this.tail);
        this.head.setPrev(this.tail);
        this.tail.setNext(head);
        this.tail.setPrev(head);
    }

    private boolean checkName(String menuItems[], String item){
        for(int i=0;i<menuItems.length;i++){
            if(menuItems[i].equals(item))return true;
        }
        return false;
    }

    public boolean add(Integer menuItem) {
        if(head.getValue()==null) {
            head.setValue(menuItem);
            size++;
            return true;
        }
        if(tail.getValue()==null) {
            tail.setValue(menuItem);
            size++;
            return true;
        }
        ListNode cur=tail;
        while (cur.getNext()!=head){
            cur=cur.getNext();
        }
        cur.setNext(new ListNode(head,cur,menuItem));
        head.setPrev(cur.getNext());
        size++;
        return true;
    }

    public String[] itemNames() {
        String[] itemNames=new String[1];
        if(head.getValue()==null) {
            return new String[0];
        }
        itemNames[0]=head.getValue().toString();

        if(tail.getValue()==null){
            return itemNames;
        }
        ListNode cur=head.getNext();
        while (cur!=head){
            if(!checkName(itemNames,cur.getValue().toString())) {
                String[] newArray = Arrays.copyOf(itemNames, itemNames.length + 1);
                newArray[itemNames.length] = cur.getValue().toString();
                itemNames = newArray;
            }
            cur=cur.getNext();
        }
        return itemNames;
    }

    public int itemsQuantity() {
       return size;
    }

    public int itemsQuantity(int itemName) {
        int quantity=0;
        ListNode cur=head;
        if(cur.getValue()==itemName)quantity++;
        if(cur.getNext().getValue()!=null)cur=cur.getNext();
        else return quantity;
        if(head.getValue()==null)return 0;
        while(cur!=head){
            if(cur.getValue()==itemName)quantity++;
            cur=cur.getNext();
        }
        return quantity;
    }

    public int itemsQuantity(Integer itemName) {
        return 0;
    }

    public Integer[] getItems() {
        return new Integer[0];
    }

    public boolean remove(int itemName) {
        if(itemsQuantity(itemName)==0)return false;
        ListNode cur=head;
        while(cur.getValue()!=itemName) cur=cur.getNext();
        if(size>2) {
            cur.prev.setNext(cur.getNext());
            cur.next.setPrev(cur.getPrev());
            if (cur == head)
                head = head.getNext();
            tail = head.getNext();
        }
        if (size==2){
            head=cur.getNext();
            tail=new ListNode(head,head,null);
            head.setNext(tail);
            head.setPrev(tail);
        }
        if(size==1){
            size=0;
            this.head=new ListNode(null,null,null);
            this.tail=new ListNode(null,null,null);
            this.head.setNext(this.tail);
            this.head.setPrev(this.tail);
            this.tail.setNext(head);
            this.tail.setPrev(head);
        }
        size--;
        return true;
    }

    public boolean remove(Integer itemName) {
        return false;
    }

    public int removeAll(String itemName) {
        return 0;
    }

    public int removeAll(Integer itemName) {
        return 0;
    }

    public Integer[] sortedItemsByCostDesc() {
        return new Integer[0];
    }

    public int costTotal() {
        return 0;
    }
}
