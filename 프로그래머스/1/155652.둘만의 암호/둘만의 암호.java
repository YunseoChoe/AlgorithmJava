class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            for (int j = 0; j < index; j++) {
                // 알파벳 증가
                c++;
                
                // z 다음은 a
                if (c > 'z') {
                    c = 'a';
                }
                
                // skip에 포함되어 있으면 for문 증가 안 함
                if (skip.contains(String.valueOf(c))) {
                    j--;
                }
            }
            
            answer += c;
        }
        
        return answer;
    }
}