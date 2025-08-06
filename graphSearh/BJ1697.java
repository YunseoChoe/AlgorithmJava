// 숨바꼭질
package graphSearh;
import java.util.*;

public class BJ1697 {
    static int n, k;
    static int[] ways = {1, -1, 2};
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
            
            // 3가지의 위치 모두 보기
            int newPos;
            for (int i : ways) {
                newPos = (i != 2) ? cur[0] + i : cur[0] * i;
                if (0 <= newPos && newPos <= 100000 && !visited[newPos]) {
                    queue.add(new int[] {newPos, cur[1] + 1});
                    visited[newPos] = true;
                }
            }
        }
    }
}
