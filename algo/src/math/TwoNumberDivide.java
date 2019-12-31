package math;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * User: yinkai
 * Date: 2019-12-31
 * Time: 15:26
 */
public class TwoNumberDivide {

    @Test
    public void test() {
//        TestCase.assertEquals(3, divide(10, 3));
//        TestCase.assertEquals(-2, divide(7, -3));
//        System.out.println(new TwoNumberDivide().divide(2147483647, 2));
        System.out.println(new TwoNumberDivide().divide(-2147483648, 2));


    }

    public int divide(int dividend, int divisor) {
        if (divisor == 0)
            return 0;

        if (divisor == 1)
            return dividend;

        if (divisor == -1) {
            if (dividend > Integer.MIN_VALUE)
                return -dividend;
            else
                return Integer.MAX_VALUE;
        }

        boolean flag = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0);

        long dividend_n = Math.abs((long)dividend);
        long divisor_n = Math.abs((long)divisor);

//        dividend = Math.abs(dividend);
//        divisor = Math.abs(divisor);

        int result = 0;
        int res = 0;
        long tmp = 0;
        while (dividend_n >= divisor_n) {
            if (tmp <= dividend_n) {

                if (tmp == 0) {
                    if (tmp + divisor_n > dividend_n || tmp + divisor_n < 0) {
                        dividend_n -= tmp;
                        tmp = 0;
                    } else {
                        tmp += divisor_n;
                        result += res;
                        res = 1;
                    }
                } else {
                    if (tmp + tmp > dividend_n || tmp + tmp < 0) {
                        dividend_n -= tmp;
                        tmp = 0;
                    } else {
                        tmp += tmp;
                        res += res;
                    }
                }

            }
        }

        result += res;

        if(!flag){
            result = -result;
        }

        return result;
    }
}
