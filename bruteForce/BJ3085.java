// 사탕 게임
package bruteForce;
import java.util.*;

public class BJ3085 {
    static int n;
    static char[][] graph;
    static int totalMaxLength = 0;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 입력
        n = scanner.nextInt();
        graph = new char[n][n];
        // 한 줄에 n개의 문자씩, 총 n줄 입력받기
        for (int i = 0; i < n; i++) {
            String line = scanner.next(); // "AAA"
            for (int j = 0; j < n; j++) {
                graph[i][j] = line.charAt(j);
            }
        }

        // swap하기 전 최대 길이 구하기
        // int originLength = countMaxValue(graph);

        // 함수 호출
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int length = func(i, j);
                totalMaxLength = Math.max(length, totalMaxLength);
                // totalMaxLength = Math.max(totalMaxLength, originLength);
            }
        }

        System.out.println(totalMaxLength);
    }

    public static int func(int x, int y) {
        int maxLength = 0;

        // 동서남북 보면서
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            // 범위 체크
            if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                // 색이 다를 경우에만
                if (graph[x][y] != graph[nx][ny]) {
                    // swap
                    char[][] newGraph = swap(x, y, nx, ny, graph); // swap된 새 graph 반환.
                    // 최대 길이 개수 새기
                    int length = countMaxValue(newGraph);
                    // System.out.println("최대 길이 =" + length);
                    maxLength = Math.max(length, maxLength);
                }
            }
        }
        return maxLength;
    }

    // swap 함수
    public static char[][] swap(int x, int y, int nx, int ny, char[][] oldGraph) {
        // graph 복사
        char[][] copyGraph = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                copyGraph[i][j] = oldGraph[i][j];
            }
        }

        char tmp = copyGraph[x][y];
        copyGraph[x][y] = copyGraph[nx][ny];
        copyGraph[nx][ny] = tmp;

        return copyGraph; // 새로 swap된 graph 반환
    }

    // 인접해 있는 부분의 최댓값 새기 
    public static int countMaxValue(char[][] graph) {
        int rowMaxLength = 1;
        int colMaxLength = 1;
        // 가로 최대 길이
        for (int i = 0; i < n; i++) {
            int cnt = 1;
            for (int j = 0; j < n - 1; j++) {
                if (graph[i][j] == graph[i][j + 1]) {
                    cnt += 1;
                }
                // 연속된 수가 끊기면 다시 1로 초기화
                else {
                    cnt = 1;
                }
                rowMaxLength = Math.max(rowMaxLength, cnt);
            }
            
        }

        // 세로 최대 길이
        for (int j = 0; j < n; j++) {  // 각 열에 대해
            int cnt = 1;
            for (int i = 0; i < n - 1; i++) {  
                if (graph[i][j] == graph[i + 1][j]) {
                    cnt += 1;
                } else {
                    cnt = 1;
                }
                colMaxLength = Math.max(colMaxLength, cnt);
            }
        }
 
        int returnValue = Math.max(rowMaxLength, colMaxLength);
        return returnValue;
    }
    
}
