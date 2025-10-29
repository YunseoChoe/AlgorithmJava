package Implementation;
import java.util.*;
import java.io.*;

public class BJ1952R {
    static int ans; // 정답
    static int[][] board;
    static boolean[][] visited;
    // 동남서북
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    
    public static boolean inRange(int nx, int ny, int m, int n) {
        if (0 <= nx && nx < m) {
            if (0 <= ny && ny < n) {
                return true;
            }
        } 
        return false;
    }

    public static void solve(int m, int n) {
        int cnt = 2;
        int dir = 0;
        int cx = 0;
        int cy = 0;
        visited[cx][cy] = true;
        board[cx][cy] = 1;

        while (cnt <= m * n) {
            // 이동할 위치 계산
            int nx = cx + dx[dir];
            int ny = cy + dy[dir];

            // 이동할 위치가 범위 안에 있거나, 방문하지 않았다면
            if (inRange(nx, ny, m, n) && !visited[nx][ny]) {
                visited[nx][ny] = true;
                board[nx][ny] = cnt + 1;
                cx = nx;
                cy = ny;
                cnt++;
            }

            // 이동할 위치가 범위 밖에 있거나, 이미 방문했다면
            else if (!inRange(nx, ny, m, n) || visited[nx][ny]) {
                // 다시 back하기
                nx = cx;
                ny = cy;

                // 방향 틀기
                dir = (dir + 1) % 4;

                nx = nx + dx[dir];
                ny = ny + dy[dir];

                if (inRange(nx, ny, m, n) && !visited[nx][ny]) {
                    board[nx][ny] = cnt;
                    visited[nx][ny] = true;
                    cx = nx;
                    cy = ny;
                    cnt++;
                    ans++;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken()); // 행
        int n = Integer.parseInt(st.nextToken()); // 열

        board = new int[m][n];
        visited = new boolean[m][n];

        solve(m, n);
        System.out.println(ans);
    }
}
