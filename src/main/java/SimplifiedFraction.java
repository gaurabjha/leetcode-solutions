import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/simplified-fractions/
class SimplifiedFraction {
    public static void main(String[] args) {
        System.out.println(new SimplifiedFraction().simplifiedFractions(4));
    }

    public List<String> simplifiedFractions(int n) {
        List<String> fractions = new ArrayList<String>();
        for (int denominator = 2; denominator <= n; denominator++) {
            for (int numerator = 1; numerator < denominator; numerator++) {
                if (gcd(numerator, denominator) == 1)
                    fractions.add(numerator + "/" + denominator);
            }
        }
        return fractions;
    }
    private int gcd(int x, int y) {
        return x == 0 ? y : gcd(y % x, x);
    }
}
