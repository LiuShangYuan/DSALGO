package top_interview;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * User: yinkai
 * Date: 2019-12-22
 * Time: 19:37
 */

// 295. 数据流的中位数
public class MedianFinder {


    List<Integer> nums;

    public MedianFinder() {
        nums = new ArrayList<>();
    }

    public void addNum(int num) {

    }

    public double findMedian() {
        return 0.0;
    }



    @Test
    public void test() {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
    }

}
