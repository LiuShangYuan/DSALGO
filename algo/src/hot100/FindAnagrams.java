package hot100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 438. 找到字符串中所有字母异位词
 * <p>
 * <p>
 * p中一个字符可以出现多次,应该统计出现的次数,而不是出现的位置
 */
public class FindAnagrams {
    public static void main(String[] args) {
        System.out.println(new FindAnagrams().findAnagrams("abab", "ab"));
        System.out.println(new FindAnagrams().findAnagrams("cbaebabacd", "abc"));
        System.out.println(new FindAnagrams().findAnagrams("baa", "aa"));
    }


    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < p.length(); i++) {
            map1.put(p.charAt(i), map1.getOrDefault(p.charAt(i), 0) + 1);
        }

        int start = 0;
        for (int i = 0; i < s.length(); ) {
            // 不在p中
            if (map1.getOrDefault(s.charAt(i), null) == null) {
                start = i + 1;
                i = start;
                map2.clear();
            } else { // 在 p中

                map2.put(s.charAt(i), map2.getOrDefault(s.charAt(i), 0) + 1);

                if (i - start + 1 == p.length()) {
                    if (map1.equals(map2)) {
                        list.add(start);
                    }
                    map2.put(s.charAt(start), map2.get(s.charAt(start)) - 1);
                    start++;
                }


                i++;
            }
        }

        return list;
    }
}
