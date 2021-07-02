import java.util.HashMap;
import java.util.Map;

public class programmers_hash_3 {
    public static void main(String[] args) {
        programmers_hash_3 p = new programmers_hash_3();
        System.out.println(p.solution(new String[][]{{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}}));
        System.out.println(p.solution(new String[][]{{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}}));

    }

    public int solution(String[][] clothes) {
        int answer = 1;

        Map<String, Integer> stringIntegerMap = new HashMap<>();

        for (String[] cloth :
                clothes) {
            stringIntegerMap.merge(cloth[1], 2, (l, r) -> l + 1);
        }


        for (int v :
                stringIntegerMap.values()) {
            answer *= v;
        }
//        다벗은건 빼야해요!
        return answer - 1;
    }
}
