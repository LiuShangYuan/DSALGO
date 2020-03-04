package sourcecode;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class AQSStu {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

//        Semaphore semaphore = new Semaphore(1);
//
//
//        CountDownLatch countDownLatch = new CountDownLatch(10);
//
//
//        CyclicBarrier cyclicBarrier = new CyclicBarrier(10);
//
//        ReentrantLock lock = new ReentrantLock();
//
//
//        ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<Integer>(10);


        Class c = Class.forName("sourcecode.TestFS"); // 具体实现类(第三方提供)
        TestFS testFS = (TestFS)c.newInstance();  // 接口类型 (反射获取实现类对象赋值给接口类型)

        Method methodA= c.getMethod("methodA"); // 调用实现类中的方法
        methodA.invoke(null);

        Method methodB = c.getMethod("methodB");
        methodB.invoke(testFS);

        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();

        HashMap<String, String> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();

        TreeMap treeMap = new TreeMap();


        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
    }
}

class TestFS{
    public static void methodA(){
        System.out.println("static method a");
    }

    public void methodB(){
        System.out.println("method B");
    }
}