package ru.geekbrains.java2;

public class TestMe {
    @Test(value = 1)
    public void testMethod1(){
        System.out.println("Hi, im test method 1");
    }

    @Test(value = 3)
    public void testMethod3(){
        System.out.println("Hi, im test method 3");
    }

    @Test(value = 3)
    public void testMethod33(){
        System.out.println("Hi, im to test method 3");
    }

    @Test(value = 2)
    public void testMethod2(){
        System.out.println("Hi, im test method 2");
    }

    @Test(value = 4)
    public void testMethod4(){
        System.out.println("Hi, im test method 4");
    }
}
