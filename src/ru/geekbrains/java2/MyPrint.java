package ru.geekbrains.java2;

public class MyPrint {
    private int mark = 0;

    public synchronized void print(String str, int index) {
        while (mark != index) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print(str);
        mark++;
        if (mark > 2) mark = 0;
        notifyAll();
    }
}
