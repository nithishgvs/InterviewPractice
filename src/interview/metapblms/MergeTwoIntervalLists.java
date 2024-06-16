package interview.metapblms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeTwoIntervalLists {

    public static List<int[]> mergeIntervals(int[][] A, int[][] B) {
        // Step 1: Sort both lists based on the start of each interval
        Arrays.sort(A, Comparator.comparingInt(a -> a[0]));
        Arrays.sort(B, Comparator.comparingInt(a -> a[0]));

        // Step 2: Merge the sorted lists using a two-pointer technique
        List<int[]> merged = new ArrayList<>();
        int i = 0, j = 0;

        while (i < A.length && j < B.length) {
            if (A[i][0] < B[j][0]) {
                mergeOrAdd(merged, A[i++]);
            } else {
                mergeOrAdd(merged, B[j++]);
            }
        }

        // Process remaining intervals in A
        while (i < A.length) {
            mergeOrAdd(merged, A[i++]);
        }

        // Process remaining intervals in B
        while (j < B.length) {
            mergeOrAdd(merged, B[j++]);
        }

        return merged;
    }

    private static void mergeOrAdd(List<int[]> merged, int[] interval) {
        if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]) {
            merged.add(interval);
        } else {
            int[] lastInterval = merged.get(merged.size() - 1);
            lastInterval[1] = Math.max(lastInterval[1], interval[1]);
        }
    }

    public static void main(String[] args) {
        int[][] A = { {10, 14}, {1, 5}, {16, 18} };
        int[][] B = { {8, 10}, {11, 20}, {2, 6} };

        List<int[]> result = mergeIntervals(A, B);

        for (int[] interval : result) {
            System.out.print("[" + interval[0] + "," + interval[1] + "] ");
        }
        // Output: [1,6] [8,20]
    }
}
