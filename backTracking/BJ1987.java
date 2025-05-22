// 알파벳
// 백트래킹 방법
import java.util.*;

public class BJ1987 {
    static int r, c;
    static char[][] graph;
    static Set<Character> alphabetSet = new HashSet<>(); // 중복없는 알파벳 담을 문자형 set 초기화
    static boolean[][] visited;
    static int maxArea = 0;
    // 동서남북
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 입력
        r = scanner.nextInt();
        c = scanner.nextInt();

        graph = new char[r][c];
        visited = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            String line = scanner.next(); // "AD"
            for (int j = 0; j < c; j++) {
                graph[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                visited[i][j] = false; // visited 초기화
            }
        }
                
        move(0, 0, alphabetSet); // 좌측 상단에서부터 시작
        System.out.println(maxArea);
    }

    public static void move(int x, int y, Set<Character> alphabetSet) { // x, y, 빈 set 
        // set에 추가
        alphabetSet.add(graph[x][y]);

        // 동서남북 보면서 이동
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 범위 쳌
            if ((0 <= nx && nx < r) && (0 <= ny && ny < c)) {
                // 방문하지 않았고 set에 없는 알파벳이라면
                if ((!visited[nx][ny]) && (!alphabetSet.contains(graph[nx][ny]))) {
                    // 이동
                    visited[nx][ny] = true;
                    move(nx, ny, alphabetSet);
                    // 백트래킹 (자동으로 for문 돌면서 nx, ny 변경됨)
                    visited[nx][ny] = false;
                    alphabetSet.remove(graph[nx][ny]); // 중요!
                } 
            }
        }
        
        // 최댓값 갱신
        maxArea = Math.max(alphabetSet.size(), maxArea);
    }
}
