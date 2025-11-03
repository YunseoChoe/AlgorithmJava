// 팩토리얼 0의 개수
package basicMath;
import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class BJ1676 {
    public static String solve(int n) {
        int num = n;
        BigInteger sum = BigInteger.ONE;
        while (num != 1) {
            sum = sum.multiply(BigInteger.valueOf(num)); // BigInteger은 객체이므로 연산자를 사용할 수 없음 (sum *= num)
            num--;
        }

        // sum 문자열로 변환
        return String.valueOf(sum);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // 0! = 1이므로 0.
        if (n == 0) {
            System.out.println(0);
            return;
        } 

        // 팩토리얼 값 구하기
        String fac = solve(n);

        // 0의 개수 구하기
        int cnt = 0;
        int idx = fac.length() - 1;
        while (idx >= 0 && fac.charAt(idx) == '0') {
            cnt++;
            idx--;
        }

        System.out.println(cnt);
    }
}
