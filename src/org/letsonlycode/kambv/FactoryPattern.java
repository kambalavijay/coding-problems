package org.letsonlycode.kambv;

public class FactoryPattern {

    public static Car getInstace(Class carClass){
        if(carClass.equals(Tata.class)){
           return new Tata();
        }
        else if(carClass.equals(Mercedez.class)){
            return new Mercedez();
        }
        else if(carClass.equals(Toyota.class)){
            return new Toyota();
        }
        else{
            return null;
        }
    }
}

class Car{
    public void run(){
        System.out.println("car is running");
    }
}

class Tata extends Car{
    public void run(){
        System.out.println("Tata car is running");
    }
}
class Toyota  extends Car{
    public void run(){
        System.out.println("Toyota car is running");
    }
}

class Mercedez extends Car{
    public void run(){
        System.out.println("Mercedez car is running");
    }
}