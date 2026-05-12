import java.util.*;

class Solution {
    public int solution(int[] nums) {
        
        int n = nums.length;
        
        Set<Integer> set = new HashSet<>();        
        // 서로 다른 개수 찾기
        for (int i = 0; i < n; i++) {
            // set에 없으면
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
            }
            
        }
        
        int answer = set.size();
        if (answer >= n / 2) {
            return n / 2;
        }
        return answer;
    }
}