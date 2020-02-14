package offer;
// 翻转单词顺序列

import org.junit.Test;

import java.util.Arrays;

//student. a am I ==>  I ma a .tneduts ==> I am a student. (两次翻转)
// 注意: " "的情况
public class ReverseWordSentence {
    public String ReverseSentence(String str) {
        if(str == null || "".equals(str)){
            return str;
        }
        String rstr = reverse(str);

        String[] sarr = rstr.split(" ");
        if(sarr == null || sarr.length == 0){
            return str;
        }
        StringBuilder builder = new StringBuilder();
        for (String s : sarr) {
            builder.append(reverse(s));
            builder.append(" ");
        }

        return builder.toString().substring(0, str.length());
    }


    public String reverse(String str) {
        // 当多个空格连续时的优化
        if (str.equals(" ")){
            return str;
        }
        char[] array = str.toCharArray();

        for (int i = 0; i < array.length / 2; i++) {
            char ch = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = ch;
        }

        return new String(array);
    }

    @Test
    public void test() {
        System.out.println(ReverseSentence(" "));

        System.out.println(Arrays.toString(" ".split(" ")));
    }
}
