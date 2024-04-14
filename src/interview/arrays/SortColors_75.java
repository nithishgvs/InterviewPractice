package interview.arrays;

import org.junit.Test;

public class SortColors_75 {

  //https://www.youtube.com/watch?v=BOt1DAvR0zI
  //Dutch National Flag
  public void sortColors(int[] nums) {
    int l = 0;
    int mid = 0;
    int h = nums.length - 1;

    while (mid <= h) {
      int num = nums[mid];

      switch (num) {
        case 0:
          swapNums(l, mid, nums);
          l++;
          mid++;
          break;
        case 1:
          mid++;
          break;
        case 2:
          swapNums(mid,h,nums);
          h--;
          break;
      }
    }
  }

  private void swapNums(int l, int mid, int[] nums) {
    int tmp = nums[l];
    nums[l] = nums[mid];
    nums[mid] = tmp;
  }

  @Test
  public void test(){
    int[] nums={2,0,2,1,1,0};
    sortColors(nums);
  }


}
