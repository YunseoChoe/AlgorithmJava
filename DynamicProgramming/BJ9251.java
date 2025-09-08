// LCS
package DynamicProgramming;
import java.util.*;

public class BJ9251 {
    static String s1, s2;
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        s1 = sc.next();
        s2 = sc.next();
        n = Math.max(s1.length(), s2.length());

        System.out.println(solve());
    }

    public static int solve() {
        int n = s1.length();
        int m = s2.length();
        
        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 문자가 같다면
                if (s1.charAt(i) == s2.charAt(j)) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1; 
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + 1; // 대각선 + 1
                        // dp[i][j] = dp[i][j - 1] + 1; 
                    }
                }
                // 문자가 다르다면
                else {
                    if (i == 0 && j == 0) {
                        dp[i][j] = 0; // 시작점
                    } 
                    else if (i == 0) {
                        dp[i][j] = dp[i][j - 1]; // 0번째 행이면 왼쪽 값 
                    } 
                    else if (j == 0) {
                        dp[i][j] = dp[i - 1][j]; // 0번째 열이면 위쪽 값
                    } 
                    else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); // 위쪽 or 왼쪽
                        // dp[i][j] = dp[i][j - 1];  
                    }
                }
            }
        }

        // dp값 중 가장 큰 값 return
        int maxValue = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                maxValue = (maxValue < dp[i][j] ? dp[i][j] : maxValue);
            }
        }

        return maxValue;
    }
}
