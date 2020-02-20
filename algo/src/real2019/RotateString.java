package real2019;

import java.util.Scanner;

// 旋转字符串
public class RotateString {
    // youzan
    // zanyou
    public static boolean help(String a, String b){
        // 将a翻转
        StringBuffer buffer = new StringBuffer(a);
        String ra = buffer.reverse().toString();
        for(int i=0;i<a.length();i++){
            // 将a分割成两个串
            // you zan          naz|uoy ==> zan you
            String s1 = ra.substring(0, i);
            String s2 = ra.substring(i);
            StringBuffer b1 = new StringBuffer(s1);
            StringBuffer b2 = new StringBuffer(s2);

            if((b1.reverse().toString() + b2.reverse().toString()).equals(b)){
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] lines = sc.nextLine().trim().split(";");

        System.out.println(help(lines[0], lines[1]));
    }
}
