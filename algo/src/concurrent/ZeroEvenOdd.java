package concurrent;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * 输入：n = 5
 * 输出："0102030405"
 * 0奇0偶0奇0偶
 */
public class ZeroEvenOdd {
    private int n;

    Semaphore z = new Semaphore(1); // 0
    Semaphore e = new Semaphore(0); // 偶数
    Semaphore o = new Semaphore(0); // 奇数

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            z.acquire();
            printNumber.accept(0);
            if (i % 2 == 0)
                o.release();
            else
                e.release();

        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            e.acquire();
            printNumber.accept(i);
            z.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            o.acquire();
            printNumber.accept(i);
            z.release();
        }
    }

    public static void  main(String[] args) {

    }
}
