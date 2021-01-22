import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/strange-printer-ii/
public class StrangePrinterII {


    public static void main(String[] args) {
        System.out.println(new StrangePrinterII().isPrintable(
                new int[][]{{1, 3}, {6, 9}}
        ));
    }

    public boolean isPrintable(int[][] targetGrid) {
        boolean[][] visited = new boolean[targetGrid.length][targetGrid[0].length];
        Map<Integer, Integer> printed = new HashMap<Integer, Integer>();
        int COLOR = 0;
        boolean colourChanged;

        return true;
    }

}

//        for (int i = 0; i < targetGrid.length; i++) {
//            for (int j = 0; j < targetGrid[i].length; j++) {
//                if (!(COLOR == targetGrid[i][j] || COLOR == 0)) {
//                    if (true) {// Color Change Logic Check)
//                        Integer colorCount = printed.get(COLOR);
//                        if (colorCount != null && colorCount != new Integer(1)) {
//                            return false;
//                        }
//                        printed.put(COLOR, 1);
//                    }
//                }
//                COLOR = targetGrid[i][j];
//                visited[i][j] = true;
//            }
//        }