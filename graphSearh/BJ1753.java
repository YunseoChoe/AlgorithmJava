// 최단경로 (다익스트라 알고리즘)
package graphSearh;
import java.io.*;
import java.util.*;

public class BJ1753 {
    static int v, e, k, INF = Integer.MAX_VALUE;
    static int[][] graph; // 인접 행렬
    static boolean[] visited;
    static int[] dist; // 거리

    static class Node implements Comparable<Node> {
        int vertex;
        int weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) { 
            return this.weight - o.weight; // 오름차순 정렬
        }
    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>(); 
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (visited[cur.vertex]) continue;
            visited[cur.vertex] = true;

            for (int i = 0; i < v; i++) {
                // 인접하고, 방문하지 않았다면
                if (graph[cur.vertex][i] != 0 && !visited[i]) {
                    int newDist = dist[cur.vertex] + graph[cur.vertex][i];
                    if (dist[i] > newDist) {
                        dist[i] = newDist;
                        pq.offer(new Node(i, newDist));
                    }
                }
            }

        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        v = Integer.parseInt(line[0]);
        e = Integer.parseInt(line[1]);
        k = Integer.parseInt(br.readLine()) - 1;
        graph = new int[v][v];
        visited = new boolean[v];
        dist = new int[v];
        Arrays.fill(dist, INF); // 거리 최대값으로 초기화

        // 간선 입력
        for (int i = 0; i < e; i++) {
            int u, v, w;
            String[] input = br.readLine().split(" ");
            u = Integer.parseInt(input[0]) - 1;
            v = Integer.parseInt(input[1]) - 1;
            w = Integer.parseInt(input[2]);
            graph[u][v] = w;
        }

        dijkstra(k);

        for (int i = 0; i < v; i++) {
            if (dist[i] == INF) {
                System.out.println("INF");
            }
            else {
                System.out.println(dist[i]);
            }
        }
    }   
}
