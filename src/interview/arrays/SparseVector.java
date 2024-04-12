package interview.arrays;

public class SparseVector {


  int[] nums;


  SparseVector(int[] nums) {
    this.nums = nums;
  }

  // Return the dotProduct of two sparse vectors
  public int dotProduct(SparseVector vec) {
    int product = 0;
    for (int i = 0; i < vec.nums.length; i++) {
      if (vec.nums[i] != 0) {
        product += vec.nums[i] * nums[i];
      }
    }
    return product;
  }
}
