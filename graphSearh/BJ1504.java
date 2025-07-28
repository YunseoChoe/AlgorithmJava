// 특정한 최단 경로
package graphSearh;

import java.util.*;
import java.io.*;

public class BJ1504 {
    static int n, e, v1, v2, returnValue, INF = Integer.MAX_VALUE;
    static ArrayList<Node>[] list; // 인접 리스트

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
        list = new ArrayList[n];

        // 인접 리스트 초기화
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }

        // 간선 입력
        for (int i = 0; i < e; i++) {
            int a, b, c;
            String[] input = br.readLine().split(" ");
            a = Integer.parseInt(input[0]) - 1;
            b = Integer.parseInt(input[1]) - 1;
            c = Integer.parseInt(input[2]); // 가중치값
            list[a].add(new Node(b, c)); // 양방향 연결
            list[b].add(new Node(a, c));
        }

        String[] line2 = br.readLine().split(" ");
        v1 = Integer.parseInt(line2[0]) - 1;
        v2 = Integer.parseInt(line2[1]) - 1;

        int path1 = 0;
        int path2 = 0;
        boolean path1IsNone = false;
        boolean path2IsNone = false;

        // path1: v1 -> v2
        returnValue = dijkstra(0, v1);
        if (returnValue == -1) {
            path1IsNone = true;
        } else {
            path1 += returnValue;
        }

        returnValue = dijkstra(v1, v2);
        if (returnValue == -1) {
            path1IsNone = true;
        } else {
            path1 += returnValue;
        }

        returnValue = dijkstra(v2, n - 1);
        if (returnValue == -1) {
            path1IsNone = true;
        } else {
            path1 += returnValue;
        }

        // path2: v2 -> v1
        returnValue = dijkstra(0, v2);
        if (returnValue == -1) {
            path2IsNone = true;
        } else {
            path2 += returnValue;
        }

        returnValue = dijkstra(v2, v1);
        if (returnValue == -1) {
            path2IsNone = true;
        } else {
            path2 += returnValue;
        }

        returnValue = dijkstra(v1, n - 1);
        if (returnValue == -1) {
            path2IsNone = true;
        } else {
            path2 += returnValue;
        }

        // 경로 없을 때
        if (path1IsNone && path2IsNone) {
            System.out.println(-1);
        } 
        else if (path1IsNone && !path2IsNone) {
            System.out.println(path2);
        } 
        else if (!path1IsNone && path2IsNone) {
            System.out.println(path1);
        } 
        else {
            System.out.println(Math.min(path1, path2));
        }
    }

    public static int dijkstra(int start, int end) {
        int[] dist = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(dist, INF);

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            // 방문했다면
            if (visited[cur.vertex])
                continue;
            visited[cur.vertex] = true;

            for (Node next : list[cur.vertex]) {
                if (dist[next.vertex] > dist[cur.vertex] + next.weight) {
                    dist[next.vertex] = dist[cur.vertex] + next.weight;
                    pq.offer(new Node(next.vertex, dist[next.vertex]));
                }
            }
        }
        if (dist[end] == INF) {
            return -1;
        }
        return dist[end];
    }
}
