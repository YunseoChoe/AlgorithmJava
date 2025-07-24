// 다익스트라 알고리즘
package graphSearh;
import java.io.*;
import java.util.*;

public class Dijkstra {
    static int n, infinite = Integer.MAX_VALUE;
    static int[] dist;
    static boolean[] visited;
    static int[][] graph;

    static class Node implements Comparable<Node> {
        int vertex;
        int weight; 

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        // priority queue에서 우선순위 비교를 위해 내부적으로 실행하는 함수
        // 정렬 기준을 정하는 함수
        @Override
        public int compareTo(Node o) { 
            return this.weight - o.weight; // 오름차순 정렬
        }
    }

    public static void dijkstra(int start) { 
        PriorityQueue<Node> pq = new PriorityQueue<>(); 
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
    }
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        dist = new int[n];
        Arrays.fill(dist, infinite);
        visited = new boolean[n];
        graph = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] list = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(list[j]);
            }
        }

        dijkstra(0); // 0번 노드부터 시작.

        System.out.println("0번 노드로부터 각 노드까지의 최단 거리:");
        for (int i = 0; i < n; i++) {
            if (dist[i] == infinite) {
                System.out.println(i + ": 도달 불가");
            } else {
                System.out.println(i + ": " + dist[i]);
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
