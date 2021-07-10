import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class programmers_montlyS2_plusMinusAddition {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for (int i = 0; i < absolutes.length; i++) {
            answer += absolutes[i] * (signs[i] ? 1 : -1);
        }
        return answer;
    }

    @Test
    public void test1(){
     assertEquals(9, solution(new int[]{4,7,12}, new boolean[]{true,false,true}));
    }
}
