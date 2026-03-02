import java.util.*;

class Solution {
    public int[] solution(String s) {
        // 1. 바깥 {{ }}
        s = s.substring(2, s.length() - 2);

        // 2. },{ 기준 분리
        String[] parts = s.split("\\},\\{");

        ArrayList<String> list = new ArrayList<>(Arrays.asList(parts));
        Collections.sort(list, Comparator.comparingInt(String::length));

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

