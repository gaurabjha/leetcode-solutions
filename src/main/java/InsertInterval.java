import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/insert-interval/
public class InsertInterval {
    public static final int START = 0;
    public static final int END = 1;
    
    public static void main(String[] args) {
        int[][] response = new InsertInterval().insert(
                new int[][]{{1, 3}, {6, 9}},
                new int[]{2, 5}
        );
        System.out.println();
        for (int[] interval : response) {
            System.out.print("[");
            for (int range : interval)
                System.out.print(" " + range + " ");
            System.out.println("]");
        }
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> response = new ArrayList<int[]>();
        int intervalIndex = 0;
        //Add all intervals before the new Interval
        while (intervalIndex < intervals.length && intervals[intervalIndex][END] < newInterval[START]) {
            response.add(intervals[intervalIndex++]);
        }

        // Create the new Interval from Existing Intervals
        while (intervalIndex < intervals.length && intervals[intervalIndex][START] <= newInterval[END]) {
            newInterval[0] = Math.min(intervals[intervalIndex][START], newInterval[START]);
            newInterval[1] = Math.max(intervals[intervalIndex++][END], newInterval[END]);
        }
        response.add(newInterval);

        //Add all intervals after the new Interval
        while (intervalIndex < intervals.length)
            response.add(intervals[intervalIndex++]);
        return response.toArray(new int[0][]);
    }
}
