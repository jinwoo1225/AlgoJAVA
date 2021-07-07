import java.util.Arrays;
import java.util.Stack;

public class programmers_greedy_3 {
    public static void main(String[] args) {
        programmers_greedy_3 p = new programmers_greedy_3();

        System.out.println(p.solution("1924",2));
        System.out.println(p.solution("1231234",3));
        System.out.println(p.solution("4177252841",4));
    }

    public String solution(String number, int k) {

        Stack<Character> stack = new Stack<>();
        int deleted = 0;
        for (int index = 0; index < number.length() - 1; index++) {
            if (number.charAt(index) < number.charAt(index + 1)){
                deleted += 1;
            } else {
                stack.push(number.charAt(index));
            }

            while (stack.size() > 0 && stack.peek() < number.charAt(index + 1)){
                if (deleted == k){
                    StringBuilder sb = new StringBuilder();
                    for (char c : stack) sb.append(c);
                    sb.append(number.substring(index + 1));
                    return sb.toString();
                }
                deleted += 1;
                stack.pop();
            }

            if (deleted==k){
                StringBuilder sb = new StringBuilder();
                for (char c : stack) sb.append(c);
                sb.append(number.substring(index + 1));
                return sb.toString();
            }

        }
        StringBuilder sb = new StringBuilder();
        for (char c : stack) sb.append(c);
        return sb.toString();
    }
}
