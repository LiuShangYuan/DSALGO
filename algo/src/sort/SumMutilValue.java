package sort;

import java.util.ArrayList;
import java.util.List;

/**
 * 寻找和为定值的多个数
 * <p>
 * 1) 取第n个数 或者 不去第n个数两种情况
 */
public class SumMutilValue {

    List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        new SumMutilValue().SumOfkNumber(20, 10);


    }


    public void SumOfkNumber(int sum, int n) {
        if (n <= 0 || sum <= 0) {
            return;
        }


        if (sum == n) {
            list.add(n);
            System.out.println(list);
            list.remove(Integer.valueOf(n));
        }


        // 取n

        list.add(n);
        SumOfkNumber(sum - n, n - 1);

        // 不取 n
        list.remove(Integer.valueOf(n));
        SumOfkNumber(sum, n - 1);
    }
}
