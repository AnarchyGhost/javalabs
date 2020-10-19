package ru.anarchyghost.javalabs.testlist;

public class Test {

  public static void main(String args[]){
      ListProj listProj=new ListProj();
      listProj.add(4);
      listProj.add(2);
      listProj.add(4);
      listProj.add(3);
      listProj.add(4);
      listProj.add(4);
      System.out.println("Count "+listProj.itemsQuantity(4));
      String[] string=listProj.itemNames();
      for(int i=0;i<string.length;i++)System.out.println(string[i]);
      System.out.println("Remove 4");
      listProj.remove(4);
      string=listProj.itemNames();
      for(int i=0;i<string.length;i++)System.out.println(string[i]);
      System.out.println("Remove 4");
      listProj.remove(4);
      string=listProj.itemNames();
      for(int i=0;i<string.length;i++)System.out.println(string[i]);
      System.out.println("Remove 4");
      listProj.remove(4);
      string=listProj.itemNames();
      for(int i=0;i<string.length;i++)System.out.println(string[i]);
      System.out.println("Remove 4");
      listProj.remove(4);
      string=listProj.itemNames();
      for(int i=0;i<string.length;i++)System.out.println(string[i]);
      System.out.println("Remove 3");
      listProj.remove(3);
      string=listProj.itemNames();
      for(int i=0;i<string.length;i++)System.out.println(string[i]);
      System.out.println("Remove 2");
      listProj.remove(2);
      string=listProj.itemNames();
      for(int i=0;i<string.length;i++)System.out.println(string[i]);
  }
}
