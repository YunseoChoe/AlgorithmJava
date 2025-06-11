// 부분 수열의 합
package bruteForce;
import java.util.*;

public class BJ14225 {
    static int n;
    static int findValue;
    static int[] num;
    static HashSet<Integer> sumSet = new HashSet<>(); 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 입력
        n = scanner.nextInt();
        num = new int[n];
        for (int i = 0; i < n; i++)  {
            num[i] = scanner.nextInt();
        }

        makeSequence(0, 0);

        // 최대합 찾기
        int maxSum = Collections.max(sumSet);

        // 1부터 자연수 중에서 arr에 있지 않으면
        for (int i = 1; i <= maxSum + 1; i++) { 
            if (!sumSet.contains(i)) {
                findValue = i;
                break;
            } 
        }
        System.out.println(findValue);
    }

    public static void makeSequence(int idx, int sum) {
        // 종료 조건
        if (idx == n) {
            // sum값들 중복 없이 추가
            sumSet.add(sum); // ArrayList를 사용해서, 중복 없이 값을 넣으려고 할 때 시간초과 발생함.
            return;
        }

        // 현재 원소 넣기
        makeSequence(idx + 1, sum + num[idx]);
        // 현재 원소 안 넣기
        makeSequence(idx + 1, sum);
    }
}
