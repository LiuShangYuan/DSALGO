package real2019;


import java.util.Scanner;

// 鸡鸭分类问题
public class JiYaClf {
    public static int changeCD(String str) {
        char[] arr = str.toCharArray();
        int result = 0;
        for (int i = 0; i < arr.length-1; i++) {
            if(arr[i+1] == 'C' && arr[i] == 'D'){
                int k = i;
                while (k>=0 && arr[k] == 'D'){

                    result++; // 发生一次相邻的交换
                    char ch = arr[k];
                    arr[k] = arr[k+1];
                    arr[k+1] = ch;
                    k--;
                }
            }
        }
        return result;
    }

    public static int changeDC(String str) {
        char[] arr = str.toCharArray();
        int result = 0;
        for (int i = 0; i < arr.length-1; i++) {
            if(arr[i+1] == 'D' && arr[i] == 'C'){
                int k = i;
                while (k>=0 && arr[k] == 'C'){

                    result++; // 发生一次相邻的交换
                    char ch = arr[k];
                    arr[k] = arr[k+1];
                    arr[k+1] = ch;
                    k--;
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(Math.min(JiYaClf.changeCD(input), JiYaClf.changeDC(input)));
    }
}
