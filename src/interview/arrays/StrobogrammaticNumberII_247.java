package interview.arrays;

import java.util.ArrayList;
import java.util.List;

public class StrobogrammaticNumberII_247 {


    public List<String> findStrobogrammatic(int n) {

        /**
         *Time Complexity: O(5 n/2)
         * This is because, at each recursive step, there are up to 5 choices, and the recursion
         * proceeds to a depth of n/2.
         * Space Complexity: O(5 n/2)
         * Dominated by the storage of the result list.
         * The auxiliary space for the recursion stack is O(n).
         */
        findStrobogrammaticHelper(new char[n], 0, n - 1);
        return res;
    }

    List<String> res = new ArrayList<String>();

    public void findStrobogrammaticHelper(char[] a, int l, int r) {
        if (l > r) {
            res.add(new String(a));
            return;
        }
        if (l == r) {
            a[l] = '0'; res.add(new String(a));
            a[l] = '1'; res.add(new String(a));
            a[l] = '8'; res.add(new String(a));
            return;
        }

        if (l != 0) {
            a[l] = '0'; a[r] = '0';
            findStrobogrammaticHelper(a, l+1, r-1);
        }
        a[l] = '1'; a[r] = '1';
        findStrobogrammaticHelper(a, l+1, r-1);
        a[l] = '8'; a[r] = '8';
        findStrobogrammaticHelper(a, l+1, r-1);
        a[l] = '6'; a[r] = '9';
        findStrobogrammaticHelper(a, l+1, r-1);
        a[l] = '9'; a[r] = '6';
        findStrobogrammaticHelper(a, l+1, r-1);
    }

    public static void main(String[] args) {
        StrobogrammaticNumberII_247 obj=new StrobogrammaticNumberII_247();
        System.out.println(obj.findStrobogrammatic(4));
    }
}
