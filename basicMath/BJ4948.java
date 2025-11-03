// 베르트랑 공준
package basicMath;
import java.util.*;
import java.io.*;

public class BJ4948 {
    public static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int solve(int n) {
        int cnt = 0;
        for (int i = n + 1; i <= 2 * n; i++) {
            // 소수이면
            if (isPrime(i)) {
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }
            System.out.println(solve(n));
        }
    }   
}
