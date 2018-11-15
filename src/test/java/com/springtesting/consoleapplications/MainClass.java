package com.springtesting.consoleapplications;

public class MainClass
{
    public static void main(String[] args)
    {
        /*Car carObject=Car.getInstance();
        System.out.println("Car Make =>"+carObject.make);
        System.out.println("Car Model =>"+carObject.model);*/

        //LocalDateTime localDateTime=LocalDateTime.now(ZoneId.of("GMT-5"));
        //System.out.println(localDateTime.toString());

        ImplementorClass implementorClass=new ImplementorClass();
        implementorClass.run();
        implementorClass.getFuel();
        implementorClass.printMessage();

    }
}
