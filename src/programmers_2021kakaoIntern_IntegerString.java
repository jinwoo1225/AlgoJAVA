import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class programmers_2021kakaoIntern_IntegerString {
    public int solution(String s) {
        String[] numbers = new String[]{
                "zero",
                "one",
                "two",
                "three",
                "four",
                "five",
                "six",
                "seven",
                "eight",
                "nine"
        };
        for (int i = 0; i < 10; i++) s = s.replaceAll(numbers[i], Integer.toString(i));
        return Integer.parseInt(s);
    }

    @Test
    public void Test1(){
        assertEquals(1478, solution("one4seveneight"));
    }
    @Test
    public void Test2(){
//        "23four5six7"	234567
        assertEquals(234567, solution("23four5six7"));
    }
}
