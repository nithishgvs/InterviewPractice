package interview.metapblms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MissingRanges {

    public static List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        List<List<Integer>> result = new ArrayList<>();

        int lowerBound = lower;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != lowerBound) {
                result.add(Arrays.asList(lowerBound, nums[i] - 1));
            }
            lowerBound = nums[i] + 1;
        }

        if (lowerBound <= upper) {
            result.add(Arrays.asList(lowerBound, upper));
        }


        return result;

    }

    public static void main(String[] args) {
        findMissingRanges(new int[]{}, 1, 1);
    }
}
