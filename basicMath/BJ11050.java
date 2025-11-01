// 이항 계수 1
package basicMath;
import java.util.*;
import java.io.*;

public class BJ11050 {
    static int n, k, cnt = 0;
    static int[] arr;

    public static void solve(int depth, int start) {
        // 조합
        if (depth == k) {
            cnt++;
            return;
        }
        
        for (int i = start; i <= n; i++) {
            arr[depth] = i;
            solve(depth + 1, i + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n];
        
        solve(0, 1);
        System.out.println(cnt);
    }
}
