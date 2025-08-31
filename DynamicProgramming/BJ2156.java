// 포도주 시식
package DynamicProgramming;
import java.util.*;

public class BJ2156 {
    static int n;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        solve();
    }

    public static void solve() {
        int[] dp = new int[n];

        // 초기값
        dp[0] = arr[0];
        dp[1] = arr[0] + arr[1];
        dp[2] = Math.max(arr[0] + arr[2], arr[1] + arr[2]);

        for (int i = 3; i < n; i++) {
            dp[i] = 
        }
    }
}
