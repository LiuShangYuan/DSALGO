package offer;

import org.junit.Test;

import java.util.*;

// 滑动窗口的最大值
public class MaxValueOfSlidingWindow {

    // {2,3,4,2,6,2,5,1}
    // {4,4,6,6,6,5}
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });


        ArrayList<Integer> list = new ArrayList<>();

        if (size <= 0 || num.length < size) {
            return list;
        }


        int s = 0;

        while (s < num.length) {
            if (heap.size() == size) {
                list.add(heap.peek());
                heap.remove(num[s - size]);
            }
            heap.add(num[s++]);
        }

        if (heap.size() == size) {
            list.add(heap.peek());
        }

        return list;
    }

    // 使用双端队列
    // {2,3,4,2,6,2,5,1}
    // {4,4,6,6,6,5}
    //2 | 2
    //3 | 3
    //4 | 4     ==>  4
    //4 | 4 2   ==>  4
    //6 | 6     ==>  6
    //2 | 6 2   ==>  6
    //5 | 6 5   ==>  6
    //1 | 5 1   ==>  5
    public ArrayList<Integer> maxInWindows_method2(int[] num, int size) {
        Deque<Integer> queue = new ArrayDeque<>();

        ArrayList<Integer> list = new ArrayList<>();

        if (size <= 0 || num.length < size) {
            return list;
        }

        for (int i = 0; i < size && i < num.length; i++) {
            if (queue.isEmpty()) {
                queue.addLast(i);
                continue;
            }

            while (!queue.isEmpty() && num[queue.getLast()] <= num[i]){
                queue.removeLast();
            }

            queue.addLast(i);

        }

        list.add(num[queue.getFirst()]);


        for (int i = size; i < num.length; i++) {
            while (!queue.isEmpty() && num[queue.getLast()] <= num[i]){
                queue.removeLast();
            }

            if (!queue.isEmpty() && queue.getFirst() <= (i - size)) {
                queue.removeFirst();
            }

            queue.addLast(i);

            list.add(num[queue.getFirst()]);
        }

        return list;
    }


    @Test
    public void test() {
        System.out.println(maxInWindows_method2(new int[]{2, 3, 4, 2, 6, 2, 5, 1}, 3));
    }
}
