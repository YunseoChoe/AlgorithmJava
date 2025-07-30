// 달팽이2
package Implementation;
import java.util.*;
import java.io.*;

public class BJ1952 {
    static int m, n, turnCnt = 0;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();

        graph = new int[m][n];
        visited = new boolean[m][n];

        solve();

        System.out.println(turnCnt - 1);
    }   

    public static void solve() {
        int num = 1;
        int i = 0;
        int j = 0;
        int d = 0;

        while (true) {
            // 종료조건
            if (num > n * m) {
                break;
            }

            graph[i][j] = num;
            visited[i][j] = true;

            int ni = i + dx[d];
            int nj = j + dy[d];
            
            // 범위 o
            if (0 <= ni && ni < m && 0 <= nj && nj < n) {
                // 방문하지 않았다면
                if (!visited[ni][nj]) {
                    // 이동
                    i = ni;
                    j = nj;
                }
                // 방문했다면
                else {
                    // 방향 변경 후 이동
                    d = (d + 1) % 4;
                    i += dx[d];
                    j += dy[d];
                    turnCnt += 1;
                }
            }
            // 범위 x
            else {
                // 방향 변경 후 이동
                d = (d + 1) % 4;
                i += dx[d];
                j += dy[d];
                turnCnt += 1;
            }

            num += 1;
        }
    }
}
