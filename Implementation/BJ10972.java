// 다음 순열
package Implementation;
import java.io.*;
import java.util.*;

public class BJ10972 {
    static int n, target, targetIdx, swapValueIdx, swapValue = 10001;
    static boolean isLast = false;
    static int[] list;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        String[] line = br.readLine().split(" ");
        list = new int[n]; // 새로운 정수형 배열 선언.
        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(line[i]);
        }

        solve(list);

        for (int i = 0; i < n; i++) {
            System.out.print(list[i] + " ");
        }    
    }

    public static void solve(int[] list) {
        // 마지막 순열이면
        for (int i = 0; i < n - 1; i++) {
            if (list[i] < list[i + 1]) {
                isLast = true;
            }
        }
        if (!isLast) {
            System.out.println(-1);
            System.exit(0); // 바로 종료
        }

        // target 찾기
        for (int i = n - 1; i >= 1; i--) {
            if (list[i - 1] < list[i]) {
                target = list[i - 1];
                targetIdx = i - 1;
                break;
            }
        }

        // target 오른쪽 값들 중, target보다 크면서 제일 작은 값 찾기
        for (int i = targetIdx + 1; i < n; i++) {
            if (target < list[i]) {
                if (swapValue > list[i]) {
                    swapValue = list[i];
                    swapValueIdx = i;
                }
            }
        }

        // swap
        swap(list, swapValueIdx, targetIdx);

        // 정렬
        Arrays.sort(list, targetIdx + 1, n); // 시작은 포함, 끝은 포함 x
    }

    public static void swap(int[] arr, int a, int b) { // java의 매개변수는 값을 복사하므로, 배열 값 자체를 바꿔줘야 함.
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
