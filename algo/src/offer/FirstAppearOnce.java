package offer;

import org.junit.Test;

// 第一个只出现一次的字符
public class FirstAppearOnce {
    public int FirstNotRepeatingChar(String str) {

        int[] hash = new int[256];

        for(int i=0;i<str.length();i++){
            hash[str.charAt(i)] += 1;
        }


        for (int i=0;i<str.length();i++){
            if(hash[str.charAt(i)] == 1){
                return i;
            }
        }
        return -1;
    }



    @Test
    public void test(){
        System.out.println(FirstNotRepeatingChar("abacdb"));
    }
}
