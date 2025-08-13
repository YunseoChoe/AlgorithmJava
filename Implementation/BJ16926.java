// 배열 돌리기 1
package Implementation;
public class BJ16926 {
    static int n = 2, m = 2;
    static int[][] graph = {
        {6, 7},
        {7, 8}
    };
    static boolean[][] visited = new boolean[n][m];

    // 시계방향
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) {
        solve();

        // 결과 출력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void solve() {
        int i = 0, j = 0, dir = 0;
        int startVal = graph[i][j];  
        visited[i][j] = true;

        for (int count = 0; count < n * m - 1; count++) {
            int nx = i + dx[dir];
            int ny = j + dy[dir];

            // 범위 벗어나거나 이미 방문했으면 방향 전환
            if (!isInRange(nx, ny) || visited[nx][ny]) {
                dir = (dir + 1) % 4;
                nx = i + dx[dir];
                ny = j + dy[dir];
            }
            System.out.println("dir: " + dir);

            // 한 칸씩 밀기
            graph[i][j] = graph[nx][ny];
            visited[nx][ny] = true;

            i = nx;
            j = ny;
        }

        // 마지막 칸에 시작값 넣기
        graph[i][j] = startVal;
    }

    public static boolean isInRange(int x, int y) {
        return (x >= 0 && x < n && y >= 0 && y < m);
    }
}
