// 최단경로 (다익스트라 알고리즘, 인접 리스트)
package graphSearh;
import java.io.*;
import java.util.*;

public class BJ1753 {
    static int v, e, k, INF = Integer.MAX_VALUE;
    static ArrayList<Node>[] list; // 인접 리스트
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

            for (Node next: list[cur.vertex]) {
                if (dist[next.vertex] > dist[cur.vertex] + next.weight) {
                    dist[next.vertex] = dist[cur.vertex] + next.weight;
                    pq.offer(new Node(next.vertex, dist[next.vertex])); 
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
        list = new ArrayList[v];
        visited = new boolean[v];
        dist = new int[v];
        Arrays.fill(dist, INF); // 거리 최대값으로 초기화

        // list 초기화
        for (int i = 0; i < v; i++) {
            list[i] = new ArrayList<>();
        }

        // 간선 입력
        for (int i = 0; i < e; i++) {
            int u, v, w;
            String[] input = br.readLine().split(" ");
            u = Integer.parseInt(input[0]) - 1;
            v = Integer.parseInt(input[1]) - 1;
            w = Integer.parseInt(input[2]);
            list[u].add(new Node(v, w)); 
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
