public class MinimumNumberIncrementsSubarrays {
    //https://leetcode.com/problems/minimum-number-of-increments-on-subarrays-to-form-a-target-array/
    public static void main(String[] args) {
        System.out.println(new MinimumNumberIncrementsSubarrays().minNumberOperations(new int[]{1, 2, 3, 2, 1}));
    }

    public int minNumberOperations(int[] target) {
        int count = target[0];
        for (int i = 1; i < target.length; i++)
            count += Math.max(target[i] - target[i - 1], 0);
        return count;
    }
}
