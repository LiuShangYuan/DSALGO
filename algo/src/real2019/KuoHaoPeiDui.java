package real2019;

import java.util.Scanner;
import java.util.Stack;

// 括号配对问题
public class KuoHaoPeiDui {
    public static boolean help(String s){
        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();
        for(int i=0;i<arr.length;i++){
            if(arr[i]=='(' || arr[i] == '['){
                stack.push(arr[i]);
            }else if(arr[i] == ')'){
                if(stack.isEmpty() || stack.pop() != '('){
                    return false;
                }
            }else if(arr[i] == ']'){
                if(stack.isEmpty() || stack.pop() != '['){
                    return false;
                }
            }
        }
        if(!stack.isEmpty()){
            return false;
        }
        return true;
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(help(str));
    }
}
