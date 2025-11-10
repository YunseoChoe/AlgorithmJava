package 프로그래머스;

import java.util.*;

public class PSG압축 {
    public int[] solution(String msg) {
        // msg = "KAKAO"
        List<Integer> answer = new ArrayList<>();
        List<String> dictionary = new ArrayList<>();

        // A ~ Z 초기 사전 등록
        for (char c = 'A'; c <= 'Z'; c++) {
            dictionary.add(String.valueOf(c));
        }

        int size = 1;
        int start = 0;

        // 단어 자르기
        while (start < msg.length()) {
            if (start + size > msg.length()) {
                break;
            }

            String newStr = msg.substring(start, start + size);

            // 사전에 있으면
            if (dictionary.contains((newStr))) {
                // 이미 answer에 추가한 인덱스라면
                if (answer.contains(answer.contains(dictionary.indexOf(newStr) + 1))) {
                    size++;
                }
                else {
                    answer.add(dictionary.indexOf(newStr) + 1);
                    size++;    
                }
                
            }
            // 사전에 없으면
            else {
                dictionary.add(newStr);
                start = start + size;
                size = 1;
            }
        }

        // ArrayList → int[]
        int[] result = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }

        return result;
    }
}
