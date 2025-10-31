// 소수 구하기
package basicMath;
import java.util.*;
import java.io.*;

public class BJ1929 {
    static int m, n;
    static boolean[] isPrime;

    public static void solve() {
        // 에라토스테네스의 체
        isPrime = new boolean[n + 1];
        for (int i = 0; i < isPrime.length; i++) {
            isPrime[i] = true;
        }

        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i <= n; i++) { // 항상 2부터 시작해야 함, n의 제곱근까지 확인
            // 해당 수가 소수라면
            if (isPrime[i]) {
                // 해당 수를 제외한 모든 배수들 false처리
                for (int j = i * i; j <= n; j = j + i) {
                    isPrime[j] = false;
                }
            }
        }   
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        solve();

        for (int i = m; i <= n; i++) {
            if (isPrime[i]) {
                System.out.println(i);
            }
        }
    }
}
