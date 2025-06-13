// 토마토
package graphSearh;
import java.util.*;
 
public class BJ7569 {
    static int n;
    static int m;
    static int h;
    static int minDay = 0;
    static int[][][] tomatos;
    static boolean[][][] visited;
    // 동서남북상하
    static int[] dh = {0, 0, 0, 0, -1, 1};
    static int[] dx = {0, 0, 1, -1, 0, 0};
    static int[] dy = {1, -1, 0, 0, 0, 0};
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 입력
        m = scanner.nextInt(); // 열
        n = scanner.nextInt(); // 행
        h = scanner.nextInt(); // 높이

        tomatos = new int[h][n][m]; 
        visited = new boolean[h][n][m]; 
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    tomatos[i][j][k] = scanner.nextInt();
                }
            }
        }

        // 모든 토마토가 다 익어있다면
        boolean isBoiled = true;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (tomatos[i][j][k] == 0) {
                        isBoiled = false;
                    }    
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
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    // 익지 못한 토마토가 있다면
                    if (tomatos[i][j][k] == 0) {
                        System.out.println(-1);
                        System.exit(0);
                    }
                    // 최솟값 찾기
                    minDay = Math.max(minDay, tomatos[i][j][k]);
                }
            }
        }

        System.out.println(minDay - 1);
    }

    public static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        // 익은 토마토들을 queue에 넣어두기 (익은 곳부터 시작해야 하고, 0부터 시작해야 함.)
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (tomatos[i][j][k] == 1) {
                        queue.add(new int[] {i, j, k});
                        visited[i][j][k] = true;
                    }
                }  
            }
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int ch = cur[0];
            int cx = cur[1];
            int cy = cur[2];
            // 동서남북상하 (6방향)
            for (int i = 0; i < 6; i++) {
                int nh = ch + dh[i];
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                // 범위
                if (0 <= nh && nh < h && 0 <= nx && nx < n && 0 <= ny && ny < m) {
                    // 방문하지 않았고, 익지 않았다면
                    if (!visited[nh][nx][ny] && tomatos[nh][nx][ny] == 0) {
                        queue.add(new int[] {nh, nx, ny});
                        tomatos[nh][nx][ny] = tomatos[ch][cx][cy] + 1; // 익히기
                        visited[nh][nx][ny] = true;
                    }
                }
            }
        }
    }
}
