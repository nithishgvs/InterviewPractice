package interview.metapblms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductofTwoRunLengthEncodedArrays {

    public static List<List<Integer>> findRLEArray(int[][] encoded1, int[][] encoded2) {

        List<List<Integer>> result = new ArrayList<>();

        int ptr1 = 0;
        int ptr2 = 0;

        while (ptr1 < encoded1.length && ptr2 < encoded2.length) {

            int min = Math.min(encoded1[ptr1][1], encoded2[ptr2][1]);
            int value = encoded1[ptr1][0] * encoded2[ptr2][0];
            if (!result.isEmpty() && result.get(result.size() - 1).get(0) == value) {
                result.set(result.size() - 1, Arrays.asList(value, min + result.get(result.size() - 1).get(1)));
            } else {
                result.add(Arrays.asList(value, min));
            }

            if (encoded1[ptr1][1] == min && encoded2[ptr2][1] == min) {
                ptr1++;
                ptr2++;
            } else if (encoded1[ptr1][1] > min) {
                encoded1[ptr1][1] -= min;
                ptr2++;
            } else if (encoded2[ptr2][1] > min) {
                encoded2[ptr2][1] -= min;
                ptr1++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        findRLEArray(new int[][]{{1, 3}, {2, 1}, {3, 2}}, new int[][]{{2, 3}, {3, 3}});
    }
}
