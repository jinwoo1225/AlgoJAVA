import java.util.ArrayDeque;
import java.util.Deque;

public class programmers_dfsbfs_1 {

    public static void main(String[] args) {
        programmers_dfsbfs_1 p = new programmers_dfsbfs_1();
        System.out.println(p.solution(new int[]{1, 1, 1, 1, 1}, 3));

    }

    class Node {
        Node(int data, int size) {
            this.data = data;
            this.size = size;
        }

        int data, size;

    }

    public int solution(int[] numbers, int target) {
        int answer = 0;

        // bfs using queue

        Deque<Node> queue = new ArrayDeque<>();

        queue.add(new Node(0, 0));
        int N = numbers.length;

        while (queue.size() > 0) {
            Node node = queue.poll();

            if (node.size == N && node.data == target) {
                answer++;
            }
            if (node.size < N) {
                queue.add(new Node(node.data + numbers[node.size], node.size + 1));
                queue.add(new Node(node.data - numbers[node.size], node.size + 1));
            }
        }

        return answer;
    }
}
