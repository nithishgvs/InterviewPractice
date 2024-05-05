package interview.salesforce;

public class SearchinaSortedArrayofUnknownSize_702 {

  class ArrayReader {

    public int get(int index) {
      return -1;
    }
  }

  public int search(ArrayReader reader, int target) {

    //Max possible Index would be target-minValue(reader.get(0))

    int minValue = reader.get(0);
    if (target < minValue) {
      return -1;
    }

    int h = target - minValue;

    int l = 0;

    while (l <= h) {

      int mid = l + (h - l) / 2;

      if (reader.get(mid) == target) {
        return mid;
      } else if (reader.get(mid) > target) {
        h = mid - 1;
      } else {
        l = mid + 1;
      }
    }

    return -1;
  }

}
