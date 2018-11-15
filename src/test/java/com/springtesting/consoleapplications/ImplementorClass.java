package com.springtesting.consoleapplications;

public class ImplementorClass extends AbstractClassCar
{
    @Override
    public void run()
    {
        System.out.println("Inside ImplementorClass");
    }

    @Override
    public int getFuel()
    {
        System.out.println("Inside  ImplementorClass getFuel() method");
        return super.getFuel();
    }

}
