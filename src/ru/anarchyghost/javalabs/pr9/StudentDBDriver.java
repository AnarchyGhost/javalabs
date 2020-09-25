package ru.anarchyghost.javalabs.pr9;

import java.util.ArrayList;

public class StudentDBDriver {
    public void sort(ArrayList<Student> list){
        int min;
        Student temp;
        for (int index = 0; index < list.size()-1; index++)
        {
            min = index;
            for (int scan = index+1; scan < list.size(); scan++)
                if (list.get(scan).compareTo(list.get(min)) < 0)
                    min = scan;
            temp = list.get(min);
            list.remove(min); list.add(min,list.get(index));
            list.remove(index); list.add(index, temp);
        }
    }

    public Student find(ArrayList<Student> list, Student target){
            int index = 0;
            boolean found = false;
            while (!found && index < list.size()) {
                if (list.get(index).compareTo(target)==0)
                    found = true;
                else
                    index++;
            }

            if (found)
                return list.get(index);
            else
                return null;
    }

}
