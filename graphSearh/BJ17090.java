// 미로 탈출하기
package graphSearh;
import java.util.*;
import java.io.*;

public class BJ17090 {
    static int n, m;
    static int count = 0;
    static char[][] maze;
    static boolean[][] visited;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        m = Integer.parseInt(line[1]);

        maze = new char[n][m];
        

        for (int i = 0; i < n; i++) {
            String input = br.readLine();          
            for (int j = 0; j < m; j++) {
                maze[i][j] = input.charAt(j);     
            }
        }

        for (int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                visited = new boolean[n][m];
                solve(i, j);
            }
        }
        System.out.println(count);
    }

    public static void solve(int i, int j) { 
        // 범위 밖이면
        if (i < 0 || i >= n || j < 0 || j >= m) {
            count += 1;
            return;
        } 
        
        // 이미 방문했다면
        if (visited[i][j]) {
            return;
        }

        visited[i][j] = true;
        if (maze[i][j] == 'U') {
            i = i - 1;
            solve(i, j);
        }
        else if (maze[i][j] == 'R') {
            j = j + 1;
            solve(i, j);

        }
        else if (maze[i][j] == 'D') {
            i = i + 1;
            solve(i, j);
        }
        else if (maze[i][j] == 'L') {
            j = j - 1;
            solve(i, j);
        }
    }
}
