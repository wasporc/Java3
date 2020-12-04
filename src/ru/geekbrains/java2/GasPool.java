package ru.geekbrains.java2;

public class GasPool {
    private float fuelTank = 200f;

    public float request(float amount){
        fuelTank = fuelTank - amount;
        return amount;
    }

    public float info(){
        System.out.println("[GasPool]fuelTank " + fuelTank);
        return fuelTank;
    }
}
