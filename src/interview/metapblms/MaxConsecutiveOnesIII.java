package interview.metapblms;

public class MaxConsecutiveOnesIII {


    public static int longestOnes(int[] nums, int k) {

        int result = 0;

        int left = 0;

        int start = 0;

        int zeroes = 0;

        while (start < nums.length) {

            if (nums[start] == 0) {
                zeroes++;
            }
            while (zeroes > k) {
                if (nums[left] == 0) {
                    zeroes--;
                }
                left++;
            }
            result = Math.max(result, start - left + 1);
            start++;
        }

        return result;
    }

    public static void main(String[] args) {
        longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2);
    }
}
