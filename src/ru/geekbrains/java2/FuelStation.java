package ru.geekbrains.java2;

import java.util.concurrent.Semaphore;

public class FuelStation {
    private Semaphore semaphore = new Semaphore(3);
    private GasPool gasPool = new GasPool();

    public void upFuel(Auto auto){
        try {
            semaphore.acquire();
            System.out.println("[upFuel] " + auto.getName() + " in FuelStation and fuel up");
            if(gasPool.info() <= 0){
                System.out.println("[upFuel] gas pool empty " + auto.getName() + " stop");
                auto.setPlsStop(true);
            }else {
                Thread.sleep(5000);
                auto.setFuel(gasPool.request(auto.getFuel()));
                System.out.println("[upFuel] " + auto.getName() + " in FuelStation - fuelTank " + auto.getFuelTank());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            semaphore.release();
        }
    }
}
