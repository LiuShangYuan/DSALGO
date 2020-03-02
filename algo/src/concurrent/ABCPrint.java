package concurrent;
import java.util.concurrent.Semaphore;

public class ABCPrint {
    static Semaphore a = new Semaphore(1);
    static Semaphore b = new Semaphore(0);
    static Semaphore c = new Semaphore(0);

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        a.acquire();
                        System.out.println("A");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        b.release();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        b.acquire();
                        System.out.println("B");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        c.release();
                    }
                }
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        c.acquire();
                        System.out.println("C");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        a.release();
                    }
                }
            }
        }).start();
    }
}
