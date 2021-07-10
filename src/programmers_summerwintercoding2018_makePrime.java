import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class programmers_summerwintercoding2018_makePrime {
    public int solution(int[] nums) {
        int answer = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    System.out.println(nums[i] + " " + nums[j] + " " + nums[k] + " " + (nums[i] + nums[j] + nums[k]));
                    if (isPrime(nums[i] + nums[j] + nums[k])) {
                        answer += 1;
                    }
                }
            }
        }

        return answer;
    }
    public boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test1() {
        assertEquals(1, solution(new int[]{1, 2, 3, 4}));
    }
}
