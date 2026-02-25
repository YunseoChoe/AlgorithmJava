import java.util.*;

class Solution {
    static boolean[] visited;
    static int[] dist;

    public int bfs(int x, int y, int n) {
        Queue<Integer> queue = new LinkedList<>();

        // start 처리
        queue.add(x);
        visited[x] = true;
        dist[x] = 0;
        
        while (!queue.isEmpty()) {
            int cx = queue.poll();

            // x와 y가 같아졌으면 종료.
            if (cx == y) {
                return dist[cx];
            }

            int[] next = {cx + n, cx * 2, cx * 3};
            for (int nx : next) {
                // 범위 안에 있고, 방문하지 않았으면
                if (nx <= y && !visited[nx]) {
                    visited[nx] = true;
                    dist[nx] = dist[cx] + 1;
                    queue.add(nx);
                }
            }
        }
        
        return -1; // 도달 못했을 경우
    }


    public int solution(int x, int y, int n) {
        visited = new boolean[1000001];
        dist = new int[1000001];
        return bfs(x, y, n);
    }
}