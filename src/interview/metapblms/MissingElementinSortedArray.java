package interview.metapblms;

public class MissingElementinSortedArray {

    public static int missingElement(int[] nums, int k) {

        int l = 0, h = nums.length - 1;
        int missingElement;

        while (l <= h) {
            int mid = l + (h - l) / 2;

            missingElement = nums[mid] - (nums[0] + mid);

            if (missingElement < k) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }

        missingElement = k - (nums[h] - (nums[0] + h));

        return nums[h] + missingElement;
    }

    public static void main(String[] args) {
        int[] nums = {4, 7, 9, 10};
        System.out.println(missingElement(nums, 3));
    }
}
