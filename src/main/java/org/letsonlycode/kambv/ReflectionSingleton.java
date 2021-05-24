package org.letsonlycode.kambv;

import com.sun.org.apache.xerces.internal.util.SecurityManager;

import java.lang.reflect.Constructor;
import java.sql.SQLOutput;

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

        String a = new String("ABC");
        String b = new String("ABC");

        System.out.println(a == b);
        System.out.println(a.hashCode());




        SingletonDesignPattern objOne = SingletonDesignPattern.getInstance();
        SingletonDesignPattern objTwo = SingletonDesignPattern.getInstance();
        SingletonDesignPattern objThree = SingletonDesignPattern.getInstance();
        SingletonDesignPattern objFour = SingletonDesignPattern.getInstance();

        /*try {
            Constructor constructor = SingletonDesignPattern.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            objTwo = (SingletonDesignPattern) constructor.newInstance();

            Constructor constructor1 = SingletonDesignPattern.class.getDeclaredConstructor();

        } catch (Exception ex) {
            System.out.println(ex);
        }*/
        //System.out.println("Hashcode of Object 1 - "+objOne.hashCode());
        //System.out.println("Hashcode of Object 2 - "+objTwo.hashCode());
    }
}