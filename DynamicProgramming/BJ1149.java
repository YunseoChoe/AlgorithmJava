// RGB거리
package DynamicProgramming;
import java.util.*;

public class BJ1149 {
    static int n;
    static int[][] graph;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        graph = new int[n + 1][3];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 3; j++) {
                int num = sc.nextInt();
                graph[i][j] = num;
            }
        }

        System.out.println(solve());
    }

    public static int solve() {
        int[][] dp = new int[n + 1][3]; // 0: red, 1: green, 2: blue

        // 1번
        dp[1][0] = graph[1][0];
        dp[1][1] = graph[1][1];
        dp[1][2] = graph[1][2];

        // 2번
        dp[2][0] = Math.min(dp[1][1], dp[1][2]) + graph[2][0];
        dp[2][1] = Math.min(dp[1][0], dp[1][2]) + graph[2][1];
        dp[2][2] = Math.min(dp[1][0], dp[1][1]) + graph[2][2];

        // 3 ~ n-1번
        for (int i = 3; i <= (n - 1); i++) { 
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + graph[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + graph[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + graph[i][2];
        }

        // n, n-1번
        dp[n][0] = Math.min(dp[n - 1][1], dp[n - 1][2]) + graph[n][0];
        dp[n][1] = Math.min(dp[n - 1][0], dp[n - 1][2]) + graph[n][1];
        dp[n][2] = Math.min(dp[n - 1][0], dp[n - 1][1]) + graph[n][2];

        // 마지막 층의 dp 최솟값 반환.
        return Math.min(Math.min(dp[n][0], dp[n][1]), dp[n][2]);
    }
}
