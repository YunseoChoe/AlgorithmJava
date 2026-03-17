
import java.util.*;

public class Main {
    static int n;
    static int[][] board;
    static boolean[][] visited;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static int dfs(int x, int y) {
        visited[x][y] = true;
        int count = 1; // 전체 집의 개수

        // 동서남북
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            // 범위 체크
            if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                // 집이 있고 + 방문 안 했으면
                if (board[nx][ny] == 1 && !visited[nx][ny]) {
                    count += dfs(nx, ny);
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        board = new int[n][n];
        visited = new boolean[n][n];

        // 입력
        for (int i = 0; i < n; i++) {
            String line = sc.next();
            for (int j = 0; j < n; j++) {
                board[i][j] = line.charAt(j) - '0';
            }
        }

        ArrayList<Integer> result = new ArrayList<>();

        // 전체 탐색
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1 && !visited[i][j]) {
                    int size = dfs(i, j);
                    result.add(size);
                }
            }
        }

        // 정렬
        Collections.sort(result);

        // 출력
        System.out.println(result.size());
        for (int x : result) {
            System.out.println(x);
        }
    }
}