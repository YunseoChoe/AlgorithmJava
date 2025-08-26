// 정수 삼각형
package DynamicProgramming;
import java.util.*;

public class BJ1932 {
    static int n;
    static int[][] graph;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        graph = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        System.out.println(solve());
    }

    public static int solve() {
        // 크기가 1일 때
        if (n == 1) {
            return graph[0][0];
        }

        int[][] dp = new int[n][n];

        dp[0][0] = graph[0][0];
        dp[1][0] = dp[0][0] + graph[1][0];
        dp[1][1] = dp[0][0] + graph[1][1];

        for (int i = 2; i < n; i++) {
            for (int j = 0; j <= i; j++) { 
                // 0번째 열이라면 (왼쪽 대각선)
                if (j == 0) {
                    dp[i][j] = dp[i - 1][0] + graph[i][j];
                }
                // 마지막번째 열이라면 (오른쪽 대각선)
                else if (j == i) {
                    dp[i][j] = dp[i - 1][j - 1] + graph[i][j];
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + graph[i][j];
                }
            }
        }

        // 마지막 층에서 가장 큰 수
        int returnValue = 0;
        for (int i = 0; i < n; i++) {
            if (dp[n - 1][i] > returnValue) {
                returnValue = dp[n - 1][i];
            }
        }
        return returnValue;
    }
}
