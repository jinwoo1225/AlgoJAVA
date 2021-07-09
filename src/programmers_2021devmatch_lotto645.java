import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class programmers_2021devmatch_lotto645 {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int unknown = 0;
        int nonmatch = 1;
        for (int lotto :
                lottos) {
            if (lotto == 0) {
                unknown++;
            } else {
                if (Arrays.stream(win_nums).noneMatch(i -> i == lotto)) {
                    nonmatch++;
                }
            }
        }

        answer[0] = nonmatch;
        answer[1] = nonmatch + unknown;
        if (answer[0] > 6) answer[0] = 6;
        if (answer[1] > 6) answer[1] = 6;

        return answer;
    }

    @Test
    public void Test1() {
        assertArrayEquals(new int[]{3, 5}, solution(new int[]{44, 1, 0, 0, 31, 25}, new int[]{31, 10, 45, 1, 6, 19}));
    }

    @Test
    public void Test2() {
        assertArrayEquals(new int[]{1, 6}, solution(new int[]{0, 0, 0, 0, 0, 0}, new int[]{38, 19, 20, 40, 15, 25}));
    }
}
