// 숨바꼭질
package graphSearh;
import java.util.*;

public class BJ1697 {
    static int n;
    static int k;
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

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            // 동생을 찾았다면
            if (cur == k) {
                System.out.println(second[cur]);
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

                // 범위 (0보다 커야함!)
                if (0 <= next && next <= 100000) { 
                    // 방문하지 않은 위치만
                    if (!visited[next]) {
                        queue.add(next);
                        visited[next] = true;
                        second[next] = second[cur] + 1;
                    }
                }
            }            
        }
    }
}
