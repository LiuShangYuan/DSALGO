package offeragain;
// 坐旋转字符串
public class LeftShiftString {
    /**
     *
     * 输入: s = "abcdefg", k = 2
     * 输出: "cdefgab"
     *
     * @param s
     * @param n
     * @return
     */
    public static String reverseLeftWords(String s, int n) {
        n = n % s.length();
        if(n == 0){
            return s;
        }

        return s.substring(n) + s.substring(0, n);

    }


    public static void main(String[] args) {
        System.out.println(reverseLeftWords("abcdefg", 2));
    }
}
