package greedy;

import java.util.Arrays;

/**
 * 分发饼干
 */
public class DistributeBiscuits {
    public static void main(String[] args) {

        int[] g = {1, 2, 3};
        int[] s = {1, 1};
        System.out.println(new DistributeBiscuits().findContentChildren(g, s));
    }

    /**
     * 两个列表分别排序, 按照胃口从小到大依次满足
     * @param g 胃口
     * @param s 饼干
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {

        if (g == null || s == null) {
            return 0;
        }
        int count = 0;
        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0, j = 0;

        for (; i < s.length && j < g.length; ) {
            if (s[i] >= g[j]) {
                count++;
                i++;
                j++;
            } else {
                i++;
            }
        }

        return count;
    }
}
