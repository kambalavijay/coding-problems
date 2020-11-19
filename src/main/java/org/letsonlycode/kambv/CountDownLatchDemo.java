package org.letsonlycode.kambv;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch c = new CountDownLatch(3);
        ExecutorService exec = Executors.newFixedThreadPool(3);

        for(int i = 1; i <= 3; i++){
            exec.submit(new RunnableTask(c, i));
        }
        c.await();
        exec.shutdown();
        System.out.println("main");
    }
}


class RunnableTask implements Runnable{
    int i;
    CountDownLatch c;

    public RunnableTask(CountDownLatch c, int i){
        this.i = i;
        this.c = c;
    }

    @Override
    public void run() {
        System.out.println(i);
        c.countDown();
    }
}

class Service implements Runnable{
    private final String name;
    private final int timeToStart;
    private final CountDownLatch latch;

    public Service(String name, int timeToStart, CountDownLatch latch){
        this.name = name;
        this.timeToStart = timeToStart;
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(timeToStart);
        } catch (InterruptedException ex) {

        }
        System.out.println( name + " is Up");
        latch.countDown(); //reduce count of CountDownLatch by 1
    }
}