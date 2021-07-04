import java.util.ArrayDeque;
import java.util.Deque;

public class programmers_stackQueue_3 {
    public static void main(String[] args) {
        programmers_stackQueue_3 p = new programmers_stackQueue_3();

        System.out.println(p.solution(2, 10, new int[]{7, 4, 5, 6}));
        System.out.println(p.solution(100, 100, new int[]{10}));
        System.out.println(p.solution(100, 100, new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10}));


    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {

        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < bridge_length; i++) {
            queue.add(0);
        }

        int bridge_weight = 0;
        int truck_index = 0;
        int days = 0;

        while (truck_index < truck_weights.length) {
            days++;

            bridge_weight -= queue.poll();

            if (bridge_weight + truck_weights[truck_index] <= weight){
                queue.add(truck_weights[truck_index]);
                bridge_weight += truck_weights[truck_index];
                truck_index += 1;
            } else {
                queue.add(0);
            }
        }
        days += bridge_length;

        return days;
    }
}
