package interview.arrays;

import java.util.HashMap;
import java.util.Map;

public class RangeSumQueryImmutable_303 {


    class NumArray {

        Map<Integer, Integer> prefixSumMap;

        public NumArray(int[] nums) {
            prefixSumMap = new HashMap<>();
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                prefixSumMap.put(i, sum);
            }
        }

        public int sumRange(int left, int right) {
            int leftSum = prefixSumMap.getOrDefault(left - 1, 0);
            return prefixSumMap.get(right) - leftSum;
        }
    }

    public static void main(String[] args) {
        RangeSumQueryImmutable_303 obj = new RangeSumQueryImmutable_303();
        int[] nums = new int[]{-2, 0, 3, -5, 2, -1};
        NumArray numArray = obj.new NumArray(nums);
        System.out.println(numArray.sumRange(0, 2));
        System.out.println(numArray.sumRange(2, 5));
        System.out.println(numArray.sumRange(0, 5));
    }
}
