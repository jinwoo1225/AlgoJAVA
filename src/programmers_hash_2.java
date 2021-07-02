import java.util.Arrays;
import java.util.Comparator;

public class programmers_hash_2 {
    public static void main(String[] args) {
        programmers_hash_2 p = new programmers_hash_2();
        System.out.println(p.solution(new String[]{"119", "97674223", "1195524421"}));
        System.out.println(p.solution(new String[]{"123", "456", "789"}));
        System.out.println(p.solution(new String[]{"12", "123", "1235", "567", "88"}));

    }

    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book, Comparator.reverseOrder());
        for (int i = 0; i < phone_book.length-1; i++) {
            if(phone_book[i].startsWith(phone_book[i+1])){
                return false;
            }
        }
        return true;
    }
}


//class Solution {
//
//}