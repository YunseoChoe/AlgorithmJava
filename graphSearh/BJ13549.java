// 숨바꼭질 3
package graphSearh;
import java.util.*;

public class BJ13549 {
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
                boolean isTeleport = false; // 메서드 안에서 boolean 선언시 반드시 초기화 해야 함.
                int next;
                // x + 1
                if (i == 0) { 
                    next = 2 * cur; // 초가 다르므로, 순간 이동의 우선순위가 더 높음. (먼저 도달해버리는 것 방지)
                    isTeleport = true;
                }
                // x - 1
                else if (i == 1) {
                    next = cur - 1;
                }
                // 2 * x
                else {
                    next = cur + 1;
                }

                // 범위 (0보다 커야함!)
                if (0 <= next && next <= 100000) { 
                    // 방문하지 않은 위치만
                    if (!visited[next]) {
                        queue.add(next);
                        visited[next] = true;
                        // 순간이동해서 왔는지 체크
                        if (isTeleport) {
                            second[next] = second[cur];
                        }
                        else {
                            second[next] = second[cur] + 1;
                        }
                    }
                }
            }            
        }
    }
}
