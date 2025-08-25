// 1, 2, 3 더하기
package DynamicProgramming;
import java.util.*;

public class BJ9095 {
    static int t;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt(); 
            System.out.println(solve(n));
        }
    }

    public static int solve(int n) {
        int MAX_VALUE = 11;
        int[] dp = new int[MAX_VALUE];

        // dp 초기값 설정
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        if (n >= 4) {
            for (int i = 4; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
            }
        }
        return dp[n];
    }
}
