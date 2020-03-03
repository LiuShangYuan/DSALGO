package offeragain;

import java.util.LinkedList;

// 滑动窗口的最大值
public class MaxValueOfSlidingWindow {
    /**
     * 让队列头始终为最大值(索引)
     * [7 2 4]
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0){
            return nums;
        }
        int[] res = new int[nums.length - k + 1];
        int index = 0;

        LinkedList<Integer> list = new LinkedList<>();

        // 前k个元素 初始化
        for (int i=0;i<k;i++){
            // 同一个窗口内小于当前元素不可能最大值
            while (!list.isEmpty() && nums[list.getLast()] < nums[i]){
                list.removeLast();
            }

            list.addLast(i);
        }

        res[index++] = nums[list.getFirst()];

        for (int i=k;i<nums.length;i++){
            // 移除窗口外的元素
            if (!list.isEmpty() && i - k >= list.getFirst()){
                list.removeFirst();
            }

            while (!list.isEmpty() && nums[list.getLast()] < nums[i]){
                list.removeLast();
            }
            list.addLast(i);

            res[index++] = nums[list.getFirst()];
        }

        return res;
    }


    /**
     *
     *
     * {}为第一个窗口
     * []为第二个窗口
     * 求第二个窗口最大值时, 如果前一个窗口最大值在当前窗口内, 只要将该值和当前窗口最后一个值进行比较
     *
     * {1 [2 3} 4] 5 6
     *
     *
     *
     *
     *
     *
     * @param nums
     * @param k
     * @return
     */

    public int[] maxSlidingWindow_from_leetcode(int[] nums, int k) {
        int len = nums.length;
        if (len == 0){
            return new int[0];
        }
        //定义结果数组
        int[] res = new int[len - k + 1];
        //maxInd记录每次最大值的下标，max记录最大值
        int maxInd = -1, max = Integer.MIN_VALUE;

        // 上一个窗口和当前窗口大部分重叠(首和尾有差别)
        for (int i = 0; i < len - k + 1; i++) {
            //判断最大值下标是否在滑动窗口的范围内
            if (maxInd >= i && maxInd < i + k){
                //存在就只需要比较最后面的值是否大于上一个窗口最大值
                if (nums[i + k - 1] > max){
                    max = nums[i + k - 1];
                    //更新最大值下标
                    maxInd = i + k - 1;
                }
            }
            //如果不在就重新寻找当前窗口最大值
            else {
                max = nums[i];
                for (int j = i; j < i + k; j++) {
                    if (max < nums[j]) {
                        max = nums[j];
                        maxInd = j;
                    }
                }
            }
            res[i] = max;
        }
        return res;
    }
}
