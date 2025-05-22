// 블랙잭
import java.util.*;

public class BJ2798 {
    static int n, m;
    static int max = 0;
    static int[] cards;
    static ArrayList<Integer> arr = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 입력
        n = scanner.nextInt();
        m = scanner.nextInt();
        cards = new int[n];
        for (int i = 0; i < n; i++) {
            cards[i] = scanner.nextInt();
        }
        pickThreeCard(0);
        System.out.print(max);
    }

    public static void pickThreeCard(int index) {
        // 종료 조건: 3장을 다 뽑았다면
        if (arr.size() == 3) {
            // 합 구하기
            int sum = 0;
            for (int i = 0; i < 3; i++) {
                sum += arr.get(i);
            }
            // 합이 m이하이면 최댓값 갱신
            if (sum <= m) {
                max = Math.max(max, sum);
            }
            return;
        }

        for (int i = index; i < n; i++) {
            arr.add(cards[i]);
            pickThreeCard(i + 1);
            arr.remove(arr.size() - 1);
        }
    }
}
