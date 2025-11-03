// GCD 합
package basicMath;
import java.util.*;
import java.io.*;

public class BJ9613 {
    // 유클리드 호제법 (최대공약수)
    public static int getGcd(int first, int second) {
        if (second == 0) {
            return first;
        }
        return getGcd(second, first % second);
    }

    public static long pickNum(int[] arr) {
        long sum = 0;
        // 2개 조합 중복없이 뽑기
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                sum += getGcd(arr[i], arr[j]);
            }
        }

        return sum;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            System.out.println(pickNum(arr));
        }
    }
}
