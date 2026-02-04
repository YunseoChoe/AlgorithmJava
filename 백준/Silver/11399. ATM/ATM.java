import java.util.Scanner;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] p = new int[n];

        for (int i = 0; i < n; i++) {
            p[i] = sc.nextInt();
        }

        // 오름차순 정렬
        Arrays.sort(p);

        // 누적합 계산
        int totalMinValue = 0;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += p[i]; // 현재 사람까지 걸린 시간
            totalMinValue += sum; // 전체 대기 시간에 더하기
        }

        System.out.println(totalMinValue);
    }
}
