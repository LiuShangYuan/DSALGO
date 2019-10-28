package backtracking;

import java.util.*;

public class LetterCombinationPhoneNumber {


    public static void main(String[] args) {
        System.out.println(new LetterCombinationPhoneNumber().letterCombinations("23"));
    }

    public List<String> letterCombinations(String digits) {

        Map<Character, List<Character>> map = new HashMap<>();

        map.put('2', Arrays.asList('a', 'b', 'c'));
        map.put('3', Arrays.asList('d', 'e', 'f'));
        map.put('4', Arrays.asList('g', 'h', 'i'));
        map.put('5', Arrays.asList('j', 'k', 'l'));
        map.put('6', Arrays.asList('m', 'n', 'o'));
        map.put('7', Arrays.asList('p', 'q', 'r', 's'));
        map.put('8', Arrays.asList('t', 'u', 'v'));
        map.put('9', Arrays.asList('w', 'x', 'y', 'z'));

        List<String> list = help(digits, map);


        return list;
    }


    public List<String> help(String digits, Map<Character, List<Character>> map) {
        if (digits == null || "".equals(digits)) {
            return new ArrayList<>();
        }
        List<String> ret = new ArrayList<>();

        List<Character> charset = map.getOrDefault(digits.charAt(0), null);
        for (Character ch : charset) {
            List<String> list = help(digits.substring(1, digits.length()), map);
            if (list.size() == 0) {
                list.add(ch.toString());
            } else {
                for (int i = 0; i < list.size(); i++) {
                    list.set(i, ch + list.get(i));
                }
            }
            ret.addAll(list);
        }

        return ret;
    }

}
