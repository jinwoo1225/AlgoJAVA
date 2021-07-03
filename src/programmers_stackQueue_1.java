import java.util.*;

public class programmers_stackQueue_1 {
    public static void main(String[] args) {
        programmers_stackQueue_1 p = new programmers_stackQueue_1();
        System.out.println(

                Arrays.toString(p.solution(
                        new int[]{93, 30, 55},
                        new int[]{1, 30, 5}
                ))
        );
    }

    public class Process {

        public Process(int p, int s) {
            progress = p;
            speed = s;
        }

        public void add() {
            progress += speed;
        }

        public boolean check() {
            return progress >= 100;
        }

        public int progress;
        public int speed;

        @Override
        public String toString() {
            return "Process{" +
                    "progress=" + progress +
                    ", speed=" + speed +
                    '}';
        }
    }

    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        Deque<Process> processes = new ArrayDeque<>();

        for (int i = 0; i < progresses.length; i++) {
            processes.add(new Process(progresses[i], speeds[i]));
        }

        int processed = 0;
        while (!processes.isEmpty()) {
            // 첫번째 프로세스가 다끝났는가?
            if (processes.peek().check()) {
                //해당 프로세스 제거.
                processes.poll();
                processed += 1;
                if (!(!processes.isEmpty() && processes.peek().check())) {
                    answer.add(processed);
                    processed = 0;
                }
            } else {
                for (Process p : processes) { p.add(); }
            }

        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}
