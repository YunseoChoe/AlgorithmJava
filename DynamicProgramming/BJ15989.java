// 1, 2, 3, 더하기 4
package DynamicProgramming;
import java.util.*;

public class BJ15989 {
    static int t, MAX_VALUE = 10001;
    static int[][] dp = new int[MAX_VALUE][4];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();

        // 초기값 
        // n값과 상관없이 똑같이 동작하므로 main에서 한 번만 실행.
        dp[1][1] = 1;
        dp[1][2] = 0;
        dp[1][3] = 0;
        dp[2][1] = 1;
        dp[2][2] = 1;
        dp[2][3] = 0;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            System.out.println(solve(n));
        } 
    }

    public static int solve(int n) {
        // 점화식
        // 조합을 구해야하므로, 오름차순인 경우만 인정한다.
        // 따라서 dp[][]의 2번째 인자가 2일 경우, 1과 2로 끝나는 경우만 구해야 한다. (3으로 끝나는 경우를 구해버리면 오름차순이 깨짐.)
        for (int i = 4; i <= n; i++) {
            dp[i][1] = dp[i - 1][1]; 
            dp[i][2] = dp[i - 2][1] + dp[i - 2][2];
            dp[i][3] = dp[i - 3][1] + dp[i - 3][2] + dp[i - 3][3];
        }

        int cnt = 0;
        for (int i = 1; i <= 3; i++) {
            cnt += dp[n][i];
        }
        return cnt;
    }
}
