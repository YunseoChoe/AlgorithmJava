import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        for (int num : arr) {
		        // set에 포함되어 있지 않은 num만 list에 추가
            if (!set.contains(num)) {
                list.add(num);
                set = new HashSet<>(); // set 초기화 (연속인 것을 봐야하므로)
                set.add(num);
            }
        }

        // List → int[]
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}