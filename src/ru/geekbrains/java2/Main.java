package ru.geekbrains.java2;

import java.lang.reflect.InvocationTargetException;


public class Main {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, InstantiationException {
        int[] i = new int[1];
        System.out.println(i.getClass());
        char c;
        
        TestMe testMe = new TestMe();
        MyTest.start(testMe.getClass());
    }
}
