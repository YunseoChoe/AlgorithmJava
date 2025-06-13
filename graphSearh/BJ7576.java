// 토마토
package graphSearh;
import java.util.*;

public class BJ7576 {
    static int n;
    static int m;
    static int minDay = 0;
    static int[][] tomatos;
    static boolean[][] visited;
    static int[] dx = { 0, 0, 1, -1 };
    static int[] dy = { 1, -1, 0, 0 };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 입력
        m = scanner.nextInt(); // 열
        n = scanner.nextInt(); // 행
        tomatos = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                tomatos[i][j] = scanner.nextInt();
            }
        }

        // 모든 토마토가 다 익어있다면
        boolean isBoiled = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tomatos[i][j] == 0) {
                    isBoiled = false;
                }
            }
        }
        if (isBoiled) {
            System.out.println(0);
            System.exit(0);
        }

        // 아니라면
        bfs();
        
        // 다 익힌 후,
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 익지 못한 토마토가 있다면
                if (tomatos[i][j] == 0) {
                    System.out.println(-1);
                    System.exit(0);
                }
                // 최솟값 찾기
                minDay = Math.max(minDay, tomatos[i][j]);
            }
        }

        System.out.println(minDay - 1);
    }

    public static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        // 익은 토마토들을 queue에 넣어두기 (익은 곳부터 시작해야 하고, 0부터 시작해야 함.)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tomatos[i][j] == 1) {
                    queue.add(new int[] {i, j});
                    visited[i][j] = true;
                }
            }
        }
  
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];
            // 동서남북
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                // 범위
                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    // 방문하지 않았고, 익지 않았다면
                    if (!visited[nx][ny] && tomatos[nx][ny] == 0) {
                        queue.add(new int[] { nx, ny });
                        tomatos[nx][ny] = tomatos[cx][cy] + 1; // 익히기
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }
}
