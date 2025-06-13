// 연구소
package graphSearh;
import java.util.*;

public class BJ14502 {
    static int n, m, safeZoneCnt;
    static int[][] map;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 입력
        n = scanner.nextInt();
        m = scanner.nextInt();
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = scanner.nextInt();
            }
        }

        func(0); // 벽 세우면서 바이러스 퍼뜨리기.
        System.out.println(safeZoneCnt);
    }

    public static void func(int cnt) {
        // 벽을 다 세우면
        if (cnt == 3) {
            // 바이러스 퍼뜨린 후,
            bfs();
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    func(cnt + 1);
                    map[i][j] = 0; // 백트래킹
                }
            }
        }
    }

    public static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        int[][] temp = new int[n][m];

        // 바이러스들을 queue에 미리 넣어두기.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 2) {
                    queue.add(new int[] {i, j});
                }
                temp[i][j] = map[i][j]; // map 복사본 생성.
            }
        }

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];
            // 동서남북
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (temp[nx][ny] == 0) {
                        temp[nx][ny] = 2; // 바이러스 퍼뜨리기.
                        queue.add(new int[] {nx, ny});
                    }
                }
            }
        }

        // 최대 안전영역 갱신
        safeZoneCnt = Math.max(safeZone(temp), safeZoneCnt);
    }

    static public int safeZone(int[][] map) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    cnt += 1;
                }
            }
        }
        return cnt;
    }
}
