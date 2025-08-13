// 배열 돌리기1
package Implementation;
public class BJ16926 {
    static int n=2, m=2, r, tmp, dir = 0;
    static int[][] graph = {{6, 7}, {7, 8}};
    static boolean[][] visited = {{false, false}, {false, false}};

    static int[] dx = {1, 0, -1, 0}; // 하, 우, 상, 좌
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) {
        // 구역 나누기
        // for () {
        //     solve(); // 구역마다 solve() 진행.
        // }

        solve();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++){
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        } 
    }

    public static void solve() {
        int i = 0;
        int j = 0;

        visited[i][j] = true;
        tmp = graph[i][j];
        while (true) {
            // 종료 조건: 모두 방문했다면
            if (checkAllVisited(visited)) {
                graph[0][0] = tmp;
                break;
            }
            
            int num = tmp;
            // 범위 확인
            if (0 <= (i + dx[dir]) && (i + dx[dir]) < n && 0 <= (j + dy[dir]) && (j + dy[dir]) < m && !visited[i + dx[dir]][j + dy[dir]]) {
                i += dx[dir];
                j += dy[dir];
                visited[i][j] = true;
                tmp = graph[i][j];
                change(i, j, num);
            }
            // 범위가 맞지 않으면
            else {
                // 방향 바꾸기
                dir = (dir + 1) % 4; // !중요!
                continue;
            }
        }

    }

    public static void change(int nx, int ny, int num) {
        graph[nx][ny] = num;
    }

    public static boolean checkAllVisited(boolean[][] visited) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
