package interview.metapblms;

import org.junit.Test;

public class MultiplyStrings {

    public String multiply(String num1, String num2) {

        int[] result = new int[num1.length() + num2.length()];

        for (int i = num1.length() - 1; i > -1; i--) {
            for (int j = num2.length() - 1; j > -1; j--) {
                // Convert characters to their integer values.
                int digit1 = num1.charAt(i) - '0';
                int digit2 = num2.charAt(j) - '0';

                // Calculate the product of these two digits.
                int mulValue = digit1 * digit2;

                // Calculate the indices in the result array.
                int moduloIndex = i + j + 1;
                int remainderIndex = i + j;

                // Add the product to the result at the corresponding position.
                // Also add any existing value at moduloIndex to handle carry-over from previous iterations.
                int sum = mulValue + result[moduloIndex];

                // Update the current position with the new digit (modulo 10).
                result[moduloIndex] = sum % 10;

                // Carry over the remainder to the next left position.
                result[remainderIndex] += sum / 10;
            }
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < result.length; i++) {
            if (stringBuilder.isEmpty() && result[i] == 0)
                continue;

            stringBuilder.append(result[i]);
        }

        return stringBuilder.toString();

    }

    @Test
    public void test() {
        System.out.println(multiply("1", "2"));
    }
}
