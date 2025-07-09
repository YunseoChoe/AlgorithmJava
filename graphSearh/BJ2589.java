// 보물섬
package graphSearh;
import java.util.*;
import java.io.*;

public class BJ2589 {
    static int n, m;
    static char[][] board;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int maxDist = 0; 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] list = br.readLine().split(" ");
        n = Integer.parseInt(list[0]);
        m = Integer.parseInt(list[1]);
        board = new char[n][m];
        
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                board[i][j] = line[j].charAt(0);
            }
        }

        for (int i = 0; i < n; i++) {  
            for (int j = 0; j < m; j++) {
                // 육지인 곳 모두 보기
                if (board[i][j] == 'L') {
                    visited = new boolean[n][m]; // visited 초기화.
                    solve(i, j);
                }
            }
        }

        System.out.println(maxDist);
    }

    public static void solve(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {startX, startY, 0});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (0 <= nx && nx < n && 0 <= ny && ny < m && !visited[nx][ny] && board[nx][ny] == 'L') {
                    queue.add(new int[] {nx, ny, cur[2] + 1});
                    visited[nx][ny] = true;
                    maxDist = Math.max(maxDist, cur[2] + 1); // 최단 거리 최댓값 갱신.
                }
            }
        }
    }
}
