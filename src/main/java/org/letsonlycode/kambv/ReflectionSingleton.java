package org.letsonlycode.kambv;

import java.lang.reflect.Constructor;

class SingletonDesignPattern {

    private static volatile SingletonDesignPattern singletonDesignPattern = null;

    private SingletonDesignPattern(){

    }

    public static SingletonDesignPattern getInstance(){
        if(singletonDesignPattern == null){
            synchronized (SingletonDesignPattern.class){
                singletonDesignPattern = new SingletonDesignPattern();
            }
        }
        return singletonDesignPattern;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new CloneNotSupportedException("op");
    }

}


public class ReflectionSingleton {
    public static void main(String[] args)  {
        SingletonDesignPattern objOne = SingletonDesignPattern.getInstance();
        SingletonDesignPattern objTwo = null;
        try {
            Constructor constructor = SingletonDesignPattern.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            objTwo = (SingletonDesignPattern) constructor.newInstance();

            Constructor constructor1 = SingletonDesignPattern.class.getDeclaredConstructor();

        } catch (Exception ex) {
            System.out.println(ex);
        }
        System.out.println("Hashcode of Object 1 - "+objOne.hashCode());
        System.out.println("Hashcode of Object 2 - "+objTwo.hashCode());
    }
}