// 1, 2, 3, 더하기 4
package DynamicProgramming;
import java.util.*;

public class BJ15989 {
    static int t, maxN = 0, MAX_VALUE = 10001;
    static int[][] dp = new int[MAX_VALUE][4];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        int[] queries = new int[t];

        for (int i = 0; i < t; i++) {
            queries[i] = sc.nextInt();
            maxN = Math.max(maxN, queries[i]);
        } 

        solve(maxN); // maxN을 기준으로 한 번만 호출하여 dp를 완성함.

        for (int n : queries) {
            System.out.println(dp[n][1] + dp[n][2] + dp[n][3]);
        }
    }

    public static void solve(int maxN) {
        // 초기값 
        dp[1][1] = 1;
        dp[1][2] = 0;
        dp[1][3] = 0;
        dp[2][1] = 1;
        dp[2][2] = 1;
        dp[2][3] = 0;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;

        // 점화식 (필요한 maxN까지만 계산)
        // 조합을 구해야하므로, 오름차순인 경우만 인정한다.
        // 따라서 dp[][]의 2번째 인자가 2일 경우, 1과 2로 끝나는 경우만 구해야 한다. (3으로 끝나는 경우를 구해버리면 오름차순이 깨짐.)
        for (int i = 4; i <= maxN; i++) {
            dp[i][1] = dp[i - 1][1];
            dp[i][2] = dp[i - 2][1] + dp[i - 2][2];
            dp[i][3] = dp[i - 3][1] + dp[i - 3][2] + dp[i - 3][3];
        }
    }
}
