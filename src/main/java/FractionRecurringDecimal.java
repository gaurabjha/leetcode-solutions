import java.util.HashMap;
import java.util.Map;

public class FractionRecurringDecimal {
    //https://leetcode.com/problems/fraction-to-recurring-decimal/
    public static void main(String[] args) {

        //test  ^
//        System.out.println(!(1 > 0) ^ (1 > 0));
//        System.out.println(!(1 > 0) ^ (0 > 0));
//        System.out.println(!(0 > 0) ^ (1 > 0));
//        System.out.println(!(-1 > 0) ^ (-1 > 0));
        System.out.println(new FractionRecurringDecimal().fractionToDecimal(-33, -3));
    }

    public String fractionToDecimal(int numerator, int denominator) {
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        StringBuilder response = new StringBuilder();
        response.append(((numerator > 0) ^ (denominator > 0))  && numerator!=0 ? "-" : "");

        response.append(num / den);
        num %= den;

        if (num == 0)
            return response.toString();
        response.append(".");

        Map<Long, Integer> remainder = new HashMap<Long, Integer>();
        do {
            remainder.put(num, response.length());
            num *= 10;
            response.append(num / den);
            num %= den;
            Integer remainderIndex = remainder.get(num);
            if (remainderIndex != null) {
                response.insert(remainderIndex, "(");
                response.append(")");
                break;
            }
        }while (num > 0);
        return response.toString();

    }
}
