package interview.arrays;

import java.util.Map;

public class StrobogrammaticNumber_246 {

    public boolean isStrobogrammatic(String num) {

        Map<Character, Character> map = Map.of('6', '9', '9', '6', '8', '8', '0', '0', '1', '1');

        int l = 0, h = num.length() - 1;

        while (l <= h) {

            if (!map.containsKey(num.charAt(l))) {
                return false;
            }
            if (map.get(num.charAt(l)) != num.charAt(h)) {
                return false;
            }

            l++;
            h--;
        }


        return true;

    }
}
