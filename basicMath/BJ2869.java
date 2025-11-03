// 달팽이는 올라가고 싶다
package basicMath;
import java.util.*;
import java.io.*;

public class BJ2869 {
    public static int solve(int a, int b, int v) {
        int pos = 0;
        int ans = 0;
        while (pos < v) {
            pos += a;
            // 정상에 올라가지 못했다면
            if (pos < v) {
                pos -= b;
            } 
            ans++;
        }
        return ans;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        System.out.println(solve(a, b, v));
    }    
}
