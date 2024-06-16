package interview.metapblms;

import java.util.Random;

public class RandomPickwithWeight {

    class Solution {
        int[] arr;

        int sum = 0;

        Random random;

        public Solution(int[] w) {
            arr = new int[w.length];
            random = new Random();

            for (int i = 0; i < w.length; i++) {
                sum += w[i];
                arr[i] = sum;
            }
        }

        public int pickIndex() {

            int l = 0;
            int h = arr.length - 1;
            int ran = random.nextInt(sum) + 1;

            while (l <= h) {

                int mid = l + (h - l) / 2;
                if (arr[mid] == ran) {
                    l = mid;
                    break;
                } else if (arr[mid] < ran) {
                    l = mid + 1;
                } else {
                    h = mid - 1;
                }

            }

            return l;
        }
    }

    public static void main(String[] args) {
        RandomPickwithWeight r = new RandomPickwithWeight();
        int[] w = {1, 3};
        Solution solution = r.new Solution(w);
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());

    }
}
