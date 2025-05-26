// 테트로미노
import java.util.*;

public class BJ14500 {
    static int n, m;
    static int[][] graph;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] visited;
    static int maxSum = 0;
    static int maxTSum = 0;
    
    
    static int[][][] tShapes = {
        { {0, 0}, {1, 0}, {2, 0}, {1, 1} },  // ㅏ
        { {0, 1}, {1, 0}, {1, 1}, {2, 1} },  // ㅓ
        { {0, 0}, {1, -1}, {1, 0}, {1, 1} }, // ㅗ
        { {0, 0}, {0, 1}, {0, 2}, {1, 1} }   // ㅜ
    };
    

    public static void main(String[] args) {
        // 입력
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        graph = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                graph[i][j] = scanner.nextInt();
            }
        }

        // 방문배열 초기화
        visited = new boolean[n][m];
    
        // 함수 호출
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true;
                general(i, j,  1, graph[i][j]);
                visited[i][j] = false;
            }
        }

        // // T자 함수 호출
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < m; j++) {
        //         int tSum = tShape(i, j, 0, 0);
        //         maxTSum = Math.max(maxTSum, tSum);
        //     }
        // }

        System.out.println(Math.max(maxSum, maxTSum));
        scanner.close();
    }

    public static void general(int x, int y, int depth, int sum) {
        if (depth == 4) {
            maxSum = Math.max(maxSum, sum);
            return;
        }
        // 동서남북 보면서
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            // 범위 && 방문하지 않았으면
            if ((0 <= nx && nx < n) && (0 <= ny && ny < m) && visited[nx][ny] == false) {
                // T shape
                if (depth == 2) {
                    visited[nx][ny] = true;
                    general(x, y, depth + 1, sum + graph[nx][ny]);
                    visited[nx][ny] = false;
                    // return; // -> return 하면 안 됨. 깊이가 2인 다른 경우도 봐야하므로
                }
                // T shape을 제외한 나머지 테트로미노
                visited[nx][ny] = true;
                general(nx, ny, depth + 1, sum + graph[nx][ny]);
                visited[nx][ny] = false;
            }
        }
    }

    // // ㅗ, ㅜ, ㅏ, ㅓ (T자)
    // public static int tShape(int x, int y, int depth, int max) {
    //     // 동서남북 말고 T자로 보기
    //     for (int[][] shape : tShapes) { // int[][] shape = {{0, 0}, {1, 0}, {2, 0}, {1, 1}} 
    //         boolean isOk = true;
    //         int sum = 0; // 각 모양마다 sum 초기화
    //         for (int[] d : shape) { // int[] d = {0, 0} 
    //             int nx = x + d[0];
    //             int ny = y + d[1];

    //             // 범위 체크
    //             if ((0 <= nx && nx < n) && (0 <= ny && ny < m)) {
    //                 // 모든 좌표들이 범위 안에 있다면 sum 구하기
    //                 sum += graph[nx][ny];
    //             }
    //             else {
    //                 isOk = false;
    //                 break;
    //             }
    //         }
    //         if (isOk) {
    //             // 최댓값 갱신 
    //             max = Math.max(sum, max);
    //         }
            
    //     }
    //     return max;
    // }
}