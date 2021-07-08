import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class programmers_blindKakao2019_openchat {
    public String[] solution(String[] record) {
        List<String> answer = new ArrayList<>();
        HashMap<String, String> db = new HashMap<>();
        for (String command : record) {
            String[] splitted = command.split(" ");
            switch (splitted[0]) {
                case "Enter":
                case "Change":
                    db.put(splitted[1], splitted[2]);
                    break;
                case "Leave":
                    break;
            }
        }
        for (String command : record) {
            String[] splitted = command.split(" ");
            switch (splitted[0]) {
                case "Enter":
                    answer.add(db.get(splitted[1]) + "님이 들어왔습니다.");
                    break;
                case "Change":
                    break;
                case "Leave":
                    answer.add(db.get(splitted[1]) + "님이 나갔습니다.");
                    break;
            }
        }
        return answer.toArray(new String[0]);
    }

    @Test
    public void 정답() {
        assertArrayEquals(new String[]{"Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."},
                solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"}));

    }
}
