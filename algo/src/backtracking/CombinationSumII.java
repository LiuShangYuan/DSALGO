package backtracking;

import java.util.*;

/**
 * 40 组合总和II
 */
public class CombinationSumII {
    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        System.out.println(new CombinationSumII().combinationSum2(candidates, 8));
    }


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        boolean[] visited = new boolean[candidates.length];

        Arrays.sort(candidates);

        return help(candidates, target, 0);
    }


    public List<List<Integer>> help(int[] candidates, int target, int start) {
        if (target == 0)
            return new ArrayList<List<Integer>>();
        if (target < 0)
            return null;

        List<List<Integer>> retlist = new ArrayList<>();
        for (int i = start; i < candidates.length; i++) {
            if(i>start && candidates[i]==candidates[i-1]){
                continue;
            }
            List<List<Integer>> list = help(candidates, target - candidates[i], i + 1);
            if (list != null && list.size() > 0) {
                for (List<Integer> l : list) {
                    l.add(candidates[i]);
                }
            } else if (list != null && target == candidates[i]) {
                List<Integer> temp = new ArrayList<>();
                temp.add(candidates[i]);
                list.add(temp);
            }

            if (list != null) {
                retlist.addAll(list);
            }
        }
        return retlist;
    }
}
