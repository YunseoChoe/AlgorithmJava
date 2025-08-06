// 숨바꼭질
package graphSearh;
import java.util.*;

public class BJ1697 {
    static int n, k;
    static boolean[] visited = new boolean[100001];

    public static void main (String[] main) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        solve(n);
    }

    public static void solve(int n) { // bfs
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {n, 0}); // 시간은 0초부터
        visited[n] = true;

        while (!queue.isEmpty()) {
            int cur[] = queue.poll();

            // 수빈 == 동생
            if (cur[0] == k) {
                System.out.println(cur[1]);
                break;
            }
            
            // 3가지의 위치 확인
            int[] nextPositions = {cur[0] - 1, cur[0] + 1, cur[0] * 2};
            for (int next : nextPositions) {
                if (0 <= next && next <= 100000 && !visited[next]) {
                    queue.add(new int[] {next, cur[1] + 1});
                    visited[next] = true;
                }
            }
        }
    }
}
