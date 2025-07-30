// 달팽이
package Implementation;
import java.util.*;
import java.io.*;

public class BJ1913 {
    static int n, m;
    static int[] dx = {1, 0, -1, 0}; // 하, 우, 상, 좌
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;
    static boolean[][] visited;

    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        map = new int[n][n];
        visited = new boolean[n][n];

        solve(n);
        int[] returnArr = findValue(m);
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        for (int num : returnArr) {
            System.out.print(num + " ");
        }
    }

    public static void solve(int n) {
        int i = 0;
        int j = 0;
        int d = 0; // direction 
        int num = n * n;

        while (true) {
            // while문 종료 조건
            if (num < 1) {
                break;
            }

            map[i][j] = num;
            visited[i][j] = true;

            int ni = i + dx[d];
            int nj = j + dy[d];

            // 범위
            if (ni >= 0 && ni < n && nj >= 0 && nj < n) {
                // 방문하지 않았으면
                if (!visited[i + dx[d]][j + dy[d]]) {
                    i = ni;
                    j = nj;
                }  
                // 방문했다면
                else {
                    d = (d + 1) % 4;
                    i += dx[d];
                    j += dy[d];
                }
            }
            // 범위를 벗어났다면
            else {
                d = (d + 1) % 4;
                i += dx[d];
                j += dy[d];
            }

            num -= 1;
        }
    }

    public static int[] findValue(int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == m) {
                    return new int[] {i + 1, j + 1};
                }
            }
        }
        return null; // 형식상 null.
    }
}
