package top_interview.string;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

// 13. 罗马数字转整数
public class Rome2Integer {
    public int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);

        int start = 0;
        int num = 0;

        while (start < s.length()){
            char ch = s.charAt(start);

            if (ch == 'I'){
                if (start +1 < s.length() && s.charAt(start + 1) == 'V'){
                    num += 4;
                    start += 2;
                    continue;
                }
                if (start +1 < s.length() && s.charAt(start + 1) == 'X'){
                    num += 9;
                    start += 2;
                    continue;
                }

                num += 1;
                start++;
            }else if (ch == 'X'){
                if (start +1 < s.length() && s.charAt(start + 1) == 'L'){
                    num += 40;
                    start += 2;
                    continue;
                }
                if (start +1 < s.length() && s.charAt(start + 1) == 'C'){
                    num += 90;
                    start += 2;
                    continue;
                }

                num += 10;
                start++;
            }else if (ch == 'C'){
                if (start +1 < s.length() && s.charAt(start + 1) == 'D'){
                    num += 400;
                    start += 2;
                    continue;
                }
                if (start +1 < s.length() && s.charAt(start + 1) == 'M'){
                    num += 900;
                    start += 2;
                    continue;
                }

                num += 100;
                start++;
            }else {
                num += getValue(ch);
                start++;
            }
        }

        return num;
    }

    private int getValue(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }


    @Test
    public void test(){
        System.out.println(romanToInt("MCMXCIV"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("IX"));
    }
}
