// 다익스트라 알고리즘 
package graphSearh;
import java.io.*;
import java.util.*;

public class Dijkstra {
    static int n, infinite = Integer.MAX_VALUE;
    static int[] dist;
    static boolean[] visited;
    static int[][] graph;
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        dist = new int[n];
        Arrays.fill(dist, infinite); // 거리 무한대로 초기화.
        visited = new boolean[n];
        graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] list = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(list[j]);
            }
        }

        dijkstra(0); // 0번 노드부터 시작.
    }

    public static int getMin() {
        int minValue = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < n; i++) {
            // 방문하지 않았고, 최솟값 구하기
            if (!visited[i] && dist[i] < minValue) {
                minValue = dist[i];
                minIndex = i;
            }
        }
        return minIndex;  // 최솟값의 인덱스를 반환해야 함.
    }

    public static void dijkstra(int start) { 
        dist[start] = 0;        // 시작 노드의 거리는 0.
        visited[start] = true;  // 시작 노드 방문처리.

        // 시작 노드로부터 거리 초기화
        for(int i = 0; i < n; i++) {
            if (graph[start][i] != 0) {
                dist[i] = graph[start][i]; 
            }
        }
        
        while(true) {
            int cur = getMin(); 
            // 모든 노드를 방문했다면 종료.
            if (cur == -1) {
                System.out.print("0번 노드에서의 거리: ");
                for (int i = 0; i < n; i++) {
                    System.out.print(dist[i] + " ");
                }
                break;
            }
            visited[cur] = true; // 뽑혔을 때 visited 업데이트 -> dist들 중에서 가장 작은 노드 cur가 뽑혔다는 건, cur노드는 더 짧은 경로가 있을 수 없는 상태라는 뜻.
            for(int i = 0; i < n; i++) {
                // 방문하지 않았고, 인접해 있다면
                if(!visited[i] && graph[cur][i] != 0) { 
                    dist[i] = Math.min(dist[i], dist[cur] + graph[cur][i]); // 기존 dist 값 vs 거쳐 갔을 때의 값 
                }
            }
        }
    }
}

// 025100
// 203200
// 530315
// 123010
// 001102
// 005020
