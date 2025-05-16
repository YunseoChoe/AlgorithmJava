// 구간 합 구하기 4
package DataStructure;
import java.util.*;

public class BJ11659 {
    static int n;
    static int m;
    static int[] num = {}; // 정적 배열 선언
    static ArrayList<Integer> acc = new ArrayList<>(); // 누적합 동적 리스트 선언
 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 입력
        n = scanner.nextInt();
        m = scanner.nextInt();

        num = new int[n]; // 배열 초기화
        for (int i = 0; i < n; i++) {
            num[i] = scanner.nextInt(); // 배열 값 입력
        }

        // 누적합 리스트 초기화
        int sum = 0;
        for (int i = 0; i < num.length; i++) {
            sum += num[i];
            acc.add(sum);
        }

        // 출력은 총 m번
        for (int i = 0; i < m; i++) {
            int[] twoArr = new int[2];
            for (int j = 0; j < twoArr.length; j++) {
                twoArr[j] = scanner.nextInt();
            }
          
            // i가 1일 때
            if (twoArr[0] - 1 == 0) {
                System.out.println(acc.get(twoArr[1] - 1));
            }

            // i가 0이 아닐 때
            else {
                System.out.println(acc.get(twoArr[1] - 1) - acc.get(twoArr[0] - 2));
            }
        }
    }
}
