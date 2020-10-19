package ru.anarchyghost.javalabs.lastlaba;

import java.util.Arrays;

public class RestrauntOrder implements Order {
    int size=0;
    MenuItem[] items=new MenuItem[0];
    Customer customer;

    private boolean checkName(String menuItems[], String item){
        for(int i=0;i<menuItems.length;i++){
            if(menuItems[i].equals(item))return true;
        }
        return false;
    }

    private boolean checkName(MenuItem menuItems[], MenuItem item){
        for(int i=0;i<menuItems.length;i++){
            if(menuItems[i].getName().equals(item))return true;
        }
        return false;
    }

    @Override
    public boolean add(MenuItem menuItem) {
        MenuItem[] newArray = Arrays.copyOf(items, items.length + 1);
        newArray[items.length] = menuItem;
        items = newArray;
        size++;
        return true;
    }

    @Override
    public String[] itemNames() {
        String[] itemNames=new String[0];
        for(int i=0;i<items.length;i++){
            if(!checkName(itemNames,items[i].getName())) {
                String[] newArray = Arrays.copyOf(itemNames, itemNames.length + 1);
                newArray[itemNames.length] = items[i].getName();
                itemNames = newArray;
            }
        }
        return itemNames;
    }

    @Override
    public int itemsQuantity() {
        return size;
    }

    @Override
    public int itemsQuantity(String itemName) {
        int count=0;
        for(int i=0;i<items.length;i++){
            if(items[i].getName().equals(itemName))count++;
        }
        return count;
    }

    @Override
    public int itemsQuantity(MenuItem itemName) {
        int count=0;
        for(int i=0;i<items.length;i++){
            if(items[i].getName().equals(itemName.getName()))count++;
        }
        return count;
    }

    @Override
    public MenuItem[] getItems() {
        MenuItem[] itemNames=new MenuItem[0];
        for(int i=0;i<items.length;i++){
            if(!checkName(itemNames,items[i])) {
                MenuItem[] newArray = Arrays.copyOf(itemNames, itemNames.length + 1);
                newArray[itemNames.length] = items[i];
                itemNames = newArray;
            }
        }
        return itemNames;
    }

    @Override
    public boolean remove(String itemName) {
        if(itemsQuantity(itemName)==0)return false;
        for(int i=0;i<items.length;i++){
            if(items[i].getName().equals(itemName)){
                for(int j=i;j<items.length-1;j++){
                    items[j]=items[j+1];
                }
                items=Arrays.copyOf(items, items.length -1);
                break;
            }
        }
        size--;
        return true;
    }

    @Override
    public boolean remove(MenuItem itemName) {
        if(itemsQuantity(itemName)==0)return false;
        for(int i=0;i<items.length;i++){
            if(items[i].getName().equals(itemName.getName())){
                for(int j=i;j<items.length-1;j++){
                    items[j]=items[j+1];
                }
                items=Arrays.copyOf(items, items.length -1);
                break;
            }
        }
        size--;
        return true;
    }

    @Override
    public int removeAll(String itemName) {
        int count=0;
        while (itemsQuantity(itemName)!=0) {
            for (int i = 0; i < items.length; i++) {
                if (items[i].getName().equals(itemName)) {
                    for (int j = i; j < items.length - 1; j++) {
                        items[j] = items[j + 1];
                    }
                    items = Arrays.copyOf(items, items.length - 1);
                    size--;
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    @Override
    public int removeAll(MenuItem itemName) {
        int count=0;
        while (itemsQuantity(itemName)!=0) {
            for (int i = 0; i < items.length; i++) {
                if (items[i].getName().equals(itemName.getName())) {
                    for (int j = i; j < items.length - 1; j++) {
                        items[j] = items[j + 1];
                    }
                    items = Arrays.copyOf(items, items.length - 1);
                    count++;
                    size--;
                    break;
                }
            }
        }
        return count;
    }

    @Override
    public MenuItem[] sortedItemsByCostDesc() {
        MenuItem[] menuItems=getItems();
        for(int i=0;i<menuItems.length;i++){
            for (int j=i;j<menuItems.length;j++){
                if(menuItems[i].getCost()<menuItems[j].getCost()) {
                    MenuItem tmp;
                    tmp=menuItems[i];
                    menuItems[i]=menuItems[j];
                    menuItems[j]=tmp;
                }
            }
        }
        return menuItems;
    }

    @Override
    public int costTotal() {
        MenuItem[] menuItems=getItems();
        int cost=0;
        for(int i=0;i<menuItems.length;i++){
            System.out.println(menuItems[i].getName());
            cost+=menuItems[i].getCost()*itemsQuantity(menuItems[i]);
            System.out.println(menuItems[i].getCost());
        }
        return cost;
    }


    @Override
    public Customer getCustomer() {
        return customer;
    }

    @Override
    public void setCustomer(Customer customer) {
        this.customer=customer;
    }
}
