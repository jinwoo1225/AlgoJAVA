import java.util.HashSet;

public class programmers_bruteForce_2 {
    public static void main(String[] args) {
        programmers_bruteForce_2 p = new programmers_bruteForce_2();
        System.out.println(p.solution("17"));
        System.out.println(p.solution("011"));
    }

    void permutation(String pre, String str, HashSet<Integer> set) {
        int n = str.length();
        if (!pre.equals("")) set.add(Integer.valueOf(pre));
        for (int i = 0; i < n; i++)
            permutation(pre + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n), set);

    }


    public int solution(String numbers) {
        HashSet<Integer> set = new HashSet<>();
        permutation("", numbers, set);
        int answer = 0;

        for (int num : set) {
            if (num == 2) answer++;
            if (num % 2 != 0 && isPrime(num)) answer++;
        }

        return answer;
    }

    private boolean isPrime(int num) {
        if (num == 0 || num == 1) return false;
        for (int i = 3; i <= (int) Math.sqrt(num); i += 2) if (num % i == 0) return false;
        return true;
    }
}
