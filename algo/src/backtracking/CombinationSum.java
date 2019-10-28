package backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
//        int[] candidates = {2, 3, 5};
        System.out.println(new CombinationSum().combinationSum(candidates, 7));
    }


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        return help(candidates, target, 0);
    }


    public List<List<Integer>> help(int[] candidates, int target, int start) {

        if (target == 0) {
            return new ArrayList<List<Integer>>();
        }

        if (target < 0) {
            return null;
        }

        List<List<Integer>> retlist = new ArrayList<>();

        for (int i = start; i < candidates.length; i++) {

            List<List<Integer>> list = help(candidates, target - candidates[i], start=i);
            if (list != null && list.size() > 0) {
                for (List<Integer> l : list) {
                    l.add(candidates[i]);
                }
            } else if (list != null && target==candidates[i]) {
                List<Integer> temp = new ArrayList<>();
                temp.add(candidates[i]);
                list.add(temp);
            }

            if(list != null) {
                retlist.addAll(list);
            }
        }

        return retlist;
    }
}
