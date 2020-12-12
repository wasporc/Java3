package ru.geekbrains.java2;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

public class MyTest {
    private static MyTest test = new MyTest();

    public static void start(Class<?> testClass) throws InvocationTargetException, IllegalAccessException, InstantiationException {
        int beforeCount = 0;
        Method[] testMethods = test.getClass().getDeclaredMethods();
        for (Method testMethod : testMethods) {
            if(beforeCount > 1) throw new RuntimeException("before должен быть 1");
            if (testMethod.isAnnotationPresent(BeforeSuite.class) ){
                testMethod.invoke(test);
                beforeCount++;
            }
        }
        Object o1 = testClass.newInstance();
        Method[] declaredMethods = o1.getClass().getDeclaredMethods();
        Arrays.sort(declaredMethods, Comparator.comparingInt(o -> o.getAnnotation(Test.class).value()));
        for (Method declaredMethod : declaredMethods) {
            declaredMethod.invoke(o1);
        }
        int afterCount = 0;
        for (Method testMethod : testMethods) {
            if(afterCount > 1) throw new RuntimeException("after должен быть 1");
            if(testMethod.isAnnotationPresent(AfterSuite.class) ){
                testMethod.invoke(test);
                afterCount++;
            }
        }

    }

    @BeforeSuite
    private void before(){
        System.out.println("Before");
    }

    @AfterSuite
    private void after(){
        System.out.println("after");
    }

}
