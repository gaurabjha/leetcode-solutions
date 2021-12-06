/**
 * https://leetcode.com/problems/minimum-insertions-to-balance-a-parentheses-string/
 */
public class BalancedParanthesis {
    public int minInsertions(String s) {
        int answer = 0;
        int open = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                open++;
            }
            if (s.charAt(i) == ')') {
                if (open > 0) {
                    open--;
                } else
                    answer++;

                //check if the ) is followed by )
                if ((i + 1 < s.length()) && s.charAt(i + 1) == ')') {
                    i++;
                } else
                    answer++;
            }
        }
        return answer + (2 * open);
    }

    public static void main(String[] args) {
        String s = "))())(";
        BalancedParanthesis solution = new BalancedParanthesis();
        System.out.println("Answer : " + solution.minInsertions(s));
    }

}


/**
 * Success
 * Details
 * Runtime: 11 ms, faster than 51.71% of Java online submissions for Minimum Insertions to Balance a Parentheses String.
 * Memory Usage: 39.3 MB, less than 93.66% of Java online submissions for Minimum Insertions to Balance a Parentheses String.
 * Next challenges:
 * Minimum Number of Swaps to Make the String Balanced
 * Show off your acceptance:
 * Time Submitted
 * Status
 * Runtime
 * Memory
 * Language
 * 11/29/2021 00:18	Accepted	11 ms	39.3 MB	java
 */