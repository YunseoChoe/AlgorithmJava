// 숨바꼭질 4
package graphSearh;
import java.util.*;

public class BJ13913 {
    static int n;
    static int k;
    static int[] path = new int[100001];
    static int[] second = new int[100001];
    static boolean[] visited = new boolean[100001];
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextInt();

        bfs(n); // 수빈이의 현재 위치부터 시작.
    }

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        second[start] = 0; // 시작은 0초부터
        path[start] = -1; // 시작 위치.
        visited[start] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            // 동생을 찾았다면
            if (cur == k) {
                System.out.println(second[cur]);
                // path 출력 (경로를 거꾸로 저장 후 출력.)
                ArrayList<Integer> reversePath = new ArrayList<>();
                reversePath.add(cur); 
                while (path[cur] != -1) {
                    reversePath.add(path[cur]);    
                    cur = path[cur];
                }
                Collections.reverse(reversePath); 
                for (int i = 0; i < reversePath.size(); i++) {
                    System.out.print(reversePath.get(i) + " ");
                }
                break;
            }

            // 가능한 모든 3가지 방법 다 보기
            for (int i = 0; i < 3; i++) {
                int next;
                // x + 1
                if (i == 0) {
                    next = cur + 1;
                }
                // x - 1
                else if (i == 1) {
                    next = cur - 1;
                }
                // 2 * x
                else {
                    next = 2 * cur;
                }

                // 범위 (0보다 커야함)
                if (0 <= next && next <= 100000) { 
                    // 방문하지 않은 위치만
                    if (!visited[next]) {
                        queue.add(next);
                        visited[next] = true;
                        second[next] = second[cur] + 1;
                        path[next] = cur;
                    }
                }
            }            
        }
    }
}
