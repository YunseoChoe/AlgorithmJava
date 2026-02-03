// ATM
import java.util.Scanner;

public class Main {
    private static int n;
    private static int[] p;
    private static int[] answer;
    private static int totalMinValue = 0;

    public static void getMinValue() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                totalMinValue += p[answer[j] - 1];
            }
        }
    }

    public static void sort() {
        // p 복사
        int[] copyP = new int[n];
        for (int i = 0; i < n; i++) {
            copyP[i] = p[i];
        }

        // for문 돌때마다 제일 작은 값 찾고, 그 값은 max나 -1로 변경.
        for (int i = 0; i < n; i++) {
            // 최솟값 찾기
            int minValue = 1001;
            int minIndex = 0;
            for (int j = 0; j < n; j++) {
                
                if (minValue > copyP[j]) {
                    minValue = copyP[j];
                    minIndex = j;
                }
            }

            // 다 찾으면
            answer[i] = minIndex + 1;
            copyP[minIndex] = 1001;
        }
    }
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        p = new int[n];
        answer = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = sc.nextInt();
        }

        sort();
        getMinValue();
        
        System.out.println(totalMinValue);
    }  
}
