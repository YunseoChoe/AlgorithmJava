// 아리토스테네스의 체
package basicMath;
import java.util.*;
import java.io.*;

public class BJ2960 {
    static int n, k, cnt = 0;
    static boolean[] arr;

    public static void solve() {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = true;
        }
        
        for (int i = 2; i <= n; i++) {
            // 소수면 해당 값의 배수들은 모두 소수가 아님
            if (arr[i]) {
                for (int j = i; j <= n; j = j + i) {
                    if (arr[j]) {
                        arr[j] = false;
                        cnt++;

                        if (cnt == k) {
                            System.out.println(j);
                            return;
                        }
                    }
                }
            }
        }
                
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new boolean[n + 1];

        solve();
    }
}
