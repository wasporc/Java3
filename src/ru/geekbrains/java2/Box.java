package ru.geekbrains.java2;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    private ArrayList<T> fruits = new ArrayList<T>();

    public void addFruit(T fruit){
        fruits.add(fruit);
    }

    public void addAllFruit(ArrayList<T> arr){
        fruits.addAll(arr);
    }


    public ArrayList<T> getFruits() {
        ArrayList<T> temp = new ArrayList<T>(fruits);
        fruits.clear();
        return temp;
    }

    public double getWeight(){
        double weight = 0;
        for (T fruit : fruits) {
            weight += fruit.getWeight();
        }
        return weight;
    }

    public boolean compare(Box box){
        if (this.getWeight() == box.getWeight()) return true;
        return false;
    }
}
