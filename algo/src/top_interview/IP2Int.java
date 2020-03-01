package top_interview;

import org.junit.Test;

import java.util.Scanner;

public class IP2Int {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        while (sc.hasNext()) {
            String ip = sc.nextLine().trim();
            String value = sc.nextLine().trim();
            System.out.println(ip2int(ip));
            System.out.println(int2ip(Long.parseLong(value)));
        }
    }



    // 167773121
    public static String int2ip(long value){
        StringBuilder builder = new StringBuilder();
        long[] arr = new long[4];
        int index = 3;
        while (value > 0){
            long tmp = value & 255;
            arr[index--] = tmp;
            value = value >> 8;
        }
        for (int i=0;i<arr.length;i++){
            builder.append(arr[i]);
            if(i<arr.length-1){
                builder.append(".");
            }
        }
        return builder.toString();
    }



    // ip ---> 整数
    // 整数到ip
    // 10.0.3.193
    public static long ip2int(String ip){
        String[] arr = ip.split("\\.");

        long value = Long.parseLong(arr[0]);
        for (int i=1;i<arr.length;i++){
            value = value << 8;
            value += Long.parseLong(arr[i]);

        }
        return value;
    }


    // 234.237.37.104
    //3165757026

    @Test
    public void test(){
        System.out.println();
        System.out.println(ip2int("234.237.37.104"));
        System.out.println(int2ip(3165757026L));
    }
}
