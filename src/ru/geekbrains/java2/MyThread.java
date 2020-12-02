package ru.geekbrains.java2;

public class MyThread implements Runnable {
    private MyPrint myPrint;
    private String body;
    private int mark;

    public MyThread(MyPrint myPrint, String body, int mark) {
        this.myPrint = myPrint;
        this.body = body;
        this.mark = mark;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            myPrint.print(body, mark);
        }
    }
}
