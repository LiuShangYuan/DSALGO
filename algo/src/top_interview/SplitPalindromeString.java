package top_interview;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 分割回文子串
 * <p>
 * 输入: "aab"
 * 输出:
 * [
 * ["aa","b"],
 * ["a","a","b"]
 * ]
 */
public class SplitPalindromeString {
    public static void main(String[] args) {
//        new SplitPalindromeString().partition("abaaba");
        new SplitPalindromeString().partition("aab");
    }


    public List<List<String>> partition(String s) {
        if(s == null || s.length() == 0){
            return null;
        }
        List<List<String>> res = help(s, 0, s.length() - 1);
        return res;
    }


    // abaaba
    //
    public List<List<String>> help(String s, int start, int end) {

        if (start > end) {
            List<String> ilist = new ArrayList<>();
            List<List<String>> olist = new ArrayList<>();
            olist.add(ilist);
            return olist;
        }

        List<List<String>> retl = new ArrayList<>();
//        for (int i = end; i >= start; i--) {
//            if (ishuiwen(s, start, i)) {
//                // start---i 为回文断，继续判断 i--到end
//                List<List<String>> rlist = help(s, i + 1, end);
//                for (List<String> l : rlist) {
//                    l.add(s.substring(start, i + 1));
//                }
//                retl.addAll(rlist);
//            }
//        }

        for (int i = start; i <= end; i++) {
            if (ishuiwen(s, start, i)) {
                // start---i 为回文断，继续判断 i--到end
                List<List<String>> rlist = help(s, i + 1, end);
                for (List<String> l : rlist) {
//                    l.add(s.substring(start, i + 1));
                    l.add(0, s.substring(start, i + 1));
                }
                retl.addAll(rlist);
            }
        }

        return retl;

    }

    @Test
    public void testhuiwen(){

        System.out.println(ishuiwen("abaaba",0, 3) + "");
    }

    // abaaba
    // 012345
    boolean ishuiwen(String str, int start, int end) {

        for (int i = start; i < (end - start) / 2 + start + 1; i++) {
            if (str.charAt(i) != str.charAt(start + end - i)) {
                return false;
            }
        }
        return true;
    }
}
