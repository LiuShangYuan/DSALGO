package top_interview.string;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

// 12 整数转罗马数字
public class Integer2Rome {
    public String intToRoman(int num) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");

        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        int[] seq = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder builder = new StringBuilder();
        // 1994 ---> MCMXCIV
        // 994   ---> M
        while (num!= 0){
            for (int i=0;i<seq.length;i++){
                if(num / seq[i] > 0){
                    builder.append(romans[i]);
                    num = num - seq[i];
                    break;
                }
            }
        }

        return builder.toString();

    }


    @Test
    public void test(){
        System.out.println(intToRoman(58));
    }
}
