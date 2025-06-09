// 이분 그래프
package graphSearh;
import java.util.*;

public class BJ1707 {
    static int k;
    static int[][] graph;
    static int[] visited; // int로 한 이유는, 방문하지 않았으면 무조건 0. color를 구분하기 위하여 1과 -1를 사용하기 위함.

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 입력
        k = scanner.nextInt(); // test case의 개수
        for (int i = 0; i < k; i++) {
            int v = scanner.nextInt();
            int e = scanner.nextInt();
            graph = new int[v][v]; // graph 초기화
            visited = new int[v]; // visited 초기화

            // 간선 수 만큼 간선 입력받기
            for (int j = 0; j < e; j++) {
                int edge1 = scanner.nextInt();
                int edge2 = scanner.nextInt();
                graph[edge1 - 1][edge2 - 1] = 1; // 양방향 처리 
                graph[edge2 - 1][edge1 - 1] = 1;
            }

            boolean result = bfs(0 ,v); // test case만큼 bfs함수 호출.
            if (result) {
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }

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
            for (int i = 0; i < n; i++) {
                // 이웃했다면 
                if (graph[curVertex][i] == 1) {
                    int nextVertex = i; // 어차피 양방향 간선이므로 한 방향만 봐도 됨.
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
        }
        return true;
    }
}
