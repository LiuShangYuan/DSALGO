package backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        System.out.println(new GenerateParentheses().generateParenthesis(3));
    }


    public List<String> generateParenthesis(int n) {
        List<String> retlist = new ArrayList<>();
        help("", 0, 0, n, retlist);

        return retlist;
    }


    public void help(String curstr, int count1, int count2, int n, List<String> retlist) {

        if (count1 > n || count2 > n) {
            return;
        }

        if (count1 == count2 && curstr.length() == 2 * n) {
            retlist.add(curstr);
            return;
        }
        if (count1 >= count2) {
            help(curstr + "(", count1 + 1, count2, n, retlist);
            help(curstr + ")", count1, count2 + 1, n, retlist);
        }

    }


//    public List<String> generateParenthesis(int n) {
//        List<String> res = new ArrayList<String>();
//        generate(res, "", 0, 0, n);
//
//        return res;
//    }
//    //count1统计“(”的个数，count2统计“)”的个数
//    public void generate(List<String> res , String ans, int count1, int count2, int n){
//
//        if(count1 > n || count2 > n) return;
//
//        if(count1 == n && count2 == n)  res.add(ans);
//
//
//        if(count1 >= count2){
////            String ans1 = new String(ans);
//            generate(res, ans+"(", count1+1, count2, n);
//            generate(res, ans+")", count1, count2+1, n);
//
//        }
//    }
}
