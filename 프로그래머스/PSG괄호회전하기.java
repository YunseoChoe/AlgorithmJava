package 프로그래머스;
import java.util.Stack;

public class PSG괄호회전하기 {
    public static boolean check(String word) {
        Stack<Character> stack = new Stack<>();

        for (char c : word.toCharArray()) {
            // 여는 괄호일 경우 push
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } 

            // 닫는 괄호일 경우
            else if (c == ')' || c == ']' || c == '}') {
                // 스택이 비어있으면
                if (stack.isEmpty()) {
                    return false;
                }
                // 짝이 안 맞으면
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                    (c == ']' && top != '[') ||
                    (c == '}' && top != '{')) {
                    return false;
                }
            }
        }
        // stack이 비었다면
        return stack.isEmpty();
    }

    public int solution(String s) {
        int answer = 0;
        
        // 원본 확인
        if (check(s)) {
            answer++;
        }
        
        for (int i = 0; i < s.length() - 1; i++) {
            boolean isFirst = true;
            
            // 0번 ~ 기준 분리
            String left = s.substring(0, i + 1);
            String right = s.substring(i + 1, s.length());  
            String word = right + left;
                   
            // 올바른 괄호인지 확인
            if (check(word)) {
                answer++;
            }            
        }

        return answer;
    }
}
