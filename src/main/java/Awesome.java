import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * https://leetcode.com/problems/find-longest-awesome-substring/
 */

public class Awesome {

    public static int longestAwesome(String s) {
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {

        }
        return answer;
    }

    public int longestAwesome2(String s) {
        AtomicInteger answer = new AtomicInteger();
        Map<Character, Integer> charCounter = new HashMap<Character, Integer>();
        s.chars().mapToObj(c -> (char) c).map(x -> charCounter.containsKey(x) ? charCounter.get(x) + 1 : 1);
        charCounter.values().stream().(value -> answer += ((value / 2) * 2));
        if (answer.get() < s.length()) answer.getAndIncrement();
        return answer.get();
    }

    public static void main(String[] args) {
        String s = "9498331";
        System.out.println(Awesome.longestAwesome(s));
    }
}
