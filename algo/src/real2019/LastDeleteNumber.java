package real2019;

import java.util.Arrays;
import java.util.Scanner;

public class LastDeleteNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int value = scanner.nextInt();
        System.out.println(lastDeleteIndex(value));

        System.out.println(lastDeleteIndex(216));
    }


    public static int lastDeleteIndex(int n){
        boolean[] nums = new boolean[n];

        int lastD = -1;

        Arrays.fill(nums, false);

        int count = 0;
        int index = 0;
        int time = 0;
        while (true){
            if (count != 2){
                if (nums[index] == false)
                    count++;
            }else {
                if (nums[index] == false) { // 没删过
                    nums[index] = true; // delete
                    lastD = index;
                    time++;
                    if (time == n) {
                        break;
                    }
                    count = 0;
                }
            }

            index++;
            index = index % n;
        }

        return lastD;
    }
}
