package interview.metapblms;

public class MinimumAddtoMakeParenthesesValid {

    public int minAddToMakeValid(String s) {

        int min = 0;

        int openCount = 0;

        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == '(')
                openCount++;

            else if (arr[i] == ')') {
                if (openCount > 0) {
                    openCount--;
                } else {
                    arr[i] = '*';
                }
            }
        }

        for (int i = arr.length - 1; i > -1 && openCount > 0; i--) {
            if (arr[i] == '(') {
                openCount--;
                arr[i] = '*';
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '*')
                min++;
        }


        return min;

    }
}
