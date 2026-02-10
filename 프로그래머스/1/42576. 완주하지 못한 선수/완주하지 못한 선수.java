import java.util.Arrays;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        // 정렬
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        // 비교
        for (int i = 0; i < completion.length; i++) {
            if (!participant[i].equals(completion[i])) {
                return participant[i];
            }
        }
        
        // 끝까지 갔으면 마지막 사람이 완주 못함
        return participant[participant.length - 1];
    }
}