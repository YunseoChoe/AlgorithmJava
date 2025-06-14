// 연구소 4
package graphSearh;
import java.util.*;

public class BJ17141 {
    static int n, m;
    static ArrayList<Integer> timeArr = new ArrayList<>();
    static int[][] map;
    static int[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = scanner.nextInt();
            }
        }

        func(0, 0, 0); 
        if (timeArr.size() == 0) {
            System.out.println(-1);
        }
        else {
            System.out.println(Collections.min(timeArr));
        }
    }

    public static void func(int cnt, int x, int y) {
        // 바이러스를 다 놓았으면
        if (cnt == m) {
            // 바이러스 퍼뜨리기
            visited = new int[n][n]; 
            // map 복사본 생성
            int[][] temp = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    temp[i][j] = map[i][j];
                }
            }
            bfs(temp);

            int time = -1;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // 바이러스가 다 퍼지지 않았다면 (모든 경우에서 다 퍼지지 않는다면 timeArr는 결국 빈 값)
                    if (temp[i][j] == 0 || temp[i][j] == 2) { // 0 또는 2는 바이러스가 다 퍼지지 않은 곳
                        return;
                    }
                    // 바이러스이면
                    if (temp[i][j] == -1) {
                        if (time < visited[i][j]) {
                            time = visited[i][j];
                        }
                    }
                }    
            }
            timeArr.add(time - 1); 
            return;
        }

        for (int i = x; i < n; i++) {
            int nj = (i == x) ? y : 0;
            for (int j = nj; j < n; j++) {
                if (map[i][j] == 2) { 
                    map[i][j] = -1; // 빈 칸과 구분하기 위하여 0이 아닌 -1로 지정.
                    func(cnt + 1, i, j + 1);
                    map[i][j] = 2;
                }
            }
        }
    }

    public static void bfs(int[][] temp) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == -1) {
                    queue.add(new int[] {i, j});
                    visited[i][j] = 1;
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
                if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                    // 방문하지 않았고, 벽이 아니면 (0 또는 2)
                    if (visited[nx][ny] == 0 && temp[nx][ny] != 1) {
                        temp[nx][ny] = -1; // 전파
                        queue.add(new int[] {nx, ny});
                        visited[nx][ny] = visited[cx][cy] + 1;
                    }
                }
            }
        }        
    }
}
