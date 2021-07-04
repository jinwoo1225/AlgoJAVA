import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class programmers_stackQueue_4 {
    public static void main(String[] args) {
        programmers_stackQueue_4 p = new programmers_stackQueue_4();

        System.out.println(Arrays.toString(p.solution(new int[]{1, 2, 3, 2, 3})));
    }

    public int[] solution(int[] prices) {
        List<Integer> answer = new ArrayList<>();
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < prices.length; i++) { answer.add(0); }
        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[stack.peekLast()] > prices[i]) {
                int top = stack.pollLast();
                answer.set(top, i - top);
            }
            stack.add(i);
        }
        while (!stack.isEmpty()) {
            int top = stack.pollLast();
            answer.set(top, prices.length - 1 - top);
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}
