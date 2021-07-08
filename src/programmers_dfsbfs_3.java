import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class programmers_dfsbfs_3 {
    public static void main(String[] args) {
        programmers_dfsbfs_3 p = new programmers_dfsbfs_3();


        System.out.println(p.solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));

    }

    class StringNode {
        StringNode(String string, int distance) {
            this.string = string;
            this.distance = distance;
        }

        String string;
        int distance;

        @Override
        public String toString() {
            return "StringNode{" +
                    "string='" + string + '\'' +
                    ", distance=" + distance +
                    '}';
        }
    }


    public int solution(String begin, String target, String[] words) {
        if (!Arrays.asList(words).contains(target)){
            // error handling
            return 0;
        }

        // bfs using queue

        Deque<StringNode> queue = new ArrayDeque<>();

        queue.add(new StringNode(begin, 0));

        while (queue.size() > 0) {
            System.out.println(queue);
            StringNode stringNode = queue.poll();

            if (stringNode.string.equals(target)) {
                return stringNode.distance;
            }

            for (String s :
                    words) {
                if (check(s, stringNode.string)) {
                    queue.add(new StringNode(s, stringNode.distance + 1));
                }
            }
        }

        return 0;
    }

    private boolean check(String s, String string) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != string.charAt(i)) {
                cnt++;
            }
            if (cnt > 1) {
                return false;
            }
        }
        return cnt == 1;
    }

}
