package hot100;

import java.util.Arrays;
import java.util.HashMap;

//560. 和为K的子数组
public class SubarraySum {
    public static void main(String[] args) {
        int[] nums = {1,1,1};
        System.out.println(new SubarraySum().hahsway(nums, 1));
    }


    public int subarraySum(int[] nums, int k) {
        int[] sumarr = new int[nums.length];

        int csum = 0;
        for(int i=0;i<nums.length;i++){
            csum += nums[i];
            sumarr[i] = csum;
        }

        int count = 0;
        for(int i=0;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){
                if(sumarr[j] - sumarr[i] + nums[i] == k){
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * hash={0:1}
     * sum=0
     * count=0
     * for i in range(len(nums)):
     *     sum+=nums[i]
     *     if((sum-k) in hash):
     *         count+=hash[sum-k]
     *     if(sum in hash):
     *         hash[sum]+=1
     *     else:
     *         hash[sum]=1
     * return count
     * @param nums
     * @param k
     * @return
     */
    public int hahsway(int[] nums, int k){
        // 累计和、出现次数
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, 1); // 初始化
        int csum = 0;
        int count = 0;
        for(int i=0;i<nums.length;i++){
            csum += nums[i];
            if(hashMap.containsKey(csum-k)){
                count += hashMap.get(csum - k);
            }

            hashMap.put(csum, hashMap.getOrDefault(csum, 0) + 1);
        }
        return count;
    }
}
