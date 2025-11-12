package Reference;
import java.util.*;

public class 소프티어복기 {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] visited;
    static int n = 7; // board 크기

    public static int bfs(int ax, int ay, int bx, int by) {
        Queue<int[]> queue = new LinkedList<>();
        visited[ax][ay] = true;
        queue.add(new int[]{ax, ay, 0}); // 거리값도 인자에 추가.

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int dist = cur[2];

            // 도착했으면 거리 반환
            if (x == bx && y == by) {
                return dist;
            }

            // 동서남북
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                // 범위 안이고 방문하지 않았으면
                if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                    if (!visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny, dist + 1});
                    }
                }
            }
        }
        return -1; // 도달 불가
    }

    public static int solution(int ax, int ay, int bx, int by, int[][] square) {
        // 지하철 좌상단 좌표 구하기
        int sx = Integer.MAX_VALUE;
        int sy = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            sx = Math.min(sx, square[i][0]);
            sy = Math.min(sy, square[i][1]);
        }

        // 1. 지하철 이용 X
        visited = new boolean[n][n];
        int directDist = bfs(ax, ay, bx, by);

        // 2. 지하철 이용 O
        int minToSubway = Integer.MAX_VALUE; 
        int minFromSubway = Integer.MAX_VALUE; 

        // 지하철의 4*4 모든 칸 확인
        for (int i = sx; i < sx + 4; i++) {
            for (int j = sy; j < sy + 4; j++) {
                // 출발에서 지하철까지
                visited = new boolean[n][n];
                int d1 = bfs(ax, ay, i, j);
                minToSubway = Math.min(minToSubway, d1);

                // 지하철에서 도착까지
                visited = new boolean[n][n];
                int d2 = bfs(i, j, bx, by);
                minFromSubway = Math.min(minFromSubway, d2);
            }
        }

        int subwayDist = minToSubway + minFromSubway;
        return Math.min(directDist, subwayDist);
    }
    public static void main(String[] args) {
        int[][] board = new int[][]{
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1}
        };
        int[][] square = new int[4][4];
        int ax = 0, ay = 0;
        int bx = 6, by = 6;

        System.out.println("최소 경로는: " + solution(ax, ay, bx, by, square));
    }
}
