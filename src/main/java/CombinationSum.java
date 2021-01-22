import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/combination-sum/discuss/16502/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning)
//https://leetcode.com/problems/longest-continuous-increasing-subsequence/
public class CombinationSum {
    public static void main(String[] args) {
        System.out.println(new CombinationSum().combinationSum(new int[]{2, 3, 6, 7}, 7));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> response = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        for (int candidate : candidates) {
            if (candidate <= target) {
                if (candidate == target) {
                    response.add(new ArrayList<>(candidate));
                } else {
                    //logic to get the permutations and combinations

                }
            }
        }
        return response;
    }
}
