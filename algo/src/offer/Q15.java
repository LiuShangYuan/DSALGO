package offer;

/**
 * 二进制中1的个数
 */
public class Q15 {

    public static void main(String[] args) {
        System.out.println(new Q15().NumberOf1_v2(9));
    }


    public int NumberOf1(int n) {
        int count = 0;

        int flag = 1;

        int yiwei = 0;


        while (flag != 0) {
            yiwei++;
            if ((n & flag) != 0) {
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }




    public int NumberOf1_v2(int n) {
        int count = 0;
        while (n != 0) {

            ++count;
            //去除最右边的1
            n = n & (n-1);
        }

        return count;
    }
}
