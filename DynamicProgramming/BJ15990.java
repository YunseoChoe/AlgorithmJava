// 1, 2, 3 더하기 5
package DynamicProgramming;
import java.util.Scanner;

public class BJ15990 {  
    static int t, maxCase = 0, MOD = 1000000009;
    static long[][] dp; 
    static int[] cases;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        cases = new int[t];

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            cases[i] = n;
            if (maxCase < n) {
                maxCase = n;
            }
        } 
        // 테스트 케이스 중에서 가장 큰 값을 기준으로 dp 구성 (1번만 호출)
        buildDP(maxCase);

        for (int i : cases) {
            solve(i);
        }
    }

    public static void solve(int n) {
        long printValue = (dp[n][1] + dp[n][2] + dp[n][3]) % MOD;
        System.out.println(printValue);
    }

    public static void buildDP(int n) {
        dp = new long[n + 1][4]; 
        
        // dp 초기값 설정
        dp[1][1] = 1;
        dp[2][1] = 0;
        dp[2][2] = 1;
        dp[2][3] = 0;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;
        
        // 점화식
        for (int i = 4; i <= n; i++) {
            // 1로 끝나는
            dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % MOD;
            // 2로 끝나는
            dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % MOD;
            // 3으로 끝나는
            dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % MOD;
        }
    }
}
