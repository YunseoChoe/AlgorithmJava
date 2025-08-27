// 계단 오르기
package DynamicProgramming;
import java.util.*;

public class BJ2579 {
    static int n; // n은 1부터 -> 엣지 케이스 항상 생각하기.
    static int[] stair;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        stair = new int[n];
        for (int i = 0; i < n; i++) {
            stair[i] = sc.nextInt();
        }

        System.out.println(solve());
    }

    public static int solve() {
        int[] dp = new int[n]; // dp[i] = i번째 계단까지 올라섰을 때 얻을 수 있는 최대 점수.

        // 초기값
        if (n == 1) {
            dp[0] = stair[0]; // 계단을 밟아야지만 최댓값.
            return dp[0];
        }
        if (n == 2) {
            dp[1] = stair[0] + stair[1];
            return dp[1];
        }

        dp[0] = stair[0];
        dp[1] = stair[0] + stair[1];
        dp[2] = Math.max(stair[0], stair[1]) + stair[2];
        
        for (int i = 3; i < n; i++) { 
            dp[i] = Math.max(dp[i - 2], dp[i - 3] + stair[i - 1]) + stair[i];
        }

        return dp[n - 1];
    }
}
