// https://programmers.co.kr/learn/courses/30/lessons/77485

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class programmers_2021devmatch_rotatingBorder {
    int rotate(int x1, int y1, int x2, int y2) {
        // rotates the border and returns min element
        // x is row
        // y is column
        // rotates clockwise
        final int INF = 987654321;

        int dx1 = x1 - 1;
        int dy1 = y1 - 1;
        int dx2 = x2 - 1;
        int dy2 = y2 - 1;

        int[] upper = Arrays.copyOfRange(board[dx1], dy1, dy2 + 1);
        int[] lower = Arrays.copyOfRange(board[dx2], dy1, dy2 + 1);
        int[] lefty = Arrays.stream(Arrays.copyOfRange(board, dx1 + 1, dx2))
                .map(board -> board[dy1])
                .mapToInt(i -> i)
                .toArray();
        int[] righty = Arrays.stream(Arrays.copyOfRange(board, dx1 + 1, dx2))
                .map(board -> board[dy2])
                .mapToInt(i -> i)
                .toArray();

        // rotate upper
        for (int i = 0; i < dy2 - dy1; i++) {
            board[dx1][dy1 + i + 1] = upper[i];
        }

        // upper right goes down
        board[dx1 + 1][dy2] = upper[dy2 - dy1];

        // rotate righty
        for (int i = 0; i < dx2 - dx1 - 1; i++) {
            board[dx1 + i + 2][dy2] = righty[i];
        }

        // rotate lower
        for (int i = dy2 - dy1; i >= 1; i--) {
            board[dx2][dy1 + i - 1] = lower[i];
        }

        // lower left goes up
        board[dx2 - 1][dy1] = lower[0];

        // rotate lefty
        for (int i = dx2 - dx1 - 2; i >= 0; i--) {
            board[dx1 + i][dy1] = lefty[i];
        }

        int min_upper = Arrays.stream(upper).min().orElse(INF);
        int min_lower = Arrays.stream(lower).min().orElse(INF);
        int min_lefty = Arrays.stream(lefty).min().orElse(INF);
        int min_righty = Arrays.stream(righty).min().orElse(INF);

        // returns min element
        return Math.min(Math.min(min_upper, min_lower), Math.min(min_lefty, min_righty));
    }

    int[][] board;

    public int[] solution(int rows, int columns, int[][] queries) {
        List<Integer> answer = new ArrayList<>();

        // make board
        board = new int[rows][columns];
        int idx = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                board[i][j] = idx++;
            }
        }

        Arrays.stream(queries).forEach((query) -> {
            answer.add(rotate(query[0], query[1], query[2], query[3]));
        });

        return answer.stream().mapToInt(i -> i).toArray();
    }

    @Test
    public void Test1() {
        assertArrayEquals(new int[]{8, 10, 25}, solution(6, 6, new int[][]{{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}}));
    }

    @Test
    public void Test2() {
        assertArrayEquals(new int[]{1, 1, 5, 3}, solution(3, 3, new int[][]{{1, 1, 2, 2}, {1, 2, 2, 3}, {2, 1, 3, 2}, {2, 2, 3, 3}}));
    }
}
