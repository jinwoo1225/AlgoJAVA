import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class programmers_blindKakao2019_stringCompress {
    public int solution(String s) {
        if (s.length() == 1) {
            return 1;
        }
        ArrayList<Integer> answers = new ArrayList<>();
        for (int i = 1; i < s.length() / 2 + 1; i++) {
            answers.add(check(i, s));
        }
        return (int) answers.stream().sorted().toArray()[0];
    }

    int check(int gap, String s) {
        int ret = (s.length() % gap);
        int count = 0;
        String temp = s.substring(0, gap);

        for (int i = 0; i < s.length() - (s.length() % gap); i += gap) {
            String substring = s.substring(i, i + gap);
            if (substring.equals(temp)) {
                count++;
            } else {
                ret += gap;
                if (count > 1) {
                    ret += String.valueOf(count).length();
                }
                count = 1;
                temp = substring;
            }
        }
        ret += gap;
        if (count > 1) {
            ret += String.valueOf(count).length();
        }

        return ret;
    }


    @Test
    public void answer() {
        assertEquals(8, solution("abcabcdede"));
        assertEquals(9, solution("ababcdcdababcdcd"));
        assertEquals(14, solution("abcabcabcabcdededededede"));
        assertEquals(17, solution("xababcdcdababcdcd"));
        assertEquals(1, solution("x"));
    }

    @Test
    public void answer2(){
        assertEquals(7, solution("aabbaccc"));
    }
}
