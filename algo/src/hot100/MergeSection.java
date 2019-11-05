package hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 56 合并区间
 *
 *
 * 先按照左区间排序, 排序完之后再合并
 */
public class MergeSection {
    public static void main(String[] args) {
//        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] intervals = {{1, 4}, {4, 5}};
        System.out.println(new MergeSection().merge(intervals));
    }


    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> list = new ArrayList<>();


        if (intervals.length > 0) {
            list.add(intervals[0]);
        }

        int next = 1;

        while (next < intervals.length) {
            int[] start = list.get(list.size() - 1); // 最后一个元素
            if (intervals[next][0] <= start[1]) {
                start[1] = Math.max(start[1], intervals[next][1]);
            } else {
                list.add(intervals[next]);
            }
            next++;
        }

        int[][] ret = new int[list.size()][2];

        for (int i = 0; i < list.size(); i++) {
            ret[i] = list.get(i);
        }


        return ret;

    }

}
