package interview.metapblms;

import java.util.HashMap;
import java.util.Map;

public class WindowSum {

    /**
     * Given array of nums, return an array of the running sum divided by window length k.
     * (i.e. nums = [1, 2, 3, 4, 5], k = 3 => [2, 3, 4]
     */

    static int[] windowSum(int[] nums, int k) {

        int[] result = new int[nums.length - k + 1];

        int index = 0;

        Map<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0, 0);
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            prefixSum.put(i + 1, sum);
            if (i + 1 >= k) {
                result[index++] = (prefixSum.get(i+1) - prefixSum.get(i+1 - k)) / 3;
            }
        }


        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        windowSum(nums, 3);
    }
}
