package interview.arrays;

import org.junit.Test;

import java.util.TreeMap;

public class MaximizeGreatnessofanArray_2592 {

    public int maximizeGreatness(int[] nums) {

        int count = 0;

        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int num : nums) {
            Integer key = map.ceilingKey(num + 1);

            if (key != null && key.intValue() > num) {
                count++;
                map.put(key.intValue(), map.get(key.intValue()) - 1);
                if (map.get(key.intValue()) == 0) {
                    map.remove(key.intValue());
                }
            }
        }


        return count;

    }


    @Test
    public void test() {
        int[] nums = {1,2,3,4};
        System.out.println(maximizeGreatness(nums));
    }
}
