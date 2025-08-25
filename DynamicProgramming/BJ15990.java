// 1, 2, 3 더하기 5
package DynamicProgramming;
import java.util.Scanner;

public class BJ15990 {  
    static int t;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();

            System.out.println(solve(n));
        } 
    }

    public static int solve(int n) {
        int returnValue = 0;
        int MAX_VALUE = 100001;
        int[][] dp = new int[MAX_VALUE][4];

        // dp 초기값 설정
        dp[1][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;
        
        if (n >= 4) {
            for (int i = 4; i <= n; i++) {
                // 해당 값이 없으면 0으로 ..
                // 1로 끝나는
                dp[i][1] = dp[i - 1][2] + dp[i - 1][3];
                // 2로 끝나는
                dp[i][2] = dp[i - 2][1] + dp[i - 2][3];
                // 3으로 끝나는
                dp[i][3] = dp[i - 3][1] + dp[i - 3][2];
            }
            returnValue = dp[n][1] + dp[n][2] + dp[n][3];
        }
        return returnValue;
    }
}
