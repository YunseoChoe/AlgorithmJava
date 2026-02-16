import java.util.*;

class Solution {
    public int[] solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        List<String> dictionary = new ArrayList<>();

        // A~Z 초기화
        for (char c = 'A'; c <= 'Z'; c++) {
            dictionary.add(String.valueOf(c));
        }

        int start = 0;
        while (start < msg.length()) {
            String w = "";
            // 현재 위치부터 사전에 존재하는 가장 긴 문자열 찾기
            while (start < msg.length() && dictionary.contains(w + msg.charAt(start))) {
                w += msg.charAt(start);
                start++;
            }

            // 인덱스 추가
            answer.add(dictionary.indexOf(w) + 1);

            // 다음 글자 붙인 새 단어 사전에 추가
            if (start < msg.length()) {
                dictionary.add(w + msg.charAt(start));
            }
        }

        // 결과 변환
        int[] result = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }

        return result;
    }
}
