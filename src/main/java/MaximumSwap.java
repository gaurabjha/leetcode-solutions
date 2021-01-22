public class MaximumSwap {
    //https://leetcode.com/problems/maximum-swap/
    public static void main(String[] args) {
        System.out.println(new MaximumSwap().maximumSwap(2736));
    }

    public int maximumSwap(int num) {
        char digits[] = String.valueOf(num).toCharArray();
        int i = 0, j, maxInd = 0;
        char temp = 0;

        while (i < digits.length) {
            j = i + 1;
            while (j < digits.length) {
                if (digits[i] < digits[j] && temp <= digits[j]) {
                    maxInd = j;
                    temp = digits[j];
                }
                j++;
            }
            if (maxInd > 0) {
                //swap the bumber
                temp = digits[i];
                digits[i] = digits[maxInd];
                digits[maxInd] = temp;
                break;
            }
            i++;
        }
        return Integer.valueOf(new String(digits));
    }
}
