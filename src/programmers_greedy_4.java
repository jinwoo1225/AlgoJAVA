import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class programmers_greedy_4 {
    public static void main(String[] args) {
        programmers_greedy_4 p = new programmers_greedy_4();

        System.out.println(p.solution(new int[]{70, 50, 80, 50}, 100)); // 3
        System.out.println(p.solution(new int[]{70, 80, 50}, 100));  // 3

    }

    public int solution(int[] people, int limit) {
        int answer = 0;

        Deque<Integer> deque = new ArrayDeque<>();
        for (int weight : Arrays.stream(people).sorted().toArray()) {
            deque.add(weight);
        }

        while (deque.size() > 0) {
            if (deque.size() == 1) {
                answer += 1;
                break;
            } else if (deque.peekFirst() + deque.peekLast() > limit) {
                deque.pollLast();
                answer += 1;
            } else {
                deque.pollLast();
                deque.pop();
                answer += 1;
            }
        }
        return answer;
    }
}
