package 프로그래머스;

// 알고리즘 - 재귀

public class PSGN개의최소공배수 {
    // 최대공약수
    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
    
    // 최소공배수
    public int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
    
    public int solution(int[] arr) {
        int answer = 0;
        int lcmValue = arr[0];
        
        // 2개씩 다 보기
        for (int i = 1; i < arr.length; i++) {
            lcmValue = lcm(lcmValue, arr[i]);
        }
        
        answer = lcmValue;
        return answer;
    }
}
