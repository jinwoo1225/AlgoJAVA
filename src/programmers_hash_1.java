import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class programmers_hash_1 {
    public static void main(String[] args) {
        programmers_hash_1 s = new programmers_hash_1();
        String[] p = {
                "leo", "kiki", "eden"
        };
        String[] c = {
                "eden", "kiki"
        };

        System.out.println(s.solution(p, c));
    }

    public String solution(String[] participant, String[] completion) {
        String answer = "";

        Map<String, Integer> pStringIntegerMap = new HashMap<>();

        for (String p :
                participant) {
            pStringIntegerMap.merge(p, 1, (Integer::sum));
        }

        for (String c :
                completion) {
            int a = pStringIntegerMap.get(c);
            pStringIntegerMap.put(c, a - 1);
            if (a - 1 == 0) {
                pStringIntegerMap.remove(c);
            }
        }


        return pStringIntegerMap.keySet().toArray()[0].toString();
    }
}