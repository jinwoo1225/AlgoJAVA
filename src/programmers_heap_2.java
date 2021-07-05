import java.util.Comparator;
import java.util.PriorityQueue;

public class programmers_heap_2 {
    public static void main(String[] args) {
        programmers_heap_2 p = new programmers_heap_2();

        System.out.println(
                p.solution(new int[][]{
                        {0, 3},
                        {1, 9},
                        {2, 6}
                })
        );
        System.out.println(
                p.solution(new int[][]{
                        {0, 10},
                        {4, 10},
                        {15, 2},
                        {5, 11}
                })
        );
        System.out.println(
                p.solution(new int[][]{
                        {1, 3},
                        {2, 6},
                        {1, 9},
                        {2, 4}
                })
        );
    }

    class Job {
        Job(int request, int duration) {
            this.request = request;
            this.duration = duration;
        }

        public int request;
        public int duration;

        @Override
        public String toString() {
            return "Job{" +
                    "request=" + request +
                    ", duration=" + duration +
                    '}';
        }
    }

    public int solution(int[][] jobs) {
        int answer = 0;

        PriorityQueue<Job> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.duration));
        PriorityQueue<Job> jobPriorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.request));
        for (int[] j : jobs) {
            jobPriorityQueue.add(new Job(j[0], j[1]));
        }
        int time = 0;
        int finished_job = 0;
        final int N = jobs.length;

        while (finished_job != N) {
            while (!jobPriorityQueue.isEmpty()) {
                if (jobPriorityQueue.peek().request <= time) {
                    pq.add(jobPriorityQueue.poll());
                } else {
                    break;
                }
            }
            if (pq.isEmpty()) {
                time += 1;
            } else {
                Job job = pq.poll();
                time += job.duration;
                answer += time - job.request;
                finished_job += 1;
            }
        }

        return answer /N;
    }
}
