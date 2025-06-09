// 이분 그래프
package graphSearh;
import java.util.*;

public class BJ1707 {
    static int k;
    static ArrayList<ArrayList<Integer>> adjList; // 인접행렬 -> 인접리스트 (메모리 절약)
    static int[] visited; // int로 한 이유는, 방문하지 않았으면 무조건 0. color를 구분하기 위하여 1과 -1를 사용하기 위함.

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 입력
        k = scanner.nextInt(); // test case의 개수
        for (int i = 0; i < k; i++) {
            int v = scanner.nextInt();
            int e = scanner.nextInt();
            adjList = new ArrayList<>(); // 인접리스트 초기화
            visited = new int[v]; // visited 초기화

            for (int j = 0; j < v; j++) {
                adjList.add(new ArrayList<>());
            }

            // 간선 수 만큼 간선 입력받기
            for (int j = 0; j < e; j++) {
                int a = scanner.nextInt() - 1;
                int b = scanner.nextInt() - 1;
                adjList.get(a).add(b); // 양방향 연결
                adjList.get(b).add(a);
            }

            // 비연결 그래프일 수도 있으니, 방문하지 않은 모든 정점에서 함수 실행해야 함.
            boolean isFalse = true;
            for (int j = 0; j < v; j++) {
                if (visited[j] == 0) {
                    if (!bfs(j, v)) {
                        isFalse = false;
                        break;
                    }
                }
            }
            System.out.println(isFalse ? "YES" : "NO");
        }
    }

    public static boolean bfs(int start, int n) { // 시작 좌표, graph 크기
        visited[start] = 1; // 1로 체크.
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        // queue가 빌 때까지
        while (!queue.isEmpty()) {
            int curVertex = queue.poll(); // 정점 번호.
            
            // curVertex와 이웃한 노드 찾기
            for (int nextVertex : adjList.get(curVertex)) {
                // 방문하지 않았다면
                if (visited[nextVertex] == 0) {
                    visited[nextVertex] = -visited[curVertex];
                    queue.add(nextVertex);
                }
                // 방문했다면
                else {
                    // 현재와 같은 색상이면 false
                    if (visited[curVertex] == visited[nextVertex]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
