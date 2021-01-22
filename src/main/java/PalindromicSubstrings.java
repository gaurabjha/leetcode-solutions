public class PalindromicSubstrings {

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        System.out.println(new PalindromicSubstrings().countSubstrings("aabaaca"));
        long stopTime = System.nanoTime();
        System.out.println(stopTime - startTime);
    }

    public int countSubstrings(String s) {
        int count = 0;
        int matrix[][] = new int[s.length()][s.length()];


        for (int column = 0; column < s.length(); column++) {
            for (int row = 0; row <= column; row++) {
                if (s.charAt(column) == s.charAt(row)) {
                    //matrix[row][column] = (((column - row) >= 2) && (matrix[row + 1][column - 1] != 0)) ? 1 : 1;
                    if ((column - row) >= 2) {
                        if (column == row) {
                            matrix[row][column] = 1;
                        } else if (matrix[row + 1][column - 1] == 1) {
                            matrix[row][column] = 1;
                        }
                    }
                    if (matrix[row][column] == 1)
                        count++;
                }
                System.out.print("matrix[" + row + "][" + column + "] ");
            }
            System.out.println();
        }
        return count;
    }
}
