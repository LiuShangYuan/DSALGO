package offer;

import org.junit.Test;

// 构建乘积数组
public class MultiplyArray {

    // B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]
    public int[] multiply(int[] A) {
        int[] B = new int[A.length];
        int[] D = new int[A.length];

        B[0] = 1;
        D[A.length - 1] = 1;

        for (int i = 1; i < A.length; i++) {
            B[i] = B[i - 1] * A[i - 1];
        }

        for (int i = A.length - 2; i >= 0; i--) {
            D[i] = D[i + 1] * A[i + 1];
        }

        for (int i = 0; i < A.length; i++) {
            B[i] = B[i] * D[i];
        }

        return B;

    }


    @Test
    public void test() {

    }
}
