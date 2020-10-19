package ru.anarchyghost.javalabs.pr12;

import java.util.ArrayList;

public class Last {
    private ArrayList<String> list=new ArrayList<>();
    private ArrayList<String> newList;
    public Last(String string){
        int i=0;
        for (String retval : string.split("\\s")) {
            list.add(retval);
        }
        newList=function();
    }

    public ArrayList<String> function(){
        ArrayList<String> left;
        ArrayList<String> current;
        ArrayList<String> res;
        for(int i=0;i<list.size();i++) {
            current=new ArrayList<>();
            current.add(list.get(i));
            left=new ArrayList<>(list);
            left.remove(i);
            res=functionp2(left,current);
            if(res!=null&&check(res)) return res;
        }
        return null;
    }

    public boolean check(ArrayList<String> arrayList){
        for(int i=0;i<arrayList.size()-1;i++){
            if(Character.toLowerCase(arrayList.get(i).charAt(arrayList.get(i).length()-1))!= Character.toLowerCase(arrayList.get(i+1).charAt(0)))return false;

        }
        return true;
    }

    public ArrayList<String> functionp2(ArrayList<String> left,ArrayList<String> current){
        if(left.size()==0&&check(current))return current;
        ArrayList<String> left1;
        ArrayList<String> current1;
        ArrayList<String> res;
        for(int i=0;i<left.size();i++){
            current1=new ArrayList<>(current);
            current1.add(left.get(i));
            left1=new ArrayList<>(left);
            left1.remove(i);
            res=functionp2(left1,current1);
            if(res!=null&&check(res)) return res;
        }
        return null;
    }

    public String toString(){
        StringBuilder stringBuilder=new StringBuilder("");
        for(int i=0;i<newList.size();i++) stringBuilder.append(newList.get(i)+" ");
        return String.valueOf(stringBuilder);
    }
}
