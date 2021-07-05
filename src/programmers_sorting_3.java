import java.util.Arrays;

public class programmers_sorting_3 {
    public static void main(String[] args) {
        programmers_sorting_3 p = new programmers_sorting_3();

        System.out.println(
                p.solution(new int[]{
                        3, 0, 6, 1, 5
                })
        );


    }

    public int solution(int[] citations) {
        for (int i = citations.length ; i >= 0; i--) {
            int cnt = 0;
            for (int citation:
                    Arrays.stream(citations).sorted().toArray()) {
                if (citation >= i){
                    cnt += 1;
                }
                if (cnt == i){
                    return i;
                }
            }
        }
        return 0;
    }
}
