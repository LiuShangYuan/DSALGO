package newcoder_guazi2019;

import java.util.Arrays;

/**
 * 单词逆序
 * leetcode 151. 翻转字符串里的单词
 *
 * 用 StringBuilder拼接字符串 速度很快
 */
public class WordReverseOrder {
    public static void main(String[] args) {
        System.out.println(Arrays.toString("  hello world!  ".split(" ")));
        System.out.println(new WordReverseOrder().help("  hello world!  "));
    }

    public String help(String str){
        StringBuilder builder = new StringBuilder();
        if(str==null){
            return str;
        }
        String[] strlist = str.split(" ");
        for(int i=strlist.length-1;i>=0;i--){
            if (strlist[i].equals(""))
                continue;

            builder.append(strlist[i]);

            if(i!=0)
                builder.append(" ");
        }
        return builder.toString().trim();
    }


    public String reverse(String str){
        StringBuilder builder = new StringBuilder(str);
        for(int i=0; i<str.length() / 2; i++){
            char tmp = builder.charAt(i);
            builder.setCharAt(i, builder.charAt(str.length()-1-i));
            builder.setCharAt(str.length()-1-i, tmp);
        }
        return builder.toString();
    }
}
