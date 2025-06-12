// 안전 영역
package graphSearh;
import java.util.*;

public class BJ2468 {
    static int n;
    static int maxArea = 0;
    static int maxHeight;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 입력
        n = scanner.nextInt();
        graph = new int[n][n];
    
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = scanner.nextInt();
                // 최대 높이 구하기
                if (maxHeight < graph[i][j]) {
                    maxHeight = graph[i][j];
                }
            }
        }

        // 물에 잠구기
        for (int i = 1; i < maxHeight; i++) { 
            // visited 초기화
            visited = new boolean[n][n]; // 기본값으로 false.
            int[][] tempGraph = new int[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    tempGraph[j][k] = graph[j][k];
                }
            }

            getWet(i, tempGraph); // 복사한 값을 넘겨주기.

            // 안전 영역 새기
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (tempGraph[j][k] != 0 && visited[j][k] == false) { // 물에 잠기지 않았고, 방문하지 않은 부분부터.
                        cnt += 1;
                        bfs(new int[] {j, k}, tempGraph); // 복사한 graph를 사용해야 함.
                    }
                }
            }
            // 최댓값 갱신
            maxArea = Math.max(cnt, maxArea);
        }
        System.out.println(maxArea);
    }

    // 물에 잠구는 함수
    public static void getWet(int height, int[][] graph) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] <= height) {
                    graph[i][j] = 0; // 물에 잠김.
                }
            }
        }
    }

    public static void bfs(int[] start, int[][] graph) {
        Queue<int[]> queue = new LinkedList<>();
        int[] startArr = start;
        int startX = startArr[0];
        int startY = startArr[1];
        queue.add(start);
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int current[] = queue.poll();
            int cx = current[0];
            int cy = current[1];
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                // 방문하지 않았고, 물에 잠겨있지 않으면
                if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                    if (!visited[nx][ny] && graph[nx][ny] != 0) {
                        queue.add(new int[] {nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }
}
