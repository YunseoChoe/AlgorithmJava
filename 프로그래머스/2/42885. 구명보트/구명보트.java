import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        // 정렬
        Arrays.sort(people);
        
        int left = 0;
        int right = (people.length) - 1;
        
        while (left <= right) {
            // 두 명 모두 태울 수 있으면
            if (people[left] + people[right] <= limit) {
                left++;
            }
            
            right--;
            answer++;
        }
        
        return answer;
    }
}