// 이전순열
package Implementation;
import java.io.*;
import java.util.*;

public class BJ10973 {
    static int n, target, targetIdx, swapValueIdx, swapValue = -1;
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
        int[] sortedList = Arrays.copyOf(list, list.length); // 복사
        Arrays.sort(sortedList); // 정렬

        // 오름차순으로 정렬되어 있으면
        if (Arrays.equals(sortedList, list)) { // 배열의 주소가 아닌 내용을 비교.
            System.out.println(-1);
            System.exit(0); // 바로 종료
        }
    
        // target 찾기
        for (int i = n - 1; i >= 1; i--) {
            if (list[i - 1] > list[i]) {
                target = list[i - 1];
                targetIdx = i - 1;
                break;
            }
        }

        /* 내림차순 정렬 */
        // target 오른쪽 값들 중, target보다 작으면서 제일 큰 값 찾기
        for (int i = targetIdx + 1; i < n; i++) {
            if (target > list[i]) {
                if (swapValue < list[i]) {
                    swapValue = list[i];
                    swapValueIdx = i;
                }
            }
        }

        // swap
        swap(list, swapValueIdx, targetIdx);

        // 내림차순 정렬할 부분 복사
        Integer[] sub = new Integer[n - (targetIdx + 1)];         
        for (int i = targetIdx + 1; i < n; i++) {
            sub[i - (targetIdx + 1)] = list[i];
        }

        // 내림차순 정렬
        Arrays.sort(sub, Collections.reverseOrder());             

        // list에 반영
        for (int i = 0; i < sub.length; i++) {                    
            list[targetIdx + 1 + i] = sub[i];
        }
    }

    public static void swap(int[] arr, int a, int b) { // java의 매개변수는 값을 복사하므로, 배열 값 자체를 바꿔줘야 함.
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
