// BOJ 1417 우선순위 큐 사용.
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static int n, ans = 0;
    static int[] candidate;
    static PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // 최대힙
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        if (n == 1) {
            System.out.println(0);
            return;
        }
        
        candidate = new int[n];

        for (int i = 0; i < n; i++) {
            candidate[i] = sc.nextInt();
            // 다솜이 제외 모든 참가자의 수 저장
            if (i != 0) {
                pq.add(candidate[i]);
            }
        }

        int dasomScore = candidate[0];

        // 다솜이가 1등일 때 까지 반복
        while (dasomScore <= pq.peek()) {
            // pq에서 최대값 꺼내서 -1
            int maxValue = pq.poll();
            pq.add(maxValue -1);

            // 다솜 +1
            dasomScore++;

            ans++;
        }

        System.out.println(ans);
    }
}
