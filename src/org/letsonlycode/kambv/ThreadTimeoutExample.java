package org.letsonlycode.kambv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadTimeoutExample {

	Logger logger = LoggerFactory.getLogger(ThreadTimeoutExample.class);

	public static void main(String[] args) throws InterruptedException {
		CountDownLatch latch = new CountDownLatch(3);
		
		Runnable r;
		ExecutorService exec = Executors.newFixedThreadPool(3);

		System.out.println("Threads started to execute...");

		for(int i =1; i <=3; i++) {
			r = new ScheduledJob(latch, "thread" + i);
			exec.submit(r);
		}
		
		latch.await();
		System.out.println("All the threads are exempted");
	}
}


class ScheduledJob implements Runnable{

	Logger logger  = LoggerFactory.getLogger(ScheduledJob.class);

	private CountDownLatch c;
	private String i;
	public ScheduledJob(CountDownLatch c, String i) {
		this.c = c;
		this.i = i;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(1000);
			System.out.println(i);
			c.countDown();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage(), e.getStackTrace());
		}
	}
}