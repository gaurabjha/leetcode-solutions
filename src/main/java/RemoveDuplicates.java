public class RemoveDuplicates {
    public static void main(String[] args) {
        System.out.println(new RemoveDuplicates.Solution().removeDuplicates("yfttttfbbbbnnnnffbgffffgbbbbgssssgthyyyy", 4));
        System.out.println(new RemoveDuplicates.Solution().removeDuplicates2("yfttttfbbbbnnnnffbgffffgbbbbgssssgthyyyy", 4));
        System.out.println(new RemoveDuplicates.Solution().removeDuplicates3("yfttttfbbbbnnnnffbgffffgbbbbgssssgthyyyy", 4));
    }

    static class Solution {

        public String removeDuplicates(String s, int k) {
            String updatedString = s;

            int i = 0;
            while (true) {
                if (i + k > updatedString.length())
                    break;
                System.out.println(i + " " + updatedString.length() + " " + updatedString + "  " + updatedString.substring(i, i + k));
                boolean matching = updatedString.charAt(i) == updatedString.charAt(i + 1);
                for (int m = 2; m < k; m++) {
                    if (matching) {
                        matching = updatedString.charAt(i) == updatedString.charAt(i + m);
                    }
                }
                if (matching) {
                    updatedString = updatedString.substring(0, i) + updatedString.substring(i + k);
                } else
                    i++;
            }
            if (s.equalsIgnoreCase(updatedString)) {
                return updatedString;
            } else {
                return removeDuplicates(updatedString, k);
            }
        }

        public String removeDuplicates2(String s, int k) {
            int i = 0, count = 0;
            char response[] = new char[s.length()];
            for (char c : s.toCharArray()) {
                response[i] = c;
                count = i > 0 && response[i] == response[i - 1] ? count + 1 : 1;
                if (count == k) {
                    i -= k;
                    count = 1;
                }
                i += 1;
                System.out.println("i : " + i +" count : " + count + " : " + new String(response, 0, i));
            }
            return new String(response, 0, i);
        }
        public String removeDuplicates3(String s, int k) {
            int i = 0, n = s.length(), count[] = new int[n];
            char[] stack = s.toCharArray();
            for (int j = 0; j < n; ++j, ++i) {
                stack[i] = stack[j];
                count[i] = i > 0 && stack[i - 1] == stack[j] ? count[i - 1] + 1 : 1;
                if (count[i] == k) i -= k;
                System.out.println("i : " + i +" count : " + count[i] + " : " + new String(stack, 0, i));

            }
            return new String(stack, 0, i);
        }
    }
}
