
package org.letsonlycode.kambv;

import java.util.Queue;

public class DriverClass {

    public static void main(String[] args) {

        int low = 5;
        int high = 15;
        System.out.println((low + high) << 1);

        /*Queue<Integer> queue = new ConcurrentLinkedQueue<>();

        int n = 10;

        Producer p = new Producer(queue, n);
        Consumer c = new Consumer(queue);

        p.start();
        c.start();*/
    }

}

class Producer extends Thread{
    Integer i;
    Queue<Integer> queue;
    int threshold;

    Producer(Queue<Integer> queue, int threshold){
        this.queue = queue;
        this.threshold = threshold;
        i = 0;
    }

    @Override
    public void run() {
        while (queue.size() < threshold-1) {
            System.out.println(queue.add(new Integer(i++)));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer extends Thread{

    Queue<Integer> queue;

    Consumer(Queue queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        while (!queue.isEmpty()) {
            System.out.println(queue.poll().intValue());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}