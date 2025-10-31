// 소수 찾기
package basicMath;
import java.util.*;
import java.io.*;

public class BJ1978 {
    static int n;

    public static boolean solve(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i < num; i++) {
            // 소수가 아닌 조건 (2보다 크고, num보다 작은 수 중 0으로 나눠 떨어지는 값이 있으면)
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        for (int x : arr) {
            if (solve(x)) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
