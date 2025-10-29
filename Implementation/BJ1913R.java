package Implementation;
import java.util.*;
import java.io.*;

public class BJ1913R {
    static int[][] board;
    static boolean[][] visited;
    // 북동남서
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static int[] findIdx(int value, int n) {
        int[] idx;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == value) {
                    return new int[]{i, j};
                }
            }
        }
        return null; // 찾지 못했을 경우
    }

    public static boolean inRange(int nx, int ny, int n) {
        if (0 <= nx && nx < n && 0 <= ny && ny < n) {
            return true;
        }
        return false;
    }

    public static void solve(int i, int j, int n) {
        int cnt = 2;
        int cx = i;
        int cy = j;
        int dIndex = 3; // 3부터 시작해야 +1하면 북.
        visited[cx][cy] = true;
        board[cx][cy] = 1;

        while (cnt <= n * n) {
            int nextDIndex = (dIndex + 1) % 4;
            int nx = cx + dx[nextDIndex];
            int ny = cy + dy[nextDIndex];

            // 이동할 곳이 방문하지 않은 곳이라면
            if (inRange(nx, ny, n) && !visited[nx][ny]) {
                cx = nx;
                cy = ny;
                visited[nx][ny] = true;
                board[nx][ny] = cnt;
                
                // 방향 전환
                dIndex = nextDIndex;
            }

            // 이동할 곳이 방문한 곳이라면
            else {
                // 이전 방향 그대로 직진
                nx = cx + dx[dIndex];
                ny = cy + dy[dIndex];

                if (inRange(nx, ny, n) && !visited[nx][ny]) {
                    cx = nx;
                    cy = ny;

                    visited[nx][ny] = true;
                    board[nx][ny] = cnt;                     
                }
            }

            // 방문 여부 상관없이 while문이 증가할수록 cnt값은 +1.
            cnt += 1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(br.readLine());
        int findValue = Integer.parseInt(br.readLine());

        board = new int[n][n];
        visited = new boolean[n][n];

        // 시작 위치
        int i = n / 2;
        int j = n / 2;

        solve(i, j, n);
        int[] result = findIdx(findValue, n);

        for (int a = 0; a < n; a++) {
            for (int b = 0; b < n; b++) {
                System.out.print(board[a][b] + " ");
            }
            System.out.println();
        }
        for (int idx : result) {
            System.out.print(idx + 1 + " ");
        }
    }
}
