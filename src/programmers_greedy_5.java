import java.util.*;

public class programmers_greedy_5 {

    public static void main(String[] args) {
        System.out.println(new programmers_greedy_5().solution(4, new int[][]{{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}}));
    }


    public HashMap<Integer, Integer> dijkstra(HashMap<Integer, HashMap<Integer, Integer>> graph, int start) {
        final int INF = 987654321;
        PriorityQueue<int[]> queue = new PriorityQueue<>();
        HashMap<Integer, Integer> distances = new HashMap<>();

        for (int node :
                graph.keySet()) {
            distances.put(node, INF);
        }

        distances.put(start, 0);

        queue.add(new int[]{distances.get(start), start});

        while (queue.size() > 0) {
            int[] cur = queue.poll();
            int cur_dis = cur[0];
            int cur_des = cur[1];

            if (distances.get(cur_des) < cur_dis) {
                continue;
            }

            for (Map.Entry<Integer, Integer> hashMap :
                    graph.get(cur_des).entrySet()) {
                int distance = cur_dis + hashMap.getValue();
                if (distance < distances.get(hashMap.getKey())) {
                    distances.put(hashMap.getKey(), distance);
                    queue.add(new int[]{distance, hashMap.getKey()});
                }
            }
        }

        return distances;
    }

    int[] parent;

    int find(int child) {
        if (parent[child] == child) {
            return child;
        } else {
            return parent[child] = find(parent[child]);
        }
    }

    public int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int[n];
        Arrays.sort(costs, Comparator.comparingInt(value -> value[2]));
        for (int i = 0; i < n; i++) parent[i] = i;
        for (int[] cost : costs) {
            int first = find(cost[0]);
            int second = find(cost[1]);
            if (first != second) {
                parent[second] = first;
                answer += cost[2];
            }
        }
        return answer;
    }
}
