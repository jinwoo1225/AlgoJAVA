import java.util.*;

public class programmers_stackQueue_2 {
    public static void main(String[] args) {
        programmers_stackQueue_2 p = new programmers_stackQueue_2();

        System.out.println(p.solution(new int[]{2, 1, 3, 2}, 2));
        System.out.println(p.solution(new int[]{1,1,9,1,1,1}, 0));


    }

    class PrinterProcess {
        PrinterProcess(int idx, int priority){
            this.index = idx;
            this.priority = priority;
        }

        public void setTarget(boolean target) {
            this.target = target;
        }

        @Override
        public String toString() {
            return "PrinterQueue{" +
                    "index=" + index +
                    ", Priority =" + priority +
                    ", target=" + target +
                    '}';
        }

        int index;
        int priority;
        boolean target;
    }

    public int solution(int[] priorities, int location) {
        Deque<PrinterProcess> printerQueue = new ArrayDeque<>();
        for (int i = 0; i < priorities.length; i++) {
            printerQueue.add(new PrinterProcess(i, priorities[i]));
        }
        for (PrinterProcess pp : printerQueue) {
            if (pp.index == location) {
                pp.setTarget(true);
                break;
            }
        }
        int attempt = 1;
        while(!printerQueue.isEmpty()){
            PrinterProcess pp = printerQueue.poll();
            Optional<PrinterProcess> max =
            printerQueue.stream().max(Comparator.comparingInt(l -> l.priority));
            if (max.isPresent()){
                if (pp.priority >= max.get().priority){
                    if (pp.target){
                        return attempt;
                    } else {
                        attempt += 1;
                    }
                } else {
                    printerQueue.add(pp);
                }
            } else {
                return attempt;
            }
        }
        return attempt;
    }

}
