package interview.metapblms;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    public static int subarraySum(int[] nums, int k) {

        int count = 0;

        Map<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }


        return count;

    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(subarraySum(nums, 3));
    }
}
