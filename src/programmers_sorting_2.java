import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class programmers_sorting_2 {
    public static void main(String[] args) {
        programmers_sorting_2 p = new programmers_sorting_2();

        System.out.println(
                p.solution(new int[]{6, 10, 2})
        );

        System.out.println(
                p.solution(new int[]{3, 30, 34, 5, 9})
        );

    }

    public String solution(int[] numbers) {
        List<String> answer = new ArrayList<>();
        for (int number : numbers) {
            answer.add(String.valueOf(number));
        }
        answer.sort(Comparator.comparing(l -> l.repeat(5)));
        Collections.reverse(answer);
        return answer.get(0).equals("0") ? "0" : String.join("", answer);
    }
}
