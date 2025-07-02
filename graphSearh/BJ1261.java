// 알고스팟
package graphSearh;
import java.io.*;
import java.util.*;

public class BJ1261 {
    static int n, m;
    static int[][] board;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		board = new int[n][m];
        visited = new boolean[n][m];
		
		for(int i = 0; i < n; i++) {
			String[] line = br.readLine().split("");
			for(int j = 0; j < m; j++) {
				int num = Integer.parseInt(line[j]);
				board[i][j] = num;
			}
		}
        
        solve();
    }

    public static void solve() {
        Deque<int[]> deque = new LinkedList<>(); 
        deque.add(new int[] {0, 0, 0});
        visited[0][0] = true;

        while (!deque.isEmpty()) {
            int[] cur = deque.poll();
            // 도착했다면
            if (cur[0] == n - 1 && cur[1] == m - 1) {
                System.out.println(cur[2]);
                System.exit(0);
            }

            // 이동
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (0 <= nx && nx < n && 0 <= ny && ny < m && !visited[nx][ny]) {
                    // 0이면 '앞'에 삽입
                    if (board[nx][ny] == 0) {
                        visited[nx][ny] = true;
                        deque.addFirst(new int[] {nx, ny, cur[2]});
                    } 
                    // 1이면 '뒤'에 삽입
                    else if (board[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        deque.add(new int[] {nx, ny, cur[2] + 1});
                    }
                }
            }
        }
    }
} 
