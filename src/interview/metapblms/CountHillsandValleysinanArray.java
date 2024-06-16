package interview.metapblms;

public class CountHillsandValleysinanArray {

    public int countHillValley(int[] nums) {
        int temp = nums[0];
        int count = 0;
        int len = nums.length - 1;

        for (int i = 1; i < len; i++) {

            while (i < len && nums[i] == nums[i + 1]) {
                i++;
            }

            if (i < len && hillsValleys(temp, nums[i], nums[i + 1])) {
                count++;
                temp = nums[i];
            }

        }

        return count;

    }

    private boolean hillsValleys(int left, int middle, int right) {

        if (left > middle && right > middle) {
            return true;
        }
        if (left < middle && right < middle) {
            return true;
        }

        return false;
    }
}
