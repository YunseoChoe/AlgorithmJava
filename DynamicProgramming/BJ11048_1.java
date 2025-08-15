// 이동하기 
package DynamicProgramming;
import java.util.*;
import java.io.*;

public class BJ11048_1 {
    static int n, m;
    static int[][] map;
    static int[][] dp;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        map = new int[n][m];
        dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(line[j]);
                dp[i][j] = Integer.parseInt(line[j]);
            }
        }

        solve();

        System.out.println(dp[n - 1][m - 1]);
    }

    public static void solve() {
        // dp 초기화 (0번째 행과, 0번째 열만)
        dp[0][0] = map[0][0];
        // 행
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i][0];
        }
        // 열
        for (int i = 1; i < m; i++) {
            dp[0][i] = dp[0][i - 1] + dp[0][i];
        }
        
        // (1,1) 부터 
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                // 3곳 중 최댓값 + 현재 자신의 값
                dp[i][j] = Math.max(dp[i - 1][j], Math.max(dp[i][j - 1], dp[i - 1][j - 1])) + map[i][j]; // Math.max는 2개의 int만 가능.
            }
        }
    }
}
