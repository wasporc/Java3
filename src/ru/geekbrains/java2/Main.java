package ru.geekbrains.java2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        FuelStation fuelStation = new FuelStation();

        ExecutorService executorService = Executors.newFixedThreadPool(6);
        executorService.submit(new Bus("Bus-1", fuelStation, 40f, 7.5f, 40f));
        executorService.submit(new Bus("Bus-2", fuelStation, 40f, 7.5f, 40f));

        executorService.submit(new Car("Car-1", fuelStation, 20f, 2.5f, 20f));
        executorService.submit(new Car("Car-2", fuelStation, 20f, 2.5f, 20f));

        executorService.submit(new Truck("Truck-1", fuelStation, 60f, 15f, 60f));
        executorService.submit(new Truck("Truck-2", fuelStation, 60f, 15f, 60f));

        executorService.shutdown();
    }
}
