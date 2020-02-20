package real2019;

import java.util.Scanner;

// 字符串加法
public class StringADD {

    public static String add(String a, String b) {
        int len1 = a.length();
        int len2 = b.length();

        boolean jinwei = false;

        StringBuilder builder = new StringBuilder();

        int i = len1 - 1;
        int j = len2 - 1;

        while (i >= 0 && j >= 0) {
            if (a.charAt(i) == b.charAt(j)) {
                if (a.charAt(i) == '1') { // 两个都为1
                    if (jinwei) {
                        builder.append(1);
                    } else {
                        builder.append(0);
                        jinwei = true; // 下一次要仅为
                    }
                } else { //两个都为0
                    if (jinwei) {
                        builder.append(1);
                        jinwei = false;
                    } else {
                        builder.append(0);
                    }
                }
            } else { // 1个0 1个1
                if (jinwei) {
                    builder.append(0);
                } else {
                    builder.append(1);
                }
            }
            i--;
            j--;
        }

        while (i >= 0) {
            if (jinwei) {
                if (a.charAt(i) == '1') {
                    builder.append("0");
                } else {
                    builder.append("1");
                    jinwei = false;
                }
            } else {
                builder.append(a.charAt(i));
            }
            i--;
        }

        while (j >= 0) {
            if (jinwei) {
                if (b.charAt(j) == '1') {
                    builder.append("0");
                } else {
                    builder.append("1");
                    jinwei = false;
                }
            } else {
                builder.append(b.charAt(j));
            }
            j--;
        }

        if(jinwei){
            builder.append("1");
        }
        return builder.reverse().toString();
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] line = sc.nextLine().trim().split(" ");

        System.out.println(add(line[0], line[1]));
    }
}
