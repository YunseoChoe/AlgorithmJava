// 수열
package prefixSum;
import java.util.*;

public class BJ2559 {
    static int n, k;
    static int[] arr = {};
    static ArrayList<Integer> acc = new ArrayList<>(); // 누적합 배열

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 입력
        n = scanner.nextInt();
        k = scanner.nextInt();

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt(); // -100 <= arr[i] <= 100
        }

        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            // 범위 쳌
            if (i + k  - 1< arr.length) {
                for (int j = i; j < i + k; j++) {
                    sum += arr[j];
                    
                }
                acc.add(sum);
            }
        }

        // 최대 온도의 합
        int maxDegree = acc.get(0); // 0으로 해놓으면 안 됨.
        for (int i = 0; i < acc.size(); i++) {
            if (acc.get(i) > maxDegree) {
                maxDegree = acc.get(i);
            }
        }
        System.out.println(maxDegree);
    }    
}
