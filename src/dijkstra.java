import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class dijkstra {
    public HashMap<Integer, Integer> dijkstra(HashMap<Integer, HashMap<Integer, Integer>> graph, int start){
        final int INF = 987654321;
        PriorityQueue<int[]> queue = new PriorityQueue<>();
        HashMap<Integer, Integer> distances = new HashMap<>();

        for (int node:
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

            for (Map.Entry<Integer, Integer> hashMap:
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
}
