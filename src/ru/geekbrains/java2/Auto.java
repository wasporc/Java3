package ru.geekbrains.java2;

public abstract class Auto implements Runnable{
    protected String name;
    protected FuelStation fuelStation;
    protected float fuelTank ;
    protected final  float rate ;
    protected final  float capacity;
    protected boolean plsStop = false;

    public Auto(String name, FuelStation fuelStation, float fuelTank, float rate, float capacity) {
        this.name = name;
        this.fuelStation = fuelStation;
        this.fuelTank = fuelTank;
        this.rate = rate;
        this.capacity = capacity;
    }

    public boolean isPlsStop() {
        return plsStop;
    }

    public void setPlsStop(boolean plsStop) {
        this.plsStop = plsStop;
    }

    public String getName() {
        return name;
    }

    public float getFuelTank() {
        return fuelTank;
    }

    private void drive(){
        while (!plsStop){
            try {
                System.out.println("[drive] " + name + " drive and fuel down " + fuelTank);
                Thread.sleep(3000);
                fuelTank = fuelTank - rate;
                if (fuelTank <=0){
                    fuelStation.upFuel(this);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        drive();
    }

    public void setFuel(float amount) {
        fuelTank += amount;
    }

    public float getFuel() {
        return capacity - fuelTank;
    }
}
