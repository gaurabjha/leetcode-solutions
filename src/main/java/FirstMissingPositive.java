public class FirstMissingPositive {
    //https://leetcode.com/problems/first-missing-positive/
    // hard??

    public static void main(String[] args) {
        System.out.println(new FirstMissingPositive().firstMissingPositive(new int[]{4, 2, 1}));
    }

    public int firstMissingPositive(int[] nums) {
        boolean found;
        for (int i = 1; ; i++) {
            int j = 0;
            found = false;
            while (j < nums.length) {
                if (nums[j] == i) {
                    found = true;
                    break;
                }
                j++;
            }
            if (!found)
                return i;
        }
    }
}
