package hot100;

/**
 * 494 目标和
 */
public class FindTargetSumWays {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
//        int[] nums = {};
        System.out.println(new FindTargetSumWays().findTargetSumWays(nums, 3));
    }

    public int findTargetSumWays(int[] nums, int S) {

        return help(nums, S, 0);
    }


    public int help(int[] nums, int S, int start) {
        if (start == nums.length) {
            if (S == 0) {
                return 1;
            } else {
                return 0;
            }
        }

        return help(nums, S - nums[start], start + 1) + help(nums, S + nums[start], start + 1);

    }
}
