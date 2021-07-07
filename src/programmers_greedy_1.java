import java.util.Arrays;
import java.util.List;

public class programmers_greedy_1 {

    public static void main(String[] args) {
        programmers_greedy_1 p = new programmers_greedy_1();

        System.out.println(p.solution(5, new int[]{2, 4}, new int[]{1, 3, 5}));
        System.out.println(p.solution(5, new int[]{2, 4}, new int[]{3}));
        System.out.println(p.solution(3, new int[]{3}, new int[]{1}));
    }

    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        int[] uniforms = new int[n];
        for (int l : lost) {
            uniforms[l - 1] -= 1;
        }
        for (int r : reserve) {
            uniforms[r - 1] += 1;
        }

        for (int i = 0; i < n; i++) {
            if (i != 0) {
                // left
                if (uniforms[i - 1] < 0 && uniforms[i] > 0) {
                    uniforms[i - 1] += 1;
                    uniforms[i] -= 1;
                }
            }
            if (i != n - 1) {
                // right
                if (uniforms[i + 1] < 0 && uniforms[i] > 0) {
                    uniforms[i + 1] += 1;
                    uniforms[i] -= 1;
                }
            }
        }

        for (int i : uniforms) {
            if (i >= 0) {
                answer += 1;
            }
        }

        return answer;
    }

}
