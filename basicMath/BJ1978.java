// 소수 찾기
package basicMath;
import java.util.*;
import java.io.*;

public class BJ1978 {
    static int n;

    public static boolean isPrimeNumber(int num) {
        ArrayList<Integer> divisor = new ArrayList<>();
        if (num > 1) {
            // 모든 약수 구하기 (divisor)
            for (int i = 1; i <= num; i++) {
                if (num % i == 0) {
                    divisor.add(i);
                }
            }
            // 약수가 1과 자기 자신뿐이면
            if (divisor.size() == 2) {
                if (divisor.get(0) == 1 && divisor.get(1) == num) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int solve(int[] arr) {
        // TODO: arr중 소수 개수 반환
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (isPrimeNumber(arr[i])) {
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solve(arr));
    }
}
