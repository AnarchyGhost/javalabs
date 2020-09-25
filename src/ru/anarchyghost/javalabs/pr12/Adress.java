package ru.anarchyghost.javalabs.pr12;

import java.util.ArrayList;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Adress {
        String country;
        String region;
        String city;
        String street;
        String building;
        String korpus;
        String flat;

        public Adress(String adress){
            this.setAdress(adress);
        }

        public void setAdress(String adress) {
            Pattern pattern =
                    Pattern.compile("\\w+", Pattern.UNICODE_CHARACTER_CLASS
                            | Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(adress);
            ArrayList<String> words=new ArrayList<>();

            while (matcher.find())
                words.add(matcher.group().toLowerCase());
            if(words.size()<6){
                System.out.println("Неверный адрес");
                return;
            }
            country= words.get(0);
            region= words.get(1);
            city= words.get(2);
            street= words.get(3);
            building= words.get(4);
            korpus= words.get(5);
            flat= words.get(6);
        }

        public String toString(){
            return "Страна: "+country+"\nРегион: "+region+"\nГород: "+city+"\nУлица: "+street+"\nДом: "+building+"\nКорпус: "+korpus+"\nКвартира: "+flat;
        }
}
