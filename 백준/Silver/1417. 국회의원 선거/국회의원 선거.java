import java.util.*;

public class Main {
    static int n, cnt = 0;
    static int[] candidate;

    public static boolean isFirst() {
        for (int i = 1; i < n; i++) {
            if (candidate[i] >= candidate[0]) {
                return false;
            }
        }
        return true;
    }

    public static int findMaxValueCandidateIdx() {
        int maxValue = -1;
        int maxValueIdx = -1;
        for (int i = 1; i < n; i++) {
            if (maxValue < candidate[i]) {
                maxValue = candidate[i];
                maxValueIdx = i;
            }
        }
        
        return maxValueIdx;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // 최대힙

        n = sc.nextInt();
        
        candidate = new int[n];

        for (int i = 0; i < n; i++) {
            candidate[i] = sc.nextInt();
            // pq.add(candidate[i]);
        }

        // 후보자가 1명뿐일 때
        if (candidate.length < 2) {
            System.out.println(0);
            return;
        }

        // 다솜이가 1등이 될 때까지 반복
        while (!isFirst()) {
            // 한 후보씩 줄이기
            // 가장 큰 후보 찾기
            int maxIdx = findMaxValueCandidateIdx();
           
            // 투표 값 가져오기
            candidate[0] += 1;
            candidate[maxIdx] -= 1;
            cnt++;

            // 비교
            if (isFirst()) {
                break;
            }
           
           
        }
        System.out.println(cnt);
    }
}
