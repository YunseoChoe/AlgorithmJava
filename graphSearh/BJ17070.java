package graphSearh;
import java.util.*;

public class BJ17070 {
    static int[][] graph;
    static int n;
    static int ans = 0;

    public static void main(String[] args) {
        solve(1, 2, 1);
    }

    // 백트래킹 시도
    // direction 1 -> 가로, 2 -> 세로, 3 -> 대각선
    public static void solve(int row, int col, int direction) {
        if (row == n && col == n) {
            ans += 1;
            return;
        }
        switch (direction) {
        case 1:
            // 가로로 밀기
            if (col + 1 < n && graph[row][col + 1] != 1) {
                solve(row, col + 1, 1);
            }
            // 오른쪽 대각선
            if (col + 1 < n && row + 1 < n && graph[row + 1][col + 1] != 1 && graph[row][col + 1] != 1 && graph[row + 1][col] != 1) {
                solve(row + 1, col + 1, 3);
            }
            break;
        case 2:
            break;
        case 3:
            break;
        }
    }
}
