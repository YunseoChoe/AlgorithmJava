// 가장 큰 증가하는 부분 수열
package DynamicProgramming;
import java.util.*;

public class BJ11055 {
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
        dp[0] = arr[0];
    
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    if (dp[j] != 0) { // dp의 초기값은 모두 0이므로.
                        dp[i] = Math.max(dp[j] + arr[i], dp[i]);
                    }
                    else {
                        dp[i] = Math.max(arr[j] + arr[i], dp[i]);
                    }
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
