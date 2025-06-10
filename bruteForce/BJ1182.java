// 부분수열의 합 
// 백트래킹 방법 x
package bruteForce;
import java.util.*;

public class BJ1182 {
    static int n, s;
    static int[] num;
    static int cnt = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 입력
        n = scanner.nextInt();
        s = scanner.nextInt();
        num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = scanner.nextInt();
        }

        // 부분수열 탐색 시작
        makeSequence(0, 0);

        // 공집합 제외 처리 (공집합의 합이 0)
        if (s == 0) {
            cnt--;
        }

        // 정답 출력
        System.out.println(cnt);
    }

    public static void makeSequence(int index, int sum) {
        // 종료 조건: 
        if (index == n) { // 이 조건이 없으면, 모든 경우를 보지 않고 끝냄.
            if (sum == s) {
                cnt++;
            }
            return;
        }

        // 현재 인덱스의 값을 포함하는 경우
        makeSequence(index + 1, sum + num[index]);

        // 현재 인덱스의 값을 포함하지 않는 경우
        makeSequence(index + 1, sum);
    }
}
