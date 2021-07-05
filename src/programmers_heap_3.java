import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class programmers_heap_3 {
    public static void main(String[] args) {
        programmers_heap_3 p = new programmers_heap_3();
        System.out.println(
                Arrays.toString(p.solution(new String[]{"I 16", "D 1"}))
        );
        System.out.println(
                Arrays.toString(p.solution(new String[]{"I 7", "I 5", "I -5", "D -1"}))
        );
    }

    public int[] solution(String[] operations) {
        int[] answer = {};

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> maxTemp = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.naturalOrder());
        PriorityQueue<Integer> minTemp = new PriorityQueue<>(Comparator.naturalOrder());


        for (String operation :
                operations) {
            String[] splitted = operation.split(" ");
            String operand = splitted[0];
            int data = Integer.parseInt(splitted[1]);
            if (operand.equals("I")) {
                // insertion
                maxHeap.add(data);
                minHeap.add(data);
            } else {
                // deletion
                if (maxHeap.size() > 0 && minHeap.size() > 0) {
                    if (data == 1) {
                        minTemp.add(maxHeap.poll());
                    } else {
                        maxTemp.add(minHeap.poll());
                    }
                }
            }

            while (!minHeap.isEmpty() && !minTemp.isEmpty() && minHeap.peek().equals(minTemp.peek())) {
                minHeap.poll();
                minTemp.poll();
            }

            while (!minHeap.isEmpty() && !maxHeap.isEmpty() && maxHeap.peek().equals(maxTemp.peek())) {
                maxHeap.poll();
                maxTemp.poll();
            }
        }

        if (maxHeap.isEmpty()) {
            return new int[]{0, 0};
        } else {
            return new int[]{maxHeap.peek(), minHeap.peek()};
        }
    }
}
