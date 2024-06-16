package interview.metapblms;

public class MergeSortedArray {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int totalIndex = m + n - 1;
        int nums2Index = n - 1;
        int nums1Index = m - 1;

        while (nums2Index > -1) {
            if (nums1Index > -1 && nums1[nums1Index] > nums2[nums2Index]) {
                nums1[totalIndex] = nums1[nums1Index];
                totalIndex--;
                nums1Index--;
            } else {
                nums1[totalIndex] = nums2[nums2Index];
                totalIndex--;
                nums2Index--;
            }
        }

    }

    public static void main(String[] args) {
        //merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
        merge(new int[]{0}, 0, new int[]{1}, 1);
    }
}
