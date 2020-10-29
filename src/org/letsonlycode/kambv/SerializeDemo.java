package org.letsonlycode.kambv;

import java.io.*;

public class SerializeDemo {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        A a = new A();
        a.i = 10;
        B b = new B();
        b.i = 20;
        a.b = b;

        System.out.println("original  : " + a);

        FileOutputStream fos = new FileOutputStream("file.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(a);

        FileInputStream fis = new FileInputStream("file.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);

        System.out.println("recovered : " + ois.readObject().toString());

        String str = new String("vijay");
        Integer i = new Integer(10);
        Integer i1 = 10;
    }
}

class A implements Serializable{
    int i;
    transient B b;

    @Override
    public String toString() {
        return "A{" +
                "i=" + i +
                ", b=" + b +
                '}';
    }
}

class B /*implements Serializable*/ {
    int i;

    @Override
    public String toString() {
        return "B{" +
                "i=" + i +
                '}';
    }
}