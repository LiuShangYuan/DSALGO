package concurrent;

import java.util.concurrent.Semaphore;

// A打印奇数，B打印偶数
public class ABThread {
    private static Semaphore semaphoreA = new Semaphore(1);
    private static Semaphore semaphoreB = new Semaphore(0);

    private static int n = 100;

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Thread.currentThread().setName("A");
                for (int i=1;i<=n;i++){
                    if(i % 2 != 0){
                        try {

                            semaphoreA.acquire();
                            System.out.println("A : " + i);
                        }catch (Exception e){

                        }finally {
                            semaphoreB.release();
                        }

                    }
                }
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                Thread.currentThread().setName("B");
                for (int i=1;i<=n;i++){
                    if(i % 2 == 0){
                        try {
                            semaphoreB.acquire();
                            System.out.println("B : " + i);
                        }catch (Exception e){

                        }finally {
                            semaphoreA.release();
                        }

                    }
                }
            }
        }).start();


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
