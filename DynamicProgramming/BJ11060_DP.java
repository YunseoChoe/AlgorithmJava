// 점프 점프
package DynamicProgramming;
import java.util.*;
import java.io.*;

public class BJ11060_DP {
    static int n, INF = Integer.MAX_VALUE;
    static int[] a;
    static int[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = new int[n];
        dp = new int[n]; 
        Arrays.fill(dp, INF); // dp값 무한대로 초기화
        
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        solve();

        if (dp[n - 1] != INF) {
            System.out.println(dp[n - 1]);
        }
        else {
            System.out.println(-1);
        }
    }

    public static void solve() {
        // dp 초기값
        dp[0] = 0;
        
        for (int i = 0; i < n - 1; i++) {
            for (int j = 1; j <= a[i]; j++) {
                if (0 <= i + j && i + j < n && dp[i] != INF) { // 자바에서는 INF에 정수값을 더하면 음수가 돼서 최솟값이 잘못 갱신될 수 있음.
                    dp[i + j] = Math.min(dp[i + j], dp[i] + 1); // 1은 점프
                }
            }
        }
    }
}
