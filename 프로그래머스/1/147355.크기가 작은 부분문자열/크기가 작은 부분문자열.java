class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int n = t.length();
        int size = p.length();
        
        for (int i = 0; i < n - (size - 1); i++) {
            String str = t.substring(i, i + size);
            long num = Long.parseLong(str);
            
            if (num <= Long.parseLong(p)) {
                answer++;
            }
        }
        
        return answer;
    }
}