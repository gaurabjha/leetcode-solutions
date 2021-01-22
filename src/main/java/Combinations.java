import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> response = new ArrayList<List<Integer>>();

        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                response.add(Arrays.asList(i, j));
            }
        }
        return response;
    }
}