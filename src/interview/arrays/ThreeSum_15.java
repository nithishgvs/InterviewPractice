package interview.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_15 {

  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 2; i++) {
      int sum = 0 - nums[i];
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }
      List<List<Integer>> currentList = twoSum(nums, sum, i + 1, nums.length - 1, nums[i]);
      result.addAll(currentList);
    }
    return result;
  }


  public List<List<Integer>> twoSum(int[] numbers, int target, int start, int end,
      int currentElement) {
    List<List<Integer>> tempList = new ArrayList<>();
    while (start < end) {
      int sum = numbers[start] + numbers[end];
      if (sum == target) {
        List<Integer> list = new ArrayList<>();
        list.add(currentElement);
        list.add(numbers[start]);
        list.add(numbers[end]);
        tempList.add(list);
        while (start < end && numbers[start] == numbers[start + 1]) {
          start++;
        }

        while (start < end && numbers[end] == numbers[end - 1]) {
          end--;
        }
        start++;
        end--;
      } else if (sum > target) {
        end--;
      } else {
        start++;
      }

    }
    return tempList;
  }
}
