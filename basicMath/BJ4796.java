// 캠핑
package basicMath;
import java.util.*;
import java.io.*;

public class BJ4796 {
    public static int solve(int l, int p, int v) {
        int quotient = v / p; // 몫
        int remainder = v % p; // 나머지

        // 나머지가 l보다 클 경우
        if (remainder > l) {
            return((p - (p - l)) * quotient) + l;
        }
        // 작을 경우
        else {
            return((p - (p - l)) * quotient) + remainder;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int cnt = 0;
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int l = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            if (l == 0 && p == 0 && v == 0) {
                break;
            }

            cnt++;
            System.out.println("Case " + cnt + ": " + Integer.toString(solve(l, p, v)));
        }
    }
}
