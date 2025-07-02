// 부분수열의 합
package bruteForce;
import java.util.*;

public class BJ14225 {
    static int n;
    static int[] s;
    static boolean[] sumArr; // sum값 자체가 인덱스, 시간 복잡도: O(1)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        s = new int[n];
        int maxSum = 0;
        for (int i = 0; i < n; i++) {
            s[i] = sc.nextInt();
            maxSum += s[i];
        }
        sumArr = new boolean[maxSum + 2]; // 1부터 maxSum까지 모든 원소가 부분 수열의 합일 수도 있으므로 + 1 더 해야 함.
        solve(0, 0);

        // sumArr값이 false인 index를 찾아 출력
        for (int i = 1; i <= maxSum + 1; i++) {
            if (!sumArr[i]) {
                System.out.println(i);
                break;
            }
        }
    }

    public static void solve(int idx, int sum) {
        if (idx == n) {
            sumArr[sum] = true;
            return;
        }
        // 현재 원소 포함
        solve(idx + 1, sum + s[idx]);
        // 현재 원소 포함 x
        solve(idx + 1, sum);
    }
}
