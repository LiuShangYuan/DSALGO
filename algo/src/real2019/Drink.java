package real2019;

import java.util.Scanner;

// 汽水瓶
public class Drink {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()){
            System.out.println(help(scanner.nextInt()));
        }
    }


    // 10 ----> 3
    public static int help(int n){

        int left = n; // 当前空瓶子数

        int count = 0; // 喝掉汽水数


        while (true){
            int tmp = left / 3; // 拿去换
            if (tmp == 0){ // left = 0, 1, 2
                if (left == 2) { //还能凑一瓶
                    count++;
                    break;
                }
                return count;
            }
            count += tmp;
            left = left % 3 + tmp;
        }
        return count;
    }
}
