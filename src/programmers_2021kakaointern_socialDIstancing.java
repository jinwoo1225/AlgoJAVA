import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

import static org.junit.Assert.assertArrayEquals;

public class programmers_2021kakaointern_socialDIstancing {
    class Node {
        Node(int y, int x, int distance) {
            this.y = y;
            this.x = x;
            this.distance = distance;
        }

        int y, x, distance;

        @Override
        public String toString() {
            return "Node{" +
                    "y=" + y +
                    ", x=" + x +
                    ", distance=" + distance +
                    '}';
        }
    }

    boolean check(int y, int x, String[] place) {
        final int[] DY = {0, 0, -1, 1};
        final int[] DX = {1, -1, 0, 0};
        // bfs using queue
        Deque<Node> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[5][5];

        queue.add(new Node(y, x, 0));

        while (queue.size() > 0) {
            Node node = queue.poll();
            if (place[node.y].charAt(node.x) == 'X') {
                continue;
            }
            if (node.distance >= 3) {
                continue;
            }
            if (node.distance > 0 && place[node.y].charAt(node.x) == 'P') {
                return false;
            }
            if (!visited[node.y][node.x]) {
                visited[node.y][node.x] = true;
                for (int i = 0; i < 4; i++) {
                    int next_y = node.y + DY[i];
                    int next_x = node.x + DX[i];
                    int next_distance = node.distance + 1;
                    if (next_y >= 0 && next_y < 5 && next_x >= 0 && next_x < 5 && next_distance < 3) {
                        if (!visited[next_y][next_x]) {
                            queue.add(new Node(next_y, next_x, node.distance + 1));
                        }
                    }
                }
            }
        }
        return true;
    }

    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        Arrays.fill(answer, 1);

        for (int i = 0; i < places.length; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    if (places[i][j].charAt(k) == 'P') {
                        if (!check(j, k, places[i])) {
                            answer[i] = 0;
                            break;
                        }
                    }
                }
                if (answer[i] == 0) {
                    break;
                }
            }
        }

        return answer;
    }

    @Test
    public void test1() {
        // {1, 0, 1, 1, 1}
        // {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}}
        assertArrayEquals(new int[]{1, 0, 1, 1, 1}, solution(new String[][]{{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}}));
    }

}
