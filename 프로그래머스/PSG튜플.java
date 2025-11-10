package 프로그래머스;
import java.util.*;

public class PSG튜플 {
    public int[] solution(String s) {
        HashSet<Integer> set = new HashSet<>();
        
        int n = 0;
        for (int i = 0; i < s.length(); i++) {
            // 숫자이면
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                n++;
            }
        }
            
        int[][] board = new int[n][n];
        
        // } 기준으로 나누기
        int row = 0;
        int col = 0;
        String number = "";
        for (int i = 0; i < s.length(); i++) {
            // 숫자면
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                number += s.charAt(i);  
            } 
            
            else if (s.charAt(i) == ',' || s.charAt(i) == '}') {
                if (!number.isEmpty()) {
                    board[row][col] = Integer.parseInt(number);
                    col++;
                    number = "";
                }
                
                if (s.charAt(i) == '}') {
                    col = 0;
                    row++;
                }
            }
        }
        
        // set 이용해서 중복 없이 저장.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != 0) {
                    set.add(board[i][j]);    
                }
                
            }
        }
        
        // set -> int[]
        int idx = 0;
        int[] answer = new int[set.size()];
        for (int i : set) {
            answer[idx] = i;
            idx++;
        }
        
        return answer;
    }
}

