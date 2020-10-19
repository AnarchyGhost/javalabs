package ru.anarchyghost.javalabs.pr102;

public class MagicChair implements Chair {
    public void doMagic(){System.out.println("MAGIC");}

    @Override
    public void sit() {
        System.out.println("You sitting at Magic Chair");
    }
}
