// 테트로미노
package graphSearh;
import java.util.*;

public class BJ14500 {
    static int n, m;
    static int maxSum = 0;
    static boolean[][] visited;
    static int[][] board;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        board = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        // 함수 호출
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true; 
                solve(1, board[i][j], i, j);
                visited[i][j] = false;
            }
        }
        System.out.println(maxSum);
    }

    public static void solve(int depth, int sum, int x, int y) {
        if (depth == 4) {
            maxSum = Math.max(sum, maxSum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                if (!visited[nx][ny]) {
                    // ㅗ, ㅜ, ㅏ, ㅓ 예외처리를 하는 코드가 필요
                    if (depth == 2) {
                        visited[nx][ny] = true;
                        solve(depth + 1, sum + board[nx][ny], x, y); // depth와 sum은 갱신, 좌표는 이동 x
                        visited[nx][ny] = false;
                        // return을 하지 않은 이유: 다른 모양도 봐야하기 때문.
                    }
                    // 그 외 다른 모양을 위한 코드
                    visited[nx][ny] = true;
                    solve(depth + 1, sum + board[nx][ny], nx, ny);
                    visited[nx][ny] = false;
                }
            }
        }
    }
}
