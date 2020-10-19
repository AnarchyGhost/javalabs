package ru.anarchyghost.javalabs.lastlaba;

import java.util.Arrays;

public class TableOrdersManager implements OrdersManager {
    Order[] orders=new Order[20];

    TableOrdersManager(){
        for (int i=0;i<orders.length;i++) {
            orders[i]=null;
        }
    }

    public boolean addOrder(Order order,int table){
        if(orders[table]!=null)return false;
        orders[table]=order;
        return true;
    }

    public boolean addItem(MenuItem item, int tableNumber){
        if(orders[tableNumber]==null)return false;
        return orders[tableNumber].add(item);
    }

    public int freeTableNumber(){
        for (int i=0;i<orders.length;i++){
            if(orders[i]==null)return i;
        }
        return -1;
    }

    public int[] freeTableNumbers(){
        int[] freeNumbers=new int[0];
        for(int i=0;i<orders.length;i++){
            if (orders[i] == null) {
                freeNumbers = Arrays.copyOf(freeNumbers, freeNumbers.length + 1);
                freeNumbers[freeNumbers.length - 1] = i;
            }
        }
        return freeNumbers;
    }

    public Order getOrder(int table){
        return orders[table];
    }

    public void remove(int tableNumber){
        orders[tableNumber]=null;
    }

    public void remove(Order order){
        for(int i=0;i<orders.length;i++){
            if(orders[i].equals(order))orders[i]=null;
            break;
           }
    }

    public void removeAll(Order order){
        for(int i=0;i<orders.length;i++){
            if(orders[i].equals(order))orders[i]=null;
        }
    }

    @Override
    public int itemsQuantity(String itemName) {
        int cost=0;
        for(int i=0;i<orders.length;i++){
            if(orders[i]!=null)cost+=orders[i].itemsQuantity(itemName);
        }
        return cost;
    }

    @Override
    public int itemsQuantity(MenuItem itemName) {
        int cost=0;
        for(int i=0;i<orders.length;i++){
            if(orders[i]!=null)cost+=orders[i].itemsQuantity(itemName);
        }
        return cost;
    }

    @Override
    public Order[] getOrders() {
        return orders;
    }

    @Override
    public int ordersCostSummary() {
        int cost=0;
        for(int i=0;i<orders.length;i++){
            if(orders[i]!=null)cost+=orders[i].costTotal();
        }
        return cost;
    }

    @Override
    public int ordersQuantity() {
        int quantity=0;
        for(int i=0;i<orders.length;i++){
            if(orders[i]!=null)quantity++;
        }
        return quantity;
    }
}
