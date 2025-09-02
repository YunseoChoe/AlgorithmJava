// 가장 긴 증가하는 부분 수열
package DynamicProgramming;
import java.util.*;

public class BJ11053 {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        System.out.println(solve()); 
    }

    public static int solve() {
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = 1; // 초기값
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]); // dp[j] 값들 중 최댓값으로
                }
            }
        }

        int maxValue = 0;
        for (int i = 0; i < n; i++) {
            maxValue = (maxValue < dp[i] ? dp[i] : maxValue);
        }
        return maxValue;
    }
}
