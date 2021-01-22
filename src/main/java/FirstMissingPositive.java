import java.util.HashSet;
import java.util.Set;

public class FirstMissingPositive {
    //https://leetcode.com/problems/first-missing-positive/
    // hard??

    public static void main(String[] args) {
        System.out.println(new FirstMissingPositive().firstMissingPositive(new int[]{4, 2, 1}));
    }

    public int firstMissingPositive2(int[] nums) {
        boolean found;
        Set<Integer> numbersFound = new HashSet<Integer>();
        for (int i = 1; ; i++) {
            if (numbersFound.contains(i))
                continue;
            int j = 0;
            found = false;
            while (j < nums.length) {
                if (nums[j] == i) {
                    found = true;
                    break;
                } else
                    numbersFound.add(nums[j]);
                j++;
            }
            if (!found)
                return i;
        }
    }

    public int firstMissingPositive(int[] nums) {
        boolean found;
        for (int i = 1; ; i++) {
            found = false;
            for (int j : nums)
                if (j == i) {
                    found = true;
                    break;
                }
            if (!found) return i;
        }
    }
}
