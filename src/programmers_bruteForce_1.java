import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class programmers_bruteForce_1 {
    public static void main(String[] args) {
        programmers_bruteForce_1 p = new programmers_bruteForce_1();
        System.out.println(Arrays.toString(p.solution(new int[]{1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(p.solution(new int[]{1, 2, 3, 4, 5, 1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(p.solution(new int[]{1, 3, 2, 4, 2})));
    }

    public int[] solution(int[] answers) {
        int[] a = new int[]{1, 2, 3, 4, 5};
        int[] b = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] scores = new int[]{0, 0, 0};

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == a[i % a.length]) scores[0]++;
            if (answers[i] == b[i % b.length]) scores[1]++;
            if (answers[i] == c[i % c.length]) scores[2]++;
        }
        int max = Arrays.stream(scores).max().getAsInt();
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (scores[i] == max) {
                answer.add(i + 1);
            }
        }
        return answer.stream().mapToInt(i -> i).toArray();

    }
}
