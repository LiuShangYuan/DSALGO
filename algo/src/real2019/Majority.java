package real2019;

import java.util.Scanner;

// 查找数组众数
public class Majority {

    public static int majority(int[] arr) {
        int candidate = -1; // 待删除
        int cnt = 0;  // 删除几次

        for (int i = 0; i < arr.length; i++) {
            if (cnt == 0) {
                candidate = arr[i]; // 之前已经删除完了，新的待删除数据
                cnt++;
            } else {
                if (candidate != arr[i]) { // 不同的两个数
                    cnt--;
                } else {
                    cnt++;
                }
            }

        }

        return candidate;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine().trim();
        String[] lines = line.substring(1, line.length() - 1).split(",");
        int[] arr = new int[lines.length];
        for (int i = 0; i < lines.length; i++) {
            arr[i] = Integer.parseInt(lines[i]);
        }

        System.out.println(majority(arr));

    }
}
