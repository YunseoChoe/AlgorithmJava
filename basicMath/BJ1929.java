// 소수 구하기
package basicMath;
import java.util.*;
import java.io.*;

public class BJ1929 {
    public static boolean solve(int num) {
        // TODO: m이상 n이하의 소수를 모두 반환
        // 1. m이상 n이하 번만큼 solve() 호출
        // 2. 한 번만 호출하고 int[]로 반환

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
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        
        for (int i = m; i <= n; i++) {
            if (solve(i)) {
                System.out.println(i);
            }
        }
    }
}
