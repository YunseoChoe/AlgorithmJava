// 베르트랑 공준
package basicMath;
import java.util.*;
import java.io.*;

public class BJ4948 {
    static int MAX_VALUE = 246913; // 2 * 123456 + 1
    static boolean[] arr = new boolean[MAX_VALUE + 1];

    public static void solve() {
        Arrays.fill(arr, true);

        arr[0] = arr[1] = false;

        for (int i = 2; (long)i * i <= MAX_VALUE; i++) { // long으로 형변환하여 오버플로우 오류 해결.
            if (arr[i]) {
                for (int j = i * i; j <= MAX_VALUE; j = j + i) {
                    arr[j] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        solve();
        
        while (true) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }

            int cnt = 0;
            for (int i = n + 1; i <= 2 * n; i++) {
                if (arr[i]) {
                    cnt++;
                }
            }

            System.out.println(cnt);
        }   
    }
}
