// 연결 요소의 개수
package graphSearch;
import java.util.*;
import java.io.*;

public class BJ11724 {
    static int n, m, cnt = 0;
    static int[][] board;
    static boolean[] visited;

    public static void dfs(int node) {
        visited[node] = true;

        for (int i = 0; i < n; i++) {
            if (board[node][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;    

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i = 0; i < n; i++) {
                // 연결되어 있고, 방문하지 않았으면
                if (board[cur][i] == 1 && !visited[i]) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][n];
        visited = new boolean[n];

        // 간선 입력
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            board[a][b] = 1;
            board[b][a] = 1;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(i);
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
