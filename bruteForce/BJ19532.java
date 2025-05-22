// 수학은 비대면강의입니다
// 백트래킹 -> 브루트 포스 방법으로 변경.
package bruteForce;
import java.util.*;

public class BJ19532 {
    static int a, b, c, d, e, f;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        a = scanner.nextInt();
        b = scanner.nextInt();
        c = scanner.nextInt();
        d = scanner.nextInt();
        e = scanner.nextInt();
        f = scanner.nextInt();
        
        for (int i = -999; i <= 999; i++) {
            for (int j = -999; j <= 999; j++) {
                int x = i;
                int y = j;
                // 식이 성립하면
                if ((a * x + b * y == c) && (d * x + e * y == f)) {
                    // x, y 출력 후 return
                    System.out.print(x + " ");
                    System.out.println(y);
                    return;
                }
            }   
        }
    }   
}
