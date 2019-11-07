package hot100;

import java.util.Arrays;
import java.util.Stack;

/**
 * 每日温度
 */
public class DailyTemperatures {
    public static void main(String[] args) {

        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
//        int[] temperatures = {};
        System.out.println(Arrays.toString(new DailyTemperatures().dailyTemperatures(temperatures)));

    }


    public int[] dailyTemperatures(int[] T) {

        Stack<Integer> stack = new Stack<>();
        int[] res = new int[T.length];

        for (int i = T.length - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                res[i] = 0;
            } else {
                int topV = T[stack.peek()];
                if (topV > T[i]) {
                    res[i] = stack.peek() - i;
                } else {
                    while (!stack.isEmpty() && T[stack.peek()] <= T[i]) {
                        stack.pop();
                    }

                    if(!stack.isEmpty()) {
                        res[i] = stack.peek() - i;
                    }else {
                        res[i] = 0;
                    }
                }
            }
            stack.push(i);
        }

        return res;

    }
}
