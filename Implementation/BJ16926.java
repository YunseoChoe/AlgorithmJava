// 배열 돌리기 1
package Implementation;
import java.util.*;
import java.io.*;

public class BJ16926 {
    static int n, m, r;
    static int[][] graph;

    // 시계방향
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        r = Integer.parseInt(input[2]);

        graph = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(line[j]);
            }
        }

        // 각 layer마다 solve() 돌리기.
        int layers = Math.min(n, m) / 2; // 층수 계산
        for (int layer = 0; layer < layers; layer++) {
            for (int i = 0; i < r; i++) { // r번 회전
                solve(layer);
            }
        }

        // 결과 출력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void solve(int layer) { // layer: 현재 처리할 층 (0이 가장 바깥층)
        // 레이어 경계 계산
        int top = layer;                 
        int left = layer;               
        int bottom = n - 1 - layer;     
        int right = m - 1 - layer;       

        // 현재 위치
        int i = top;
        int j = left;
        int dir = 0;

        // 시작값을 저장
        int startVal = graph[i][j];

        while (true) {
            int nx = i + dx[dir];
            int ny = j + dy[dir];

            // 범위를 벗어나면 
            if (nx < top || nx > bottom || ny < left || ny > right) {
                dir = (dir + 1) % 4; // 방향 전환
                nx = i + dx[dir]; // nx, ny 재정의
                ny = j + dy[dir];
            }

            // 마지막 칸이면 해당 칸에 시작값 넣기
            if (nx == top && ny == left) {
                graph[i][j] = startVal;
                break;
            }

            // 밀기
            graph[i][j] = graph[nx][ny];

            i = nx;
            j = ny;
        }
    }

    public static boolean isInRange(int x, int y) {
        return (x >= 0 && x < n && y >= 0 && y < m);
    }
}
