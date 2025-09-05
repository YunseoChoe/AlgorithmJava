// 가장 긴 바이토닉 부분 수열
package DynamicProgramming;
import java.util.*;

public class BJ11054 {
    static int n;
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(solve());
    }

    public static int solve() {
        int maxValue = 0;
        int[] lisDp = new int[n]; // 증가 dp
        int[] ldsDp = new int[n]; // 감소 dp
        int[] bitonic = new int[n]; 

        // 증가 dp
        for (int i = 0; i < n; i++) {
            lisDp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    lisDp[i] = Math.max(lisDp[j] + 1, lisDp[i]);
                }
            }
        }
        
        // 감소 dp
        for (int i = n - 1; i >= 0; i--) {
            ldsDp[i] = 1;
            for (int j = n - 1; j > i; j--) {
                if (arr[i] > arr[j]) {
                    ldsDp[i] = Math.max(ldsDp[j] + 1, ldsDp[i]);
                }
            }
        }

        // 각각의 경우마다 바이토닉 구하기.
        for (int i = 0; i < n; i++) {
            bitonic[i] = lisDp[i] + ldsDp[i] - 1; // 자기자신 -1.
            maxValue = (maxValue < bitonic[i] ? bitonic[i] : maxValue);
        }
        return maxValue;
    }
}
