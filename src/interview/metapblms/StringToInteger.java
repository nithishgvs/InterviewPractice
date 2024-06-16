package interview.metapblms;

public class StringToInteger {

    public static int myAtoi(String s) {

        double result = 0;

        s = s.trim();

        int index = 0;

        boolean isNegative = false;

        if (s.startsWith("-") || s.startsWith("+")) {
            index++;
            if (s.startsWith("-")) {
                isNegative = true;
            }
        }

        while (index < s.length()) {

            char ch = s.charAt(index);

            if (!Character.isDigit(ch)) {
                break;
            }

            result = result * 10 + ch - '0';
            index++;
        }

        result = isNegative ? -1 * result : result;
        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }


        return (int) result;

    }

    public static void main(String[] args) {
        System.out.println(myAtoi("  -0012a42"));
    }
}
