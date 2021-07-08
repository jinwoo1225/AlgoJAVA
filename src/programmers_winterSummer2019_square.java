// https://programmers.co.kr/learn/courses/30/lessons/62048
public class programmers_winterSummer2019_square {
    public static void main(String[] args) {
        programmers_winterSummer2019_square p = new programmers_winterSummer2019_square();

        System.out.println(p.solution(8, 12));
        System.out.println(p.solution(9, 13));
        System.out.println(p.solution(9, 14));
        System.out.println(p.solution(10, 14));
        System.out.println(p.solution(11, 14));
        System.out.println(p.solution(10, 15));
    }

    public long solution(int w, int h) {
        long answer = 0;
        for (int i = 0; i < w; i++) {
            answer += (long) h * i / w;
        }
        return answer * 2;
    }
}
