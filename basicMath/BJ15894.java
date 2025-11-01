// 수학은 체육과목 입니다
package basicMath;
import java.util.*;
import java.io.*;

public class BJ15894 {
    static int n;
    static int[] dp;

    public static int solve() {
        if (n == 1) {
            return 4;
        }
        else if (n == 2) {
            return 6;
        }
        else if (n == 3) {
            return 12;
        }

        // dp 초기값
        dp[3] = 12;

        // dp 점화식
        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i - 1] - (n - 1) + (3 + n);
        }

        return dp[n];
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dp = new int[n + 1];

        System.out.println(solve());
    }
}
