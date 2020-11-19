package org.letsonlycode.kambv;


import java.util.*;

public class MyDriver{

    public static void main(String[] args) {



    }
}
interface I1 {
    void m1();
}

interface I2 {
    void m1();
}

interface I3 {
    void m1();
}


interface BigOne extends I1, I2, I3 {
    void m4();
}

class C1{
   void m1(){
       System.out.println("m1");
    }
}

class C2{
    void m1(){
        System.out.println("m1");
    }
}
class C3 implements BigOne{

    @Override
    public void m1() {

    }

    @Override
    public void m4() {

    }
}

