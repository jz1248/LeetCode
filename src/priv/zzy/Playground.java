package priv.zzy;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Playground {

    private static void testLock() {
        Lock lock = new ReentrantLock();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        try {
            lock.lock();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {

    }
}
