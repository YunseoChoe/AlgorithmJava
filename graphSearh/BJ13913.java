// 숨바꼭질 4
package graphSearh;
import java.util.*;

public class BJ13913 {
    static int n, k, MAX = 100000;
    static int[] prev = new int[MAX + 1];
    static ArrayList<Integer> reversePath = new ArrayList<>();
    static boolean[] visited = new boolean[MAX + 1];

    public static void main (String[] main) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        solve(n);
    }

    public static void solve(int n) { // bfs
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {n, 0}); // 시간은 0초부터.
        prev[n] = -1; // 시작점의 이전 경로는 -1로 세팅.
        visited[n] = true;

        while (!queue.isEmpty()) {
            int cur[] = queue.poll();

            // 수빈 == 동생
            if (cur[0] == k) {
                System.out.println(cur[1]);

                backtracking(prev);
                Collections.reverse(reversePath); 
                for (int i : reversePath) {
                    System.out.print(i + " ");
                }
                break;
            }
            
            // 3가지의 위치 확인
            int[] nextPositions = {cur[0] - 1, cur[0] + 1, cur[0] * 2};
            for (int next : nextPositions) {
                if (0 <= next && next <= 100000 && !visited[next]) {
                    queue.add(new int[] {next, cur[1] + 1});
                    visited[next] = true;
                    prev[next] = cur[0]; // 경로 저장
                }
            }
        }
    }

    public static void backtracking(int[] prev) {
        int i = k;
        while (i != -1) {
            reversePath.add(i); 
            i = prev[i]; 
        }
    }
}
