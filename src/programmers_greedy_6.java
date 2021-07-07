import java.util.Arrays;
import java.util.Comparator;

public class programmers_greedy_6 {
    public static void main(String[] args) {
        programmers_greedy_6 p = new programmers_greedy_6();

        System.out.println(p.solution(new int[][]{{-20,15}, {-14,-5}, {-18,-13}, {-5,-3}}));
    }

    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, Comparator.comparingInt(value -> -value[0]));
        boolean[] visited = new boolean[routes.length];

        for (int i = 0; i < routes.length; i++) {
            if (visited[i]) {
                continue;
            }

            int start = routes[i][0];
            int end = routes[i][1];
            answer += 1;
            visited[i] = true;

            for (int j = 0; j < routes.length; j++) {
                if (visited[j]) {
                    continue;
                }

                int next_start = routes[j][0];
                int next_end = routes[j][1];
                if (start >= next_start && start <= next_end) {
                    visited[j] = true;
                }
            }
        }

        return answer;
    }
}
