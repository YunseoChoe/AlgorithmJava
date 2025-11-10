package 프로그래머스;
import java.util.*;

// - 알고리즘: LinkedHashSet

public class PSG튜플 {
    public int[] solution(String s) {
        String[] parts = s.split("\\},\\{"); // escape: \\{ -> "{", 따라서 },{ 기준으로 나눔.

        ArrayList<String> list = new ArrayList<>(Arrays.asList(parts));
        Collections.sort(list, Comparator.comparingInt(String::length)); // 길이 기준으로 정렬.

        LinkedHashSet<Integer> set = new LinkedHashSet<>(); // 순서를 유지하면서 중복 제거.
        for (String part : list) {
            String[] nums = part.split(",");
            for (String num : nums) {
                set.add(Integer.parseInt(num));
            }
        }

        // set -> int[]
        int[] answer = new int[set.size()];
        int idx = 0;
        for (int num : set) {
            answer[idx] = num;
            idx++;
        }
        
        // for (int i = 0; i < answer.length; i++) {
        //     System.out.print(answer[i] + " ");
        // }

        return answer;
    }
}
