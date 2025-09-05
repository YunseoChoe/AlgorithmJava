// 전깃줄
package DynamicProgramming;
import java.util.*;

public class BJ2565 {
    static int n; // 전깃줄 개수
    static int maxValue = 0;
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[501]; 

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            maxValue = Math.max(Math.max(a, b), maxValue);
            arr[a] = b;
        }
        System.out.println(solve());
    }

    public static int solve() {
        int[] dp = new int[maxValue + 1];

        // LIS
        for (int i = 0; i <= maxValue; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }

        int maxDp = 0;
        for (int i = 0; i <= maxValue; i++) {
            maxDp = (maxDp < dp[i] ? dp[i] : maxDp);
        }
        return n - (maxDp - 1);
    }
}
