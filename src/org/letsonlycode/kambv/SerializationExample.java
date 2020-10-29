package org.letsonlycode.kambv;

import java.io.*;

public class SerializationExample {
    public static void main(String args[]){

      //serialize();
      deserialize();

    }

    private static void serialize(){
        try{
            //Creating the object
            Student s1 = new Student(100,"ravi", 25);
            //Creating stream and writing the object
            FileOutputStream fout=new FileOutputStream("f.txt");
            ObjectOutputStream out=new ObjectOutputStream(fout);
            out.writeObject(s1);
            out.flush();
            //closing the stream
            out.close();
            System.out.println("success");
        }catch(Exception e){
            System.out.println(e);
        }
    }
    private static void deserialize(){
        try{
            //Creating stream to read the object
            ObjectInputStream in=new ObjectInputStream(new FileInputStream("f.txt"));
            Student s=(Student)in.readObject();
            //printing the data of the serialized object
            System.out.println(s);
            //closing the stream
            in.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}