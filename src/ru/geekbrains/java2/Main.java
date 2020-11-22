package ru.geekbrains.java2;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	    String[] arr = new String[]{"one", "two", "tree"};
	    arrayChangePlaceItem(arr);

        System.out.println(toArrayList(arr).getClass());
        System.out.println(toArrayList(arr));


	    Box<Apple> appleBox = new Box<Apple>();
	    Box<Orange> orangeBox = new Box<Orange>();
	    appleBox.addFruit(new Apple());
	    appleBox.addFruit(new Apple());
	    appleBox.addFruit(new Apple());

	    orangeBox.addFruit(new Orange());
	    orangeBox.addFruit(new Orange());
	    orangeBox.addFruit(new Orange());
	    orangeBox.addFruit(new Orange());

        System.out.println("apple box weight " + appleBox.getWeight());
        System.out.println("orange box weight " + orangeBox.getWeight());

        System.out.println("compare box " + appleBox.compare(orangeBox));

        Box<Apple> appleBox1 = new Box<Apple>();

        appleBox1.addAllFruit(appleBox.getFruits());
        System.out.println("applebox1 weight " + appleBox1.getWeight());
        System.out.println("apple box weight " + appleBox.getWeight());

    }

    private static <T> void arrayChangePlaceItem(T[] arr){
        System.out.println("before : " + Arrays.toString(arr));
        if (arr.length == 0) return;
        T temp = arr[0];
        arr[0] = arr[1];
        arr[1] = temp;
        System.out.println("after : " + Arrays.toString(arr));
    }

    private static <T> ArrayList toArrayList(T[] arr){
        return new ArrayList<T>(Arrays.asList(arr));
    }
}
