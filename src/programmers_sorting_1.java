import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class programmers_sorting_1 {
    public static void main(String[] args) {
        programmers_sorting_1 p = new programmers_sorting_1();

        System.out.println(
                Arrays.toString(p.solution(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}}))
        );

    }

    public int[] solution(int[] array, int[][] commands) {
        List<Integer> answer = new ArrayList<>();
        for (int[] command : commands) { answer.add(Arrays.stream(Arrays.copyOfRange(array, command[0]-1 , command[1])).sorted().toArray()[command[2]-1]); }
        return answer.stream().mapToInt(i -> i).toArray();
    }

}
