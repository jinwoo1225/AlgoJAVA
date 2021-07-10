import org.junit.Test;

import java.util.Locale;

import static org.junit.Assert.assertEquals;

public class programmers_blindKakao2021_IDrecommendation {
    public String solution(String new_id) {
        //stage 1 : lower it
        new_id = new_id.toLowerCase(Locale.ROOT);

        // stage 2 : only alphabet & numbers & _ & - & .
        new_id = new_id.replaceAll("[^a-z.\\d-_]", "");

        // stage 3 : remove duplicated dot
        new_id = new_id.replaceAll("\\.+", ".");

        // stage 4 : remove startswith or endswith
        if (new_id.startsWith(".")) new_id = new_id.substring(1);
        if (new_id.endsWith(".")) new_id = new_id.substring(0, new_id.length() - 1);

        // stage 5 : if new_id lengths 0 replaces to "a"
        if (new_id.length() == 0) new_id = "a";

        // stage 6 : if lengths over 16 substring to 15
        if (new_id.length() >= 16) new_id = new_id.substring(0, 15);
        if (new_id.endsWith(".")) new_id = new_id.substring(0, new_id.length() - 1);

        // stage 7 : if new_id length lower or equals to 2 addition to new_id length to 3
        if (new_id.length() < 3) {
            StringBuilder new_idBuilder = new StringBuilder(new_id);
            while (new_idBuilder.length() != 3) {
                new_idBuilder.append(new_idBuilder.charAt(new_idBuilder.length()-1));
            }
            new_id = new_idBuilder.toString();
        }
        return new_id;
    }

    @Test
    public void test1() {
        assertEquals("bat.y.abcdefghi", solution("...!@BaT#*..y.abcdefghijklm"));
    }
    @Test
    public void test2() {
        assertEquals("z--", solution("z-+.^."));
    }
}
