// 다익스트라 알고리즘 
package graphSearh;

public class Dijkstra {
    static int n;
    static int[][] g;

    public static void main(String[] args) {
        
    }

    public static int getMin() {
        return -1;
    }

    public static void dijkstra(int start) { // start vertex
        int[] dist;
        boolean[] visited;
        dist[start] = 0;
        for(int i = 0; i < n; i++) {
            if (g[start][i] != 0) {
                dist[i] = g[start][i]; 
            }
        }
        
        while(true) { // 모든 노드들이 전부 방문처리가 되면 while문이 종료되어야 한다
            int cur = getMin();
            visited[start] = true; // 뽑혔을 때 visited를 업데이트하기
            for(int i = 0; i < n; i++) {
                if(인접해있는지도 보고, 방문을 안 했는지도 보고) {
                    if (dist[cur] + g[cur][i] < dist[i]) {
                        // cur을 거치고 i로 가는 것이 더 최단거리인지?
                        // 아니면, cur를 거치지 않고 i를 가는 것이 더 최단거리인지
                        dist[i] = dist[cur] + g[cur][i];
                    }
                }
            }
        }
    }
}
