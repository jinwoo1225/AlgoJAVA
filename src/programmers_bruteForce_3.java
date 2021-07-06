import java.util.Arrays;

public class programmers_bruteForce_3 {
    public static void main(String[] args) {
        programmers_bruteForce_3 p = new programmers_bruteForce_3();

        System.out.println(Arrays.toString(p.solution(10, 2)));
        System.out.println(Arrays.toString(p.solution(8, 1)));
        System.out.println(Arrays.toString(p.solution(24, 24)));

    }


    public int[] solution(int brown, int yellow) {
        int y = 0, x = 0;
        int carpetSize = brown + yellow;

        for (int i = 1; i < yellow + 1; i++) {
            y = i;
            if (yellow % y != 0) continue;
            x = yellow / y;
            if ((y + 2) * (x + 2) == carpetSize) break;
        }
        return new int[]{x + 2, y + 2};
    }
}
