public class LongestContinuousIncreasingSubsequence {
    //https://leetcode.com/problems/longest-continuous-increasing-subsequence/
    public static void main(String[] args) {
        System.out.println(new LongestContinuousIncreasingSubsequence().findLengthOfLCIS(
                new int[]{1, 3, 5, 4, 7}
        ));
    }

    public int findLengthOfLCIS(int[] nums) {
        int count = 0, subArrayCount = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1])
                subArrayCount++;
            else {
                count = Math.max(subArrayCount + 1, count);
                subArrayCount = 1;
            }
        }
        return count;
    }
}
