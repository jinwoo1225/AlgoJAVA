public class programmers_greedy_2 {
    public static void main(String[] args) {
        programmers_greedy_2 p = new programmers_greedy_2();

        System.out.println(p.solution("JEROEN"));
        System.out.println(p.solution("JAN"));
    }

    public int solution(String name) {
        final int INF = 987654321;
        int answer = 0;
        StringBuilder S = new StringBuilder("A".repeat(name.length()));
        boolean[] visited = new boolean[name.length()];
        int cursor = 0;

        while (!S.toString().equals(name)) {
            int next = 0;
            int curDist, nextDist = INF;

            // 현재위치에서 알파벳 이동.
            S.setCharAt(cursor,name.charAt(cursor));
            visited[cursor] = true;
            answer += Math.min(name.charAt(cursor) - 'A', 'Z' - name.charAt(cursor) + 1);


            // 다음으로 이동할곳 탐색.
            for (int i = 0; i < name.length(); i++) {
                if (cursor == i || visited[i] || name.charAt(i) == 'A') continue;
                curDist = Math.min(Math.abs(i-cursor), name.length() - Math.abs(i - cursor));
                if (nextDist > curDist) {
                    nextDist = curDist;
                    next = i;
                }
            }
            cursor = next;
            answer += (nextDist < INF ? nextDist : 0);
        }

        return answer;
    }
}
