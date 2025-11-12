package 프로그래머스;
import java.util.*;

// 모두 가로로 모두 눕혀놓고 (가로 세로 중 최댓값을 가로), 최대 넓이 구하기

public class PSG최소직사각형 {
    public int solution(int[][] sizes) {
        int n = sizes.length;
        int answer = 0;
        
        // 가로 - 최대, 세로 - 최소
        for (int i = 0; i < n; i++) {
            int width = sizes[i][0];
            int length = sizes[i][1];
            
            if (width < length) {
                // swap
                sizes[i][0] = length;
                sizes[i][1] = width;
            }
        }
                
        // 넓이 구하기
        int maxWidth = 0;
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            maxWidth = Math.max(maxWidth, sizes[i][0]);
            maxLength = Math.max(maxLength, sizes[i][1]);
        }
        answer = maxWidth * maxLength;
        return answer;
    }
}
