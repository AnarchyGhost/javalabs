package ru.anarchyghost.javalabs.pr12;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Shirt {
    String  art;
    String type;
    String color;
    String size;

    public Shirt(String s){
        ArrayList<String> arrayList=new ArrayList<>();
        for (String retval : s.split(",")) {
            arrayList.add(retval);
        }
        art=arrayList.get(0);
        type=arrayList.get(1);
        color=arrayList.get(2);
        size=arrayList.get(3);
    }

    public String toString(){
        return "Артикул: "+art+" Наименование: "+type+" Цвет: "+color+" Размер: "+size;
    }
}
