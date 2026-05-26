import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int n = progresses.length;
        ArrayList<Integer> answer = new ArrayList<>();
        int[] days = new int[n];

        for (int i = 0; i < n; i++) {
            int remain = 100 - progresses[i];
            int day = 0;

            if (remain % speeds[i] == 0) {
                day = remain / speeds[i];
            } else {
                day = remain / speeds[i] + 1;
            }

            days[i] = day;
        }

        int current = days[0];
        int count = 1;
        for (int i = 1; i < days.length; i++) {
            // 같이 배포 가능
            if (days[i] <= current) {
                count++;
            }

            else {
                answer.add(count);

                current = days[i];
                count = 1;
            }
        }

        answer.add(count);

        // ArrayList -> int[]
        int[] result = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }

        return result;
    }
}