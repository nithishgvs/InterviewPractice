package interview.binarysearch;

import org.junit.Test;

public class FindLocalMinima {


  public int findLocalMinima(int[] arr, int start, int end) {
    //determines the mid element of the array
    int mid = start + (end - start) / 2;
    //detemines the length of the array
    int size = arr.length;
    //checks if there is mid element or not and their neighor exist or not
    if ((mid == 0 || arr[mid - 1] > arr[mid]) && (mid == size - 1 || arr[mid + 1] > arr[mid]))
    //if mid element exists returns the mid element of the array
    {
      return arr[mid];
    }
    //checks if left neighbor is less than mid element, if yes traverse to left
    else if (mid > 0 && arr[mid] > arr[mid - 1]) {
      return findLocalMinima(arr, start, mid);
    } else {
      //if(mid<size-1 && arrA[mid]>arrA[mid+1])
      return findLocalMinima(arr, mid + 1, end);
    }
  }

  @Test
  public void test() {
    int[] nums = {17, 12, 6, 18, 9, 2, 1};
    System.out.println(findLocalMinima(nums, 0, nums.length - 1));
  }


}
