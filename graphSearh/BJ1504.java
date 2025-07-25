// 특정한 최단 경로
package graphSearh;
import java.util.*;
import java.io.*;

public class BJ1504 {
    static int n, e, v1, v2, INF = Integer.MAX_VALUE;
    static int[][] graph;
    static int[] dist;
    static boolean[] visited;

    public static class Node {
        int vertex;
        int weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        e = Integer.parseInt(line[1]);
        graph = new int[n][n];
        visited = new boolean[n];
        dist = new int[n];

        for (int i = 0; i < e; i++) {
            int a, b, c;
            String[] input = br.readLine().split(" ");
            a = Integer.parseInt(input[0]) - 1;
            b = Integer.parseInt(input[1]) - 1;
            c = Integer.parseInt(input[2]);
            graph[a][b] = c;
            graph[b][a] = c; // 무방향 그래프 
        }

        String[] line2 = br.readLine().split(" ");
        v1 = Integer.parseInt(line2[0]) - 1;
        v2 = Integer.parseInt(line2[1]) - 1;

        int path1 = 0;
        int path2 = 0;

        // v1 -> v2
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(visited, false);
        path1 += dijkstra(0, v1);

        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(visited, false);
        path1 += dijkstra(v1, v2);

        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(visited, false);
        path1 += dijkstra(v2, n - 1);

        // v2 -> v1        
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(visited, false);
        path2 += dijkstra(0, v2);

        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(visited, false);
        path2 += dijkstra(v2, v1);

        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(visited, false);
        path2 += dijkstra(v1, n - 1);

        // 경로가 없다면
        if (path1 == INF && path2 == INF) {
            System.out.println(-1);
        }
        else {
            System.out.println(Math.min(path1, path2));
        }
    }

    public static int dijkstra(int start, int end) { 
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight); 
        pq.offer(new Node(start, 0));
        dist[start] = 0;      
        
        while(!pq.isEmpty()) {
            Node cur = pq.poll(); // 가장 작은 weight을 가진 Node를 꺼냄.

            // 방문했다면
            if (visited[cur.vertex]) continue;
            visited[cur.vertex] = true;

            for (int i = 0; i < n; i++) {
                // 인접하고, 방문하지 않았다면
                if (graph[cur.vertex][i] != 0 && !visited[i]) {
                    int newDist = dist[cur.vertex] + graph[cur.vertex][i];
                    if (dist[i] > newDist) {
                        dist[i] = newDist;
                        pq.offer(new Node(i, newDist)); // (정점, 거리)
                    }
                }
            }
        }
        return dist[end];
    }
}
