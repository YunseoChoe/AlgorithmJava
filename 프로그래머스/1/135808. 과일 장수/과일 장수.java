import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        
        Integer[] arr = new Integer[score.length];
        for (int i = 0; i < score.length; i++) {
            arr[i] = score[i];
        }

        Arrays.sort(arr, Collections.reverseOrder()); // 내림차순 정렬
        
        // m개씩 건너뛰기
        for (int i = 0; i + m <= arr.length; i += m) {
            int min = arr[i + m - 1]; // 현재 상자의 최저 점수
            answer += min * m; // 이익 계산
        }
        
        return answer;
    }
}