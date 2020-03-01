package top_interview.string;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

// 6. z字形变换
public class Ztype {
    /**
     *
     * 1232123 ====> 行的变化
     * 010101
     *
     *
     *
     *
     *
     *
     *
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        if(s == null || "".equals(s) || numRows <= 0){
            return s;
        }

        if(numRows==1){
            return s;
        }
        List<List<Character>> list = new ArrayList<>();

        for (int i=0;i<numRows;i++){
            list.add(new ArrayList<>());
        }

        int start = 0;
        boolean asc = true;
        for (int i=0;i<s.length();i++){
            char ch = s.charAt(i); // 字符
            list.get(start).add(ch);
            if(asc) {
                // 0 1 0 1 0
                start++;
                if(start == numRows-1){
                    asc = false;
                }
            } else {
                start--;
                if(start==0){
                    asc = true;
                }
            }
        }

        StringBuilder builder = new StringBuilder();

        for (int i=0;i<numRows;i++){
            for (int j=0;j<list.get(i).size();j++ ){
                builder.append(list.get(i).get(j));
            }
        }

        return builder.toString();
    }

    @Test
    public void test(){
//        System.out.println(convert("LEETCODEISHIRING", 2));
        System.out.println(convert("AB", 1));
    }
}


