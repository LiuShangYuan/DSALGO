import sun.misc.Unsafe;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.cert.TrustAnchor;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Class.forName;

public class SourceCode {

    public static void main(String[] args) throws Exception {
//        Map<String, String> map = new LinkedHashMap<String, String>(16,0.75f,false);
//        map.put("apple", "苹果");
//        map.put("watermelon", "西瓜");
//        map.put("banana", "香蕉");
//        map.put("peach", "桃子");
//
//        map.get("banana");
//        map.get("apple");
//
//        Iterator iter = map.entrySet().iterator();
//        while (iter.hasNext()) {
//            Map.Entry entry = (Map.Entry) iter.next();
//            System.out.println(entry.getKey() + "=" + entry.getValue());
//        }

//        LinkedList
//        ArrayList

        System.out.println(10 >>> 2);

//        Executors.newCachedThreadPool();
//        Executors.newFixedThreadPool();
//        ArrayBlockingQueue
//        LinkedBlockingQueue

//        ReentrantLock

//        Future

//        FutureTask

//        ThreadLocal

//        ForkJoinPool

//        ThreadPoolExecutor


        Integer[][] matrix = new Integer[][] {
                {8,7},{9,5},{6,4}
        };


//        Arrays.sort(matrix, new Comparator<Integer[]>() {
//            @Override
//            public int compare(Integer[] o1, Integer[] o2) {
//                if(o1[1] > o2[1]){
//                    return 1;
//                }else if(o1[1] == o2[1]){
//                    return 0;
//                }else {
//                    return -1;
//                }
//            }
//        });

        Arrays.sort(matrix, (Integer[] o1 , Integer[] o2)->{
            if(o1[1] > o2[1]){
                return 1;
            } else if (o1[1] == o2[1]) {
                return 0;
            } else {
                return -1;
            }
        });


        for (Integer[] i: matrix){
            System.out.println(Arrays.toString(i));
        }

    }
}
