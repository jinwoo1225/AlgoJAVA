import java.util.Comparator;
import java.util.PriorityQueue;

public class programmers_heap_1 {
    public static void main(String[] args) {
        programmers_heap_1 p = new programmers_heap_1();

        System.out.println(p.solution(new int[]{1, 2, 3, 9, 10, 12},7));
    }

    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(1000000, Comparator.naturalOrder());
        for (int s : scoville) { priorityQueue.add(s); }
        int attempt = 0;
        while (true) {
            int a = priorityQueue.poll();
            if (a >= K) return attempt;
            if (priorityQueue.isEmpty()) return -1;
            attempt += 1;
            int b = priorityQueue.poll();
            priorityQueue.add(a + (2 * b));
        }
    }
}
