// 팰린드롬? (DP)
package DynamicProgramming;

import java.io.*;
import java.util.*;

public class BJ10942 {
    static int n, m;
    static int[] nums;
    static boolean[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        nums = new int[n];
        dp = new boolean[n][n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        
        solve(); // DP 미리 계산

        m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken()) - 1;
            sb.append(dp[s][e] ? 1 : 0).append("\n");
        }

        System.out.print(sb);
    }

    public static void solve() {
        // 길이가 1인 경우 
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        // 길이가 2인 경우
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                // 서로 같은 값일 때만
                dp[i][i + 1] = true;
            }
        }

        // 길이가 3 이상인 경우 (3부터 시작)
        for (int len = 3; len <= n; len++) {
            for (int s = 0; s + len - 1 < n; s++) {
                int e = s + len - 1;
                if (nums[s] == nums[e] && dp[s + 1][e - 1]) { // 길이가 1, 2인 구간은 이미 계산되어 있음.
                    dp[s][e] = true;
                }
            }
        }
    }
}
