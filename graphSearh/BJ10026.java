// 적록색약
package graphSearh;
import java.util.*;

public class BJ10026 {
    static int n;
    static int cantDistinguish = 0; // 적록색약
    static int distinguish = 0; // 정상
    static char[][] graph;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 입력
        n = scanner.nextInt();
        scanner.nextLine();  // 버퍼 비우기
        graph = new char[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < n; j++) {
                graph[i][j] = line.charAt(j);  
            }
        }

        // 적록색약 x
        // 방문하지 않았으면 bfs 호출
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    distinguish += 1;
                    bfs(new int[] {i, j});
                }
            }
        }
        
        // 적록색약 o
        // green을 모두 red로 바꾸기
        visited = new boolean[n][n]; // 방문 배열 초기화
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == 'G') {
                    graph[i][j] = 'R';
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    cantDistinguish += 1;
                    bfs(new int[] {i, j});
                }
            }
        }

        System.out.print(distinguish + " ");
        System.out.println(cantDistinguish);
    }

    public static void bfs(int[] start) {
        Queue<int[]> queue = new LinkedList<>();
        int[] startArr = start;
        int startX = startArr[0];
        int startY = startArr[1];
        visited[startX][startY] = true;
        queue.add(new int[] {startX, startY});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];

            // 동서남북 보면서
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                    // 방문하지 않았고, 서로 같은 색상이면
                    if (!visited[nx][ny] && graph[nx][ny] == graph[cx][cy]) {
                        queue.add(new int[] {nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }   
}
