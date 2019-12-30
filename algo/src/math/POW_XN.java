package math;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * User: yinkai
 * Date: 2019-12-29
 * Time: 22:02
 */
public class POW_XN {


    @Test
    public void test() {
//        TestCase.assertEquals(1024.0, new POW_XN().myPow(2.0, 10));
//        TestCase.assertEquals(9.261, new POW_XN().myPow(2.1, 3));
//        TestCase.assertEquals(0.25, new POW_XN().myPow(2.0, -2));

        System.out.println(new POW_XN().myPow(0.00001, 2147483647));
    }


    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double ans = 1;
        double current_product = x;
        for (long i = N; i > 0; i /= 2) {
            if ((i % 2) == 1) {
                ans = ans * current_product;
            }
            current_product = current_product * current_product;
        }
        return ans;
    }
}
