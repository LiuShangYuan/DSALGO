package real2019;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

//
public class KthMaxValue {
    public static int kth(int[] arr, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int i = 0; i < arr.length; i++) {
            heap.add(arr[i]);
        }

        for (int i = 0; i < 2; i++) {
            heap.poll();
        }
        return heap.peek();
    }

    public static int solution(int[] arr, int k) {
        int start = 0;
        int end = arr.length - 1;
        // 等于不能丢(可能就是==的是要的值, 丢掉的话就漏了一部分)
        while (start <= end) {
            int index = partition(arr, start, end);
            if (index == k - 1) {
                return arr[index];
            } else if (index > k - 1) {
                end = index - 1;
            } else {
                start = index + 1;
            }
        }
        return -1;
    }

    // 前面放大后面放小
    public static int partition(int[] arr, int low, int high) {
        int base = arr[low];
        while (low < high) {
            // 从后向前找一个大于基准值得数
            while (low < high && arr[high] < base) {
                high--;
            }

            if (low < high) {
                // 交换high到low位置
                arr[low] = arr[high];
                low++;
            }

            // 从前向后找一个小于基准值的数
            while (low < high && arr[low] > base) {
                low++;
            }

            if (low < high) {
                arr[high] = arr[low];
                high--;
            }
        }
        // 放置基准值 (每次只有一个指针在前进, 每次前进1不, 当low==high时退出)
        arr[low] = base;
        return low; // 基准值最终位置
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine().trim();
        String[] lines = line.substring(1, line.length() - 1).split(",");
        int[] arr = new int[lines.length];
        for (int i = 0; i < lines.length; i++) {
            arr[i] = Integer.parseInt(lines[i]);
        }

        System.out.println(solution(arr, 3));
    }
}
