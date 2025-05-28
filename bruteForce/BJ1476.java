// 날짜 계산
package bruteForce;
import java.util.*;

public class BJ1476 {
    static int e, s, m;
    public static void main(String[] args) {
        // 입력
        Scanner scanner = new Scanner(System.in);
        e = scanner.nextInt();
        s = scanner.nextInt();
        m = scanner.nextInt();
    
        // e, s, m 모두 똑같다면
        if (e == s && s == m) {
            System.out.println(e);
            System.exit(0); // 종료.
        }

        // s가 몇 바퀴 돌았는지 
        int bigS = 0;
        int index = 0; // 바퀴 수
        boolean isZero = false;

        while (!isZero) {
            bigS = (28 * index) + s;
            boolean isE = false;
            for (int i = 0; i < 7980 / 15; i++) {
                if (bigS - (15 * i) == e) {
                    isE = true;
                }
            }
            if (isE) { // e가 딱 떨어맞았을 경우에만 실행.
                for (int i = 0; i < 7980 / 19; i++) {
                    if (bigS - (19 * i) == m) {
                        isZero = true;
                        break; // 반복문 종료.
                    }
                }
            }
            
            index += 1; 
        }
        System.out.println(bigS);
    }
}
