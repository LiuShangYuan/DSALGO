package others;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * User: yinkai
 * Date: 2019-12-23
 * Time: 19:28
 */


// 创建两个线程, 其中一个输出1-52, 另一个输出A-Z. 输出格式要求：12A 34B 56C 78D

public class TwoThreadPrint {

    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock();
        final Condition c1 = lock.newCondition();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 52; ) {
                    /**
                    synchronized (TwoThreadPrint.class) {
                        System.out.print(i);
                        System.out.print(i + 1);
                        i += 2;

                        TwoThreadPrint.class.notify();
                        try {
                            TwoThreadPrint.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }*/

                    lock.lock();

                    System.out.print(i);
                    System.out.print(i + 1);
                    i += 2;

                    c1.signal();
                    if(i!=53) {
                        try {
                            c1.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    lock.unlock();
                }
            }
        });


        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (Character c = 'A'; c <= 'Z'; c++) {
                    /**
                    synchronized (TwoThreadPrint.class) {
                        System.out.print(c);
                        System.out.print(" ");

                        TwoThreadPrint.class.notify();
                        try {
                            TwoThreadPrint.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }*/

                    lock.lock();
                    System.out.print(c);
                    System.out.print(" ");

                    if(c!='Z') {
                        c1.signal();
                        try {
                            c1.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    lock.unlock();

                }
            }
        });

        thread1.start();
        thread2.start();

    }
}
