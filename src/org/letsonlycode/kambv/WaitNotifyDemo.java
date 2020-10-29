
package org.letsonlycode.kambv;

import java.util.concurrent.atomic.AtomicInteger;

public class WaitNotifyDemo {

    public static void main(String[] args) throws InterruptedException {

        AtomicInteger count = new AtomicInteger(0);

        EvenPrinter e = new EvenPrinter(count);
        OddPrinter o = new OddPrinter(count);

        Thread t1 = new Thread(e, "EvenThread");
        Thread t2 = new Thread(o, "Oddthread");

        t1.start();
        t2.start();
    }
}

class EvenPrinter implements Runnable {

    AtomicInteger count;
    EvenPrinter(AtomicInteger c) {
        this.count = c;
    }

    @Override
    public void run() {
        synchronized(count) {
            while(true) {
                System.out.println(Thread.currentThread().getName() + " -> " +count.getAndIncrement());
                count.notify();
                try {
                    if (count.get() >= 100)
                        break;
                    else
                        count.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}

class OddPrinter implements Runnable {

    AtomicInteger count;
    OddPrinter(AtomicInteger c) {
        this.count = c;
    }

    @Override
    public void run() {
        synchronized(count) {
            while(true) {
                System.out.println(Thread.currentThread().getName() + "  -> " + count.getAndIncrement());
                count.notify();
                try {
                    if (count.get() >= 100)
                        break;
                    else
                        count.wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block e.printStackTrace();
                }
            }
        }
    }
}

