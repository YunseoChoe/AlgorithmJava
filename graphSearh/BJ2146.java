// 다리 만들기
package graphSearh;
import java.util.*;

public class BJ2146 {
    static int n;
    static int labelNum = 2; // 대륙과 구분하기 위하여 2부터.
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        graph = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 대륙이고, 방문하지 않았다면
                if (graph[i][j] == 1 && !visited[i][j]) {
                    label(new int[] {i, j});
                    labelNum += 1;
                }
            }
        }

        // 라벨링 후
        int distance = Integer.MAX_VALUE;
        for (int i = 2; i < labelNum; i++) {
            visited = new boolean[n][n];
            distance = Math.min(distance, bfs(i));
        }
        System.out.println(distance);
    }

    public static void label(int[] start) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        int sx = start[0];
        int sy = start[1];
        graph[sx][sy] = labelNum;
        visited[sx][sy] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                    if (!visited[nx][ny] && graph[nx][ny] == 1) {
                        graph[nx][ny] = labelNum;
                        visited[nx][ny] = true;
                        queue.add(new int[] {nx ,ny});
                    }
                    
                }
            }
        }
    }

    public static int bfs(int label) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == label) {
                    queue.add(new int[] {i, j, 0}); // x, y, 거리
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];
            int cdist = cur[2];
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                    // 다른 대륙을 발견했다면
                    if (graph[nx][ny] != 0 && graph[nx][ny] != label) {
                        return cdist;
                    }
                    // 방문 x, 바다면 (대륙 끝 부분만 본다는 소리)
                    else if (!visited[nx][ny] && graph[nx][ny] == 0) {
                        queue.add(new int[] {nx, ny, cdist + 1});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        return Integer.MAX_VALUE; 
    }
}
