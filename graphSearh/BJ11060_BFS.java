// 점프 점프
package graphSearh;
import java.util.*;
import java.io.*;

public class BJ11060_BFS {
    static int n;
    static int[] a;
    static int[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = new int[n];
        visited = new int[n];
        Arrays.fill(visited, -1); // 점프를 하지 않고 바로 도착했을 경우를 대비해서 visited를 0이 아닌 -1로 초기화
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        solve();

        if (visited[n - 1] != -1) {
            System.out.println(visited[n - 1]);
        } 
        else {
            System.out.println(-1);
        }
    }

    public static void solve() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { 0, 0 });
        visited[0] = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int cnt = cur[1];

            // 1부터 a[x]까지
            for (int i = 1; i <= a[x]; i++) {
                int nx = x + i;
                // 방문하지 않았고, 범위 o
                if (0 <= nx && nx < n && visited[nx] == -1) {
                    queue.add(new int[] { nx, cnt + 1 });
                    visited[nx] = cnt + 1;
                }
            }
        }
    }
}
