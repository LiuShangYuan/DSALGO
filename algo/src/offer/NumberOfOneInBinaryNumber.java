package offer;

import org.junit.Test;

public class NumberOfOneInBinaryNumber {

    public int NumberOf1(int n) {
        int c = 0;
        while (n != 0){
            n &= (n-1);
            c++;
        }

        return c;
    }


    /**
     *
     *  111
     *  110
     *  ---
     *  110
     *  101
     *  ---
     *  100
     *  011
     *  ---
     *  000
     *
     */

    @Test
    public void test(){
        System.out.println(NumberOf1(-2147483648));
    }
}
