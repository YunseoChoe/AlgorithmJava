// 카잉달력
package basicMath;
import java.util.*;
import java.io.*;

public class BJ6064 {
    static int t;

    public static int solve(int m, int n, int x, int y) {
        // {x, y}는 몇번째
        int cnt = 1;
        int[] arr = {1, 1}; // 시작은 <1, 1>

        while (cnt <= m * n) { // 최대 반복 횟수를 m * n으로 설정.
            int num = 0; 
            // 종료조건
            if (arr[0] == x && arr[1] == y) {
                // System.out.println("arr[0] = " + arr[0] + ", arr[1]: " + arr[1]);
                return cnt;
            }

            // 0번째
            if (arr[0] < m) {
                arr[0]++;
         
            }
            else {
                arr[0] = 1;
            }
            

            // 1번째
            if (arr[1] < n) {
                arr[1]++;
         
            }
            else {
                arr[1] = 1;
            }

            cnt++;
        
        }
        return -1; // while (true)로 하면 해당 코드 실행 안 됨. (m * n)번까지 했는데도 return이 안 되면 -1 반환
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            System.out.println(solve(m, n, x, y));
        }
    }
}
