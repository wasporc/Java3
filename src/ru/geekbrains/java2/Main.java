package ru.geekbrains.java2;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
   // public static int j = 0;

    public static void main(String[] args) {
        MyPrint myPrint = new MyPrint();
        MyThread tA = new MyThread(myPrint, "A", 0);
        MyThread tB = new MyThread(myPrint, "B", 1);
        MyThread tC = new MyThread(myPrint, "C", 2);

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(tA);
        executorService.submit(tB);
        executorService.submit(tC);
        executorService.shutdown();


//	    Thread tA = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int k = 0; k < 5; k++) {
//                    while (j!=0){
//                        try {
//                            wait();
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                    System.out.println("A");
//                    //i.set(1);
//                    j = 1;
//                    notifyAll();
//                }
//            }
//        });
//        Thread tB = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int k = 0; k < 5; k++){
//                    while (j!=1){
//                        try {
//                            wait();
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                    System.out.println("B");
//                    j=2;
//                    notifyAll();
//                }
//            }
//        });
//        Thread tC = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int k = 0; k < 5; k++){
//                    while (j!=2){
//                        try {
//                            wait();
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                    System.out.println("C");
//                    j=0;
//                    notifyAll();
//                }
//            }
//        });
//
//        tA.start();
//        tB.start();
//        tC.start();

    }
}
