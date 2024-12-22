package priv.zzy.demo;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolDemo {
    private static final AtomicInteger threadNumber = new AtomicInteger(0);

    static class MyThread extends Thread {
        private final Runnable task;

        public MyThread(Runnable task) {
            this.task = task;
        }

        @Override
        public void run() {
            try {
                task.run();
            } catch (Exception e) {
                System.out.println("thread task error");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor executor;
        executor = new ThreadPoolExecutor(3, 5, 2, TimeUnit.SECONDS, new LinkedBlockingQueue<>(3), r -> {
            MyThread myThread = new MyThread(r);
            myThread.setName("MyThread-" + threadNumber.getAndIncrement());
            return myThread;
        }, new ThreadPoolExecutor.AbortPolicy());
        try {

            for (int i = 0; i < 10; i++) {
                int finalI = i;
                executor.execute(() -> {
                    try {
                        System.out.println("[" + Thread.currentThread().getName() + "] running task " + finalI + " ...");
                        Thread.sleep(1000L);
                        System.out.println("[" + Thread.currentThread().getName() + "] finished task " + finalI + " ...");
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                });
                System.out.println("task submitted: " + i);
                Thread.sleep(100L);
            }
        } finally {
            //终止线程池
            executor.shutdown();
            while (!executor.isTerminated()) {
            }
            System.out.println("Finished all threads");

        }
    }
}
