// 이항 계수 1
package basicMath;
import java.util.*;
import java.io.*;

public class BJ11050 {
    public static int solve(int n, int k) {
        // 분모
        int denominator = 1;
        for (int i = n; i > n - k; i--) {
            denominator *= i;
        }

        // 분자
        int numerator = 1;
        for (int i = k; i > k - k; i--) {
            numerator *= i;
        }

        return denominator / numerator;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        System.out.println(solve(n, k));   
    }
}
