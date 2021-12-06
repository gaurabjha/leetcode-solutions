
/**
 * https://leetcode.com/problems/kth-missing-positive-number
 */
class FindKthPositive {
    public int findKthPositive(int[] arr, int k) {
        int positiveNaturalNumber = arr[0];
        int missingCount = arr[0] - 1;
        if (missingCount >= k) {
            return k;
        }
        for (int i = 1; i < arr.length; i++) {
            positiveNaturalNumber++;
            if (positiveNaturalNumber != arr[i]) {
                missingCount++;
                i--;
                if (missingCount == k) {
                    return positiveNaturalNumber;
                }
            }
        }
        return (positiveNaturalNumber) + (k - missingCount);
    }


    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 7, 11};
        int k = 5;
        FindKthPositive obj = new FindKthPositive();
        System.out.println("Output : " + obj.findKthPositive(arr, k));
    }
}


/*
    Success
            Details
Runtime: 0 ms, faster than 100.00% of Java online submissions for Kth Missing Positive Number.
        Memory Usage: 38.7 MB, less than 56.96% of Java online submissions for Kth Missing Positive Number.
        Next challenges:
        Maximum Product of Word Lengths
        Car Pooling
        Remove Sub-Folders from the Filesystem
        Show off your acceptance:
        Time Submitted
        Status
        Runtime
        Memory
        Language
        11/28/2021 23:01	Accepted	0 ms	38.7 MB	java
        11/28/2021 22:59	Wrong Answer	N/A	N/A	java
*/