// 인구 이동
package graphSearh;
import java.util.*;

public class BJ16234 {
    static int n, l, r, cnt;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        l = sc.nextInt();
        r = sc.nextInt();

        graph = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        solve();

        System.out.println(cnt);
    }   

    public static void solve() {
        while (true) {
            boolean opened = false;
            visited = new boolean[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j]) {
                        List<int[]> union = new ArrayList<>();
                        int sum = bfs(i, j, union);
                        
                        // union의 사이즈가 2이상일 경우에만 연합.
                        if (union.size() > 1) {
                            int avg = sum / union.size();
                            // 배열 재정의
                            for (int[] pos : union) {
                                graph[pos[0]][pos[1]] = avg; 
                            }
                            opened = true;
                        }
                    }
                }
            }
            
            // 국경이 한 번도 열리지 않았다면 종료.
            if (!opened) {
                break;
            }

            cnt += 1;
        }
    }

    public static int bfs(int startX, int startY, List<int[]> union) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {startX, startY});
        visited[startX][startY] = true;
        union.add(new int[] {startX, startY}); // 어차피 union의 size가 2이상인 것부터 연합.

        int sum = graph[startX][startY];

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];
            
            for (int k = 0; k < 4; k++) {
                int nx = cx + dx[k];
                int ny = cy + dy[k];

                // 범위, 방문하지 않았으면
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny]) {
                    int gap = Math.abs(graph[cx][cy] - graph[nx][ny]);
                    
                    if (gap >= l && gap <= r) {
                        visited[nx][ny] = true;
                        queue.add(new int[] {nx, ny});
                        union.add(new int[] {nx, ny});
                        sum += graph[nx][ny];
                    }
                }
            }
        }
        return sum;
    }
}
