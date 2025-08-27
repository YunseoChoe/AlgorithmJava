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

        // 초기값
        dp[0] = 1;

        for (int i = 1; i < n; i++) {
            int maxNum = 0;
            int maxIdx = 0;
            boolean isSmall = false;
            for (int j = 0; j < i; j++) {
                // dp[i]보다 이전 값들 중 작은 값이 있다면
                if (a[i] > a[j]) {
                    // 그 중 dp값이 가장 큰 값 찾기
                    if (dp[j] > maxNum) {
                        maxNum = dp[j];
                        maxIdx = j;
                    }
                    dp[i] = dp[maxIdx] + 1;
                    isSmall = true;
                }
            }
            // dp[i]보다 이전 값들 중 작은 값이 없다면
            if (!isSmall) {
                dp[i] = 1;
            }
        }
        return Arrays.stream(dp).max().getAsInt(); // dp[]의 최댓값 반환.
    }
}
