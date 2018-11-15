package com.springtesting.consoleapplications;

abstract class AbstractClassCar
{
    private int fuel;

    public AbstractClassCar(int fuel)
    {
        this.fuel=fuel;
    }

    public AbstractClassCar()
    {
        this(1);
    }

    public int getFuel()
    {
        System.out.println("Inside AbstractClassCar getFuel() method");
        return fuel;
    }

    final public void printMessage()
    {
        System.out.println("Inside AbstractClassCar printMessage() method");
    }

    public abstract void run();
}
