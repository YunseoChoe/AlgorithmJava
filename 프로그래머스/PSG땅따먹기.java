package 프로그래머스;
import java.util.*;

// - 알고리즘: DP (완전탐색은 시간 초과)

public class PSG땅따먹기 {
    public static int getMax(int row, int col, int[][] dp) {
        // col 제외한 열 중 가장 큰 값 반환
        int maxValue = 0;
        for (int i = 0; i < 4; i++) {
            if (i != col) {
                if (maxValue < dp[row][i]) {
                    maxValue = dp[row][i];
                }
            }
        }
        return maxValue;
    }
    
    public static int solution(int[][] land) {
        int n = land.length;
        int[][] dp = new int[n][4];
        int answer = 0;

        // dp 초기값
        for (int i = 0; i < 4; i++) {
            dp[0][i] = land[0][i];
        }

        // dp 점화식
        for (int i = 1; i < n; i++) { // 1행부터
            for (int j = 0; j < 4; j++) {
                // 자신의 열 제외하고, 이전 열에서 가장 큰 값 + 자신 값
                dp[i][j] = getMax(i - 1, j, dp) + land[i][j];
            }
        }

        // 마지막 행 중 최댓값 반환
        for (int i = 0; i < 4; i++) {
            if (answer < dp[n - 1][i]) {
                answer = dp[n - 1][i];
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        return answer;
    }
}
