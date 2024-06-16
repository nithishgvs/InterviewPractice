package interview.metapblms;

public class KthMissingPositiveNumber {

    public static int findKthPositive(int[] arr, int k) {

        int n = arr.length;
        int start = 0;
        int end = n-1;

        while(start <= end){
            int mid = start + (end - start)/2;
            if(arr[mid] - (mid+1) < k){
                start = mid+1;
            }else {
                end = mid-1;
            }
        }
        return start + k;

    }


    public static void main(String[] args) {
        int[] nums = {1, 2};
        System.out.println(findKthPositive(nums, 1));
    }
}
