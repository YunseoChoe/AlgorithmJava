// 포도주 시식
package DynamicProgramming;
import java.util.*;

public class BJ2156 {
    static int n, maxValue = 0;;
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

        if (n == 1) return arr[0];
            
        else if (n == 2) return arr[0] + arr[1];

        // 2579(계단오르기)와는 다르게, 한 칸 또는 두 칸 중 선택해야 한다는 조건이 없음. 따라서 현재 값을 선택해야 할지 말지 옵션도 추가해야 함.
        // 초기값
        dp[0] = arr[0];
        dp[1] = arr[0] + arr[1];
        dp[2] = Math.max(arr[0] + arr[1], Math.max(arr[0] + arr[2], arr[1] + arr[2]));

        // dp 점화식
        for (int i = 3; i < n; i++) {
            dp[i] = Math.max(Math.max(dp[i - 1], dp[i - 2] + arr[i]), dp[i - 3] + arr[i - 1] + arr[i]);
        }

        for (int i = 0; i < n; i++) {
            maxValue = (maxValue < dp[i]) ? dp[i] : maxValue;   
        }
        return maxValue;
    }
}
