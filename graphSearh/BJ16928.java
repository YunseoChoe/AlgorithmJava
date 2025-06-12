// 뱀과 사다리 게임
package graphSearh;
import java.util.*;

public class BJ16928 {
    static int n;
    static int m;
    static int[] arr = new int[101];
    static int[] dist = new int[101]; 
    static boolean[] visited = new boolean[101];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 1; i <= 100; i++) {
            arr[i] = i;
        }

        // 입력
        n = scanner.nextInt();
        m = scanner.nextInt();

        // 사다리 정보 입력
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            arr[x] = y;
        }

        // 뱀 정보 입력
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            arr[u] = v;
        }

        bfs(1); 
    }

    public static void bfs(int start) { // 최솟값을 구하는 문제이므로 bfs 사용
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        dist[start] = 0; // 처음 거리는 0.

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (cur == 100) {
                System.out.println(dist[cur]);
                break;
            }
            // 주사위 굴리기 (1-6)
            for (int i = 1; i <= 6; i++) {
                int next = cur + i;
                // 범위
                if (next <= 100) {
                    // 방문하지 않은 칸만 (어차피 최솟값이므로 한 번만 갱신하면 됨)
                    if (!visited[arr[next]]) {
                        queue.offer(arr[next]);
                        visited[arr[next]] = true;
                        dist[arr[next]] = dist[cur] + 1; // 거리 갱신.
                    }
                }
            }
        }
    }
}
