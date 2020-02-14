package offer;

import org.junit.Test;

// 左旋转字符串
public class LeftRotateString {
    // abcXYZdef  ===> cbafedZYX ==> XYZdefabc 两次翻转操作
    // XYZdefabc
    // (A)(B)
    // reverse ==> 翻转
    // r(r(A)r(B))
    public String LeftRotateString(String str, int n) {
        if (str == null || "".equals(str)){
            return str;
        }
        if (n >= str.length()) {
            n = n % str.length();
        }

        if(n==0){
            return str;
        }

        return str.substring(n) + str.substring(0, n);
    }


    @Test
    public void test() {
        System.out.println(LeftRotateString("abcXYZdef", 0));
    }
}
