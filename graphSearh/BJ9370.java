// 미확인 도착지
package graphSearh;
import java.util.*;
import java.io.*;

public class BJ9370 {
    static int tc, n, m, t, s, g, h, a, b, c;
    static ArrayList<Node>[] list; // 인접 리스트
    static int[] dist;
    static int[] candidates; // 목적지 후보
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

        tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            ArrayList<Integer> printCandidates = new ArrayList<>(); // 출력할 후보들
            String[] line1 = br.readLine().split(" ");
            n = Integer.parseInt(line1[0]);
            m = Integer.parseInt(line1[1]);
            t = Integer.parseInt(line1[2]);

            String[] line2 = br.readLine().split(" ");
            s = Integer.parseInt(line2[0]) - 1; // 출발지
            g = Integer.parseInt(line2[1]) - 1; 
            h = Integer.parseInt(line2[2]) - 1;

            list = new ArrayList[n];
            visited = new boolean[n];
            dist = new int[n];
            Arrays.fill(dist, Integer.MAX_VALUE);
            candidates = new int[t];

            for (int j = 0; j < n; j++) {
                list[j] = new ArrayList<>();
            }

            // edge 입력
            for (int j = 0; j < m; j++) {
                String[] edges = br.readLine().split(" ");
                a = Integer.parseInt(edges[0]) - 1;
                b = Integer.parseInt(edges[1]) - 1;
                c = Integer.parseInt(edges[2]);
                list[a].add(new Node(b, c));
                list[b].add(new Node(a, c));
            }   

            // 목적지 후보 입력
            for (int j = 0; j < t; j++) {
                int x = Integer.parseInt(br.readLine());
                candidates[j] = x - 1;
            }

            // 다익스트라 호출
            for (int j = 0; j < t; j++) {
                int path1 = 0;
                int path2 = 0;
                // 1. 최단 거리
                path1 += dijkstra(s, candidates[j]);

                Arrays.fill(dist, Integer.MAX_VALUE);
                Arrays.fill(visited, false);

                // 2. g, h를 거쳤을 때
                path2 += dijkstra(s, g);
                Arrays.fill(dist, Integer.MAX_VALUE);
                Arrays.fill(visited, false);

                path2 += dijkstra(g, h);

                Arrays.fill(dist, Integer.MAX_VALUE);
                Arrays.fill(visited, false);

                path2 += dijkstra(h, candidates[j]);

                Arrays.fill(dist, Integer.MAX_VALUE);
                Arrays.fill(visited, false);

                System.out.println("path1: " + path1 + ", path2: " + path2);

                // path1과 path2가 같으면
                if (path1 == path2) {
                    printCandidates.add(candidates[j]);
                }
            }

            Collections.sort(printCandidates); // 오름차순 정렬
            for (int j = 0; j < printCandidates.size(); j++) {
                System.out.print(printCandidates.get(j) + 1 + " ");
            }
            System.out.println();    
        }
    }

    public static int dijkstra(int start, int x) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            

            if (visited[cur.vertex]) {
                continue;
            }
            visited[cur.vertex] = true;

            for (Node next: list[cur.vertex]) {
                if (dist[next.vertex] > dist[cur.vertex] + next.weight) {
                    dist[next.vertex] = dist[cur.vertex] + next.weight;
                    pq.offer(new Node(next.vertex, dist[next.vertex]));
                }
            }
        }
        return dist[x];
    }
}
