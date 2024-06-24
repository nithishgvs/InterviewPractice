package interview.stacksandqueues;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Stack;

public class DecodeString_394 {


    public String decodeString(String s) {

        Stack<String> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        // StringBuilder to accumulate the result
        StringBuilder result = new StringBuilder();

        // Iterate over each character in the input string
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == ']') {
                // Handle closing bracket
                // Build the substring from stack1 until we encounter '['
                StringBuilder temp = new StringBuilder();
                while (!stack1.isEmpty() && !stack1.peek().equals("[")) {
                    temp.insert(0, stack1.pop());
                }
                // Remove the '[' from the stack
                stack1.pop();

                // Get the number of repetitions from stack2
                int repeatTimes = stack2.pop();

                // Create the repeated string
                String repeatedSegment = temp.toString().repeat(repeatTimes);

                // Push the repeated segment back to stack1
                stack1.push(repeatedSegment);
            } else if (Character.isDigit(ch)) {
                // Handle digits to form the full number
                int number = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    number = number * 10 + (s.charAt(i) - '0');
                    i++;
                }
                i--; // Adjust the index after exiting the while loop
                // Push the number onto stack2
                stack2.push(number);
            } else {
                // Handle alphabets and opening brackets
                stack1.push(ch + "");
            }
        }

        // Combine all elements from stack1 to form the final result
        while (!stack1.isEmpty()) {
            result.insert(0, stack1.pop());
        }

        return result.toString();
    }

    @Test
    public void test() {
        System.out.println(decodeString("13[a]2[bc]"));
    }
}
