package interview.stacksandqueues;

import org.junit.Test;

import java.util.Set;
import java.util.Stack;

public class MaximumNestingDepthoftheParentheses_1614 {

    public int maxDepth(String s) {
        int ans = 0;
        int countOpen = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                countOpen++;
            } else if (s.charAt(i) == ')') {
                countOpen--;
            }

            ans = Math.max(ans, countOpen);
        }
        return ans;
    }


    @Test
    public void test() {
        System.out.println(maxDepth("(1+(2*3)+((8)/4))+1"));
    }


}
