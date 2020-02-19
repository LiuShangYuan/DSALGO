package concurrent;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * 1195. 交替打印字符串
 * <p>
 * <p>
 * 请你实现一个有四个线程的多线程版  FizzBuzz， 同一个 FizzBuzz 实例会被如下四个线程使用：
 * <p>
 * 线程A将调用 fizz() 来判断是否能被 3 整除，如果可以，则输出 fizz。
 * 线程B将调用 buzz() 来判断是否能被 5 整除，如果可以，则输出 buzz。
 * 线程C将调用 fizzbuzz() 来判断是否同时能被 3 和 5 整除，如果可以，则输出 fizzbuzz。
 * 线程D将调用 number() 来实现输出既不能被 3 整除也不能被 5 整除的数字。
 */
public class FizzBuzz {
    private volatile int n;
    // 每次只有一个线程能获取到，获取到之后如果条件满足则输出，否则不操作，最后释放
    private volatile int number = 1;

    private Semaphore semaphore = new Semaphore(1);

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while (true) {
            try{
                semaphore.acquire();
                if (number > n){
                    return;
                }
                // code
                if (number % 3 == 0 && number % 5 != 0) {
                    printFizz.run();
                    number++;
                }

            }finally {
                semaphore.release();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        // 获取到锁之后才能对数量进行判断
        // 如果循环条件写在while上可能存在number进去是满足条件, 但是拿不到锁不能操作
        // 别的线程对数据进行操作之后number已经变了可能不满足情况了，这是线程获得锁但是操作的number已经超出范围了
        while (true) {

            try{
                semaphore.acquire();
                if (number > n){
                    return;
                }
                // code
                if (number % 3 != 0 && number % 5 == 0) {
                    printBuzz.run();
                    number++;
                }

            }finally {
                semaphore.release();
            }

        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (true) {

            try{
                semaphore.acquire();
                if (number > n){
                    return;
                }
                // code
                if (number % 3 == 0 && number % 5 == 0) {
                    printFizzBuzz.run();
                    number++;
                }

            }finally {
                semaphore.release();
            }

        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while (true) {

            try{
                semaphore.acquire();
                if (number > n){
                    return;
                }
                // code
                if (number % 3 != 0 && number % 5 != 0) {
                    printNumber.accept(number);
                    number++;
                }

            }finally {
                semaphore.release();
            }
        }
    }
}
