package offer;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class ArrangArray2SmallestNumber {
    // 对数组进行排序
    public String PrintMinNumber(int[] numbers) {
        if(numbers == null){
            return null;
        }
        if(numbers.length==0){
            return "";
        }
        Integer[] nums = new Integer[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            nums[i] = numbers[i];
        }


        Arrays.sort(nums, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return (o1+""+o2).compareTo(o2+""+o1);
            }
        });

        StringBuilder builder = new StringBuilder();

        for (int i=0;i<nums.length;i++){
            builder.append(nums[i]);
        }

        return builder.toString();
    }

    @Test
    public void test(){
        int[] numbers = {3, 32, 321};
        System.out.println(PrintMinNumber(numbers));
    }
}
