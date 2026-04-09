// 콘센트 - 우선순위 큐
import java.util.*;

public class Main {
    static int n, m, time = 0;
    static Integer[] t;

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 최소힙
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        t = new Integer[n];
        for (int i = 0; i < n; i++) {
            t[i] = sc.nextInt();
        }
        
        // 내림차순 정렬
        Arrays.sort(t, Collections.reverseOrder());
        
        for (int i = 0; i < n; i++) {
            // pq가 꽉 차있다면
            if (pq.size() >= m) {
                time = pq.poll();
            }

            pq.add(time + t[i]);
        }

        // pq 중 최댓값 출력
        while (!pq.isEmpty()) {
            time = pq.poll();
        }

        System.out.println(time); 
    }
}
