package offeragain;

import org.junit.Test;

import java.util.HashMap;

// 最长不含重复字符的字字符串
public class LongestSubStringWithCharacterRepate {
    /**
     *
     * pwwkew
     * {p:1, w:2}
     *
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        int len = 0;

        int i=0;
        int j=0;

        // "pwwkew"
        // "tmmzuxt"
        // i~~~j'~~~j 在j位置发现j'重复, 下次可以直接把i移动到j'+1
        // 为了防止 i~~~j' 之间的元素影响后面哈希表的判断
        // 1) 把这之间的元素删除
        // 2) 这部分元素肯定位于新的 i=j'+1之前, 哈希表判断是否之前出现过，可以判断如果在j'+1之前则也当做没出现过
        while (j < s.length()){
            if (map.get(s.charAt(j)) == null || map.get(s.charAt(j)) < i){
                map.put(s.charAt(j), j);
                len = Math.max(len, j - i + 1);
                j++;
            }else {
                int ridx = map.get(s.charAt(j));
                i = ridx + 1;
                map.put(s.charAt(j), j);
                j++;
            }
        }

        return len;
    }


    @Test
    public void test(){
        System.out.println(lengthOfLongestSubstring("tmmzuxt"));
    }
}
