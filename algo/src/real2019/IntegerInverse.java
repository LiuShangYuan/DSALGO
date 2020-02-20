package real2019;

import java.util.Scanner;

// 整数的倒数
public class IntegerInverse {
    // 123 ==> 321
    public static String reverse(String x){
        StringBuilder builder = new StringBuilder();


        if(x.startsWith("-")){
            builder.append("-");
        }

        if(x.startsWith("+")){
            builder.append("+");
        }


        for (int i=x.length()-1;i>=1;i--){
            builder.append(x.charAt(i));
        }

        if(x.charAt(0) != '-' && x.charAt(0) != '+'){
            builder.append(x.charAt(0));
        }


        return builder.toString();
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String x = sc.nextLine().trim();

        System.out.println(reverse(x));
    }
}
