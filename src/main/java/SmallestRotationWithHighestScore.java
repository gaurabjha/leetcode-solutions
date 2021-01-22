public class SmallestRotationWithHighestScore {
    public static void main(String[] args) {
        System.out.println(new SmallestRotationWithHighestScore().bestRotation(new int[]{2, 3, 1, 4, 0}));
        System.out.println(new SmallestRotationWithHighestScore().bestRotation2(new int[]{2, 4, 1, 3, 0}));
    }

    public int bestRotation(int[] A) {
        int K = 0, maxScore = 0;
        for (int rotation = 0; rotation < A.length; rotation++) {
            int score = 0;
            for (int i = 0; i < A.length; i++) {
                if (A[(i + rotation) % A.length] <= i) score++;
                System.out.println("i : " + i + " j : " + ((i + rotation) % A.length));
            }
            if (rotation == 0) {
                maxScore = score;
            } else if (score > maxScore) {
                maxScore = score;
                K = rotation;
            }
            System.out.println("score : " + score + " K : " + K);
            System.out.println();
        }
        return K;
    }

    public int bestRotation2(int[] A) {
        int K = 0, maxScore = 0;
        for (int rotation = 0; rotation < A.length; rotation++) {
            int score = 0;
            for (int i = 0; i < A.length; i++) if (A[(i + rotation) % A.length] <= i) score++;
            if (rotation == 0) maxScore = score;
            else if (score > maxScore) {
                maxScore = score;
                K = rotation;
            }
        }
        return K;
    }
}
