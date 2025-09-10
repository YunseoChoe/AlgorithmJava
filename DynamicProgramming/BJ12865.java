// 평범한 배낭
package DynamicProgramming;
import java.io.*;

public class BJ12865 {
    static int n, k;
    static int[] weight;
    static int[] value;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] list = br.readLine().split(" ");
        n = Integer.parseInt(list[0]);
        k = Integer.parseInt(list[1]);

        weight = new int[n + 1];
        value = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            String[] input = br.readLine().split(" ");
            weight[i] = Integer.parseInt(input[0]);
            value[i] = Integer.parseInt(input[1]);
        }

        System.out.println(solve());
    }

    public static int solve() {
        int[][] dp = new int[n + 1][k + 1];

        // 초기값
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0; // 수용 가능한 무게가 0인 경우는 모두 0임.
        }
        
        // 점화식
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                // 배낭에 물건을 못담으면
                if (weight[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                }
                // 배낭에 물건을 담을 수 있다면
                else {
                    dp[i][j] = Math.max(dp[i - 1][j - weight[i]] + value[i], dp[i - 1][j]); // 배낭에 넣을 수 있어도, 넣지 않는 게 더 이득일 수도 있음.
                }  
            }
        }

        int maxValue = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                maxValue = (maxValue < dp[i][j] ? dp[i][j] : maxValue);
            }  
        }
        return maxValue;
    }
}
