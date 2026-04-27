import java.util.*;

class Solution {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] visited;
    
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        visited = new boolean[n][m];
        
        Queue<int[]> queue = new LinkedList<>();
        
        visited[0][0] = true;
        queue.add(new int[] {0, 0, 1});
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];
            int cnt = cur[2];
            
            // 도착
            if (cx == n - 1 && cy == m - 1) {
                return cnt;
            }
            
            // 동서남북 탐색
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                // 범위, 길, 방문 체크
                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (!visited[nx][ny] && maps[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        queue.add(new int[] {nx, ny, cnt + 1});
                    }
                }
            }
        }
        
        // 못 가면
        return -1;
    }
}