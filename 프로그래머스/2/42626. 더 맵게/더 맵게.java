import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        // 최소 힙 구성
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int s : scoville) pq.add(s);

        while (pq.peek() < K) {
            // 섞을 수 없는 경우
            if (pq.size() == 1) return -1;

            int min1 = pq.poll();
            int min2 = pq.poll();
            pq.add(min1 + (min2 * 2));
            answer++;
        }

        // K를 모두 넘었다면
        return answer;
    }
}