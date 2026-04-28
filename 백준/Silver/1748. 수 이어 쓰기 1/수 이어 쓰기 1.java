// 수 이어 쓰기 1
// 문자열 말고 자릿수로
import java.util.*;

public class Main {
    static int n;
    static int quotient;
    static int cnt = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 입력
        n = scanner.nextInt();

        // 1부터 n까지
        for (int i = 1; i <= n; i++) {
            int num = i;
            while (true) {
                // 종료 조건: num / 10이 0일 때.
                if (num == 0) {
                    break;
                }
                cnt += 1;
                num /= 10;
            }
        }
       System.out.println(cnt);
    }
}
