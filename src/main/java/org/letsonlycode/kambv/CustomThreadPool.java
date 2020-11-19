package org.letsonlycode.kambv;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class CustomThreadPool {

    int no_of_Threads;

    CustomThread[] threads = null;

    private int pointer = 0;
    // 9 jobs
    Queue<Runnable> jobs = new ArrayBlockingQueue<Runnable>(10);

    public CustomThreadPool(){
        no_of_Threads = 3;
        threads = new CustomThread[no_of_Threads];
    }

    public CustomThreadPool(int no_of_Threads){
        this.no_of_Threads = no_of_Threads;
        threads = new CustomThread[no_of_Threads];
    }

    // submit all jobs

    public boolean addJob(Runnable runnable){
        return jobs.offer(runnable);
    }

    public void execute(){
        int i = 0;
        while(i < no_of_Threads){
            threads[i] = new CustomThread(jobs);
            threads[i++].run();
        }
    }
}

class CustomThread extends Thread{
    Queue<Runnable> jobs = null;
    boolean continueToWork = true;

    public CustomThread(Queue<Runnable> jobs){
        this.jobs = jobs;
    }

    @Override
    public void run() {
        while(continueToWork) {
            while(jobs.size() > 0) {
                Runnable work = jobs.poll();
                work.run();
            }
        }
    }

    public boolean stopWorking(){
        continueToWork = false;
        return !continueToWork;
    }
}


// 0, 1, 2, 3, 4 , 5, 6, 7, 8 -> 9
