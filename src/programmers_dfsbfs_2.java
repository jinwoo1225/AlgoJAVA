import java.util.Arrays;
import java.util.HashMap;

public class programmers_dfsbfs_2 {
    public static void main(String[] args) {
        programmers_dfsbfs_2 p = new programmers_dfsbfs_2();

        System.out.println(p.solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
        System.out.println(p.solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
    }

    boolean[] visited;

    void dfs(int start, int[][] computers) {
        for (int i = 0; i < computers[start].length; i++) {
            if (!visited[i] && computers[start][i] == 1) {
                visited[i] = true;
                dfs(i, computers);
            }
        }
    }

    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                answer++;
                dfs(i, computers);
            }
        }
        return answer;
    }
}
