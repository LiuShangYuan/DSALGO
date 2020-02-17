package offer;

import org.junit.Test;

// 将字符串转成整数

// 注意数据可能溢出整形范围
public class String2Int {
    public int StrToInt(String str) {
        char[] chars = str.toCharArray();
        long sum = 0;
        int tmp = 1;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == '+') {
                if (i != 0) {
                    return 0;
                }

                if (sum <= Integer.MAX_VALUE) {
                    return (int) sum;
                } else {
                    return 0;
                }
            }
            if (chars[i] == '-') {
                if (i != 0) {
                    return 0;
                }
                if (-sum >= Integer.MIN_VALUE) {
                    return (int) -sum;
                } else {
                    return 0;
                }
            }
            int num = (chars[i] - '0');

            if (num < 0 || num > 9) {
                return 0;
            }

            sum += tmp * num;
            boolean newflag = sum >= 0;

            tmp *= 10;
        }

        if (sum >= Integer.MIN_VALUE && sum <= Integer.MAX_VALUE) {
            return (int) sum;
        } else {
            return 0;
        }
    }

    @Test
    public void test() {
        System.out.println(StrToInt("-2147483648"));
        System.out.println(StrToInt("123"));
        System.out.println(StrToInt("-2147483649"));
        System.out.println(StrToInt("+2147483647"));
    }
}
