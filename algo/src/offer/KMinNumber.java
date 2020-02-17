package offer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class KMinNumber {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        ArrayList<Integer> list = new ArrayList<>();
        if(input == null || input.length == 0 || k <=0 || k>input.length){
            return list;
        }

        // build heap
        for (int i=0;i<input.length;i++){
            priorityQueue.add(input[i]);
        }

        for (int i=0;i<k && !priorityQueue.isEmpty();i++){
            list.add(priorityQueue.poll());
        }

        return list;
    }

    @Test
    public void test(){
        int[] input = {4,5,1,6,2,7,3,8};
        System.out.println(GetLeastNumbers_Solution(input,  10));
    }
}
