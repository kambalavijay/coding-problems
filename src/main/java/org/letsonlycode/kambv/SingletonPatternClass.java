package org.letsonlycode.kambv;

public class SingletonPatternClass {

    private static SingletonPatternClass singletonPatternClass = null;

    public synchronized static SingletonPatternClass getInstnace(){
        if(singletonPatternClass == null){
            singletonPatternClass = new SingletonPatternClass();
            return singletonPatternClass;
        }
        return singletonPatternClass;
    }
}
