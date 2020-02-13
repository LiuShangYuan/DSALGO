package offer;

// 正则表达式匹配
public class RegularMatch {
    public boolean match(char[] str, char[] pattern) {
        return match(new String(pattern), new String(str), 0, 0);
    }


    public boolean match(String pattern, String string, int pptr, int sptr) {
        // 两个串都用完了
        if (pptr == pattern.length() && sptr == string.length()) {
            return true;
        }
        // 模式串已经用完, 原串还有
        if (pptr == pattern.length() && sptr < string.length()) {
            return false;
        }

        // pattern: ---a*----
        // string : ---a-----
        if (pptr + 1 < pattern.length() && pattern.charAt(pptr + 1) == '*') {
            if (sptr < string.length() && (pattern.charAt(pptr) == string.charAt(sptr) || pattern.charAt(pptr) == '.')) {
                return match(pattern, string, pptr + 2, sptr) // 匹配0个(让给后面匹配)
                        || match(pattern, string, pptr + 2, sptr + 1) // 匹配1个
                        || match(pattern, string, pptr, sptr + 1);// 匹配多个
            } else {
                // pattern: ---b*a----
                // string : ---a-----
                return match(pattern, string, pptr + 2, sptr); //只能取匹配0个的语义
            }
        }

        // 后面不是 * 或者根本没有后面
        if (sptr < string.length() && (pattern.charAt(pptr) == string.charAt(sptr) || pattern.charAt(pptr) == '.')) {
            return match(pattern, string, pptr + 1, sptr + 1);
        } else {
            return false;
        }
    }
}
