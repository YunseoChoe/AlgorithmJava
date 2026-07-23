class Solution {
    public int solution(String s) {
        int answer = 0;
        int start = 0;
        
        while (start < s.length()) {
            int sameCnt = 1;
            int diffCnt = 0;
            boolean isDivided = false; // 분리됐는지 여부
            
            for (int i = start + 1; i < s.length(); i++) {
                if (s.charAt(start) == s.charAt(i)) {
                    sameCnt++;
                }
                else {
                    diffCnt++;
                }
                
                if (sameCnt == diffCnt) {
                    start = i + 1;
                    answer++;
                    isDivided = true;
                    break;
                }
            }
            
            // 끝까지 갔는데 분리가 안 된 경우
            if (!isDivided) {
                answer++;
                break;
            }
        }
        return answer;
    }
}