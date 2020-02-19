package real2019;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 考虑你从家出发步行去往一处目的地，该目的地恰好离你整数单位步长（大于等于1）。
 * 你只能朝向该目的地或者背向该目的地行走，而你行走的必须为单位步长的整数倍，且要求你第N次行走必须走N步。
 * 请就给出目的地离你距离，判断你是否可以在有限步内到达该目的地。
 * 如果可以到达的话，请计算到达目的地的最短总步数(不能到达则输出-1)。
 * <p>
 * <p>
 * <p>
 * 1 2 3 4 .... n
 * <p>
 * 相当于给1~N加上正负号, 让最终的和为 T
 * <p>
 * <p>
 * 5  1 2 3 4 5 6
 */
public class ShortestSteps {


    // bfs
    public static int help(int t) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        arr1.add(0);

        int step = 1;
        while (true){
            for (int i=0;i<arr1.size();i++){
                int value1 = arr1.get(i) + step;
                int value2 = arr1.get(i) - step;
                if(value1 == t || value2 == t){
                    return step;
                }
                arr2.add(value1);
                arr2.add(value2);
            }
            ArrayList<Integer> temp = arr1;
            arr1 = arr2;
            temp.clear();
            arr2 = temp;

            step++;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        System.out.println(help(t));
    }
}
