// 가장 긴 감소하는 부분 수열
package DynamicProgramming;
import java.util.*;

public class BJ11722 {
    static int n;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(solve());
    }

    public static int solve() {
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < n; j++) {
                if (arr[i] < arr[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
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
