package offer;

import java.util.Comparator;
import java.util.PriorityQueue;

// 数据流的中位数
public class MiddleNumberOfDataStream {

    // 最小堆
    PriorityQueue<Integer> rightheap = new PriorityQueue<>();

    // 最大堆
    PriorityQueue<Integer> leftheap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });


    public void Insert(Integer num) {
        // 左边为空或者插入的数小于堆顶
        if (leftheap.isEmpty() || leftheap.peek() >= num) {
            leftheap.add(num);
        }else {
            rightheap.add(num);
        }

        // 保证left的size 大于等于right (奇数大于，偶数等于)

        if(leftheap.size() < rightheap.size()){
            // 将right的最小值插入到left
            leftheap.add(rightheap.peek());
            rightheap.poll();
        }else if(leftheap.size() - rightheap.size() == 2){
            rightheap.add(leftheap.peek());
            leftheap.poll();
        }
    }

    public Double GetMedian() {
        if(leftheap.size() > rightheap.size()){ // 奇数
            return new Double(leftheap.peek());
        }else {
            return new Double(leftheap.peek() / 2.0 + rightheap.peek() / 2.0);
        }
    }
}
