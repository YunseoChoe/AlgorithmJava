// Gaaaaaaaaaarden
package graphSearh;

import java.util.*;

// 2 1
// 1 2
public class BJ18809 {
    public static int n, m, g, r; // G, R: 각각 배양액의 개수
    public static int maxFlowers;
    public static int[][] board;

    public static ArrayList<int[]> seedAll = new ArrayList<int[]>(); // 황토색 모든 위치
    public static ArrayList<int[]> seedSelectedGreen = new ArrayList<int[]>();
    public static ArrayList<int[]> seedSelectedRed = new ArrayList<int[]>();
    private static final int GREEN = 3;
    private static final int RED = 4;
    private static final int FLOWER = 5;

    static int[] dx = { 0, 0, 1, -1 };
    static int[] dy = { 1, -1, 0, 0 };

    public static void main(String[] args) {
        // seedAll ex) [(0,0), (1,1)]
        // seedSeletecGreen [(0,0)] seedSelectedRed [(1,1)] -> bfs
        // seedSeletecGreen [(1,1)] seedSelectedRed [(0,0)] -> bfs
        seedGreen();
        System.out.println(maxFlowers);
        return;
    }

    // 초록색 배양액 위치를 선정
    public static void seedGreen() {
        if (seedSelectedGreen.size() == g) {
            seedRed();
            return;
        }
        // todo
    }

    // 빨간색 배양액 위치를 선정
    public static void seedRed() {
        if (seedSelectedRed.size() == r) {
            int cntFlowers = bfs();
            maxFlowers = Math.max(maxFlowers, cntFlowers);
            return;
        }
        // todo
    }

    public static int bfs() {
        // todo
        return 0;
    }
}
