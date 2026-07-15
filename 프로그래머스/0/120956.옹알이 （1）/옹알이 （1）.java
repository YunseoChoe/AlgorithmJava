class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        for (String str : babbling) {
            int index = 0;
            while (index < str.length()) {
                // str의 index번부터 끝까지 확인
                String newStr = str.substring(index);
                    
                if (newStr.startsWith("aya")) {
                    index += 3;
                }
                else if (newStr.startsWith("ye")) {
                    index += 2;
                }
                else if (newStr.startsWith("woo")) {
                    index += 3;
                }
                else if (newStr.startsWith("ma")) {
                    index += 2;
                }
                else {
                    break;
                }
            }
            
            if (index == str.length()) {
                answer++;
            }
            
        }
        return answer;
    }
}