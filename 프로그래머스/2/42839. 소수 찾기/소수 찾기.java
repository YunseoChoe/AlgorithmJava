import java.util.*;

class Solution {
    static Set<Integer> set = new HashSet<>();
    static boolean[] visited;
    static String numbers;

    // 소수 판별
    public boolean isPrime(int num) {
        if (num < 2) return false;
        
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    // 백트래킹
    public void backTrack(String str) {
        // 빈 문자열이 아니라면
        if (!str.equals("")) {
            set.add(Integer.parseInt(str));
        }
        
        

        for (int i = 0; i < numbers.length(); i++) {
            // 방문하지 않았다면
            if (!visited[i]) {
                visited[i] = true;
                backTrack(str + numbers.charAt(i));
                visited[i] = false; // backTrack
            }
        }
    }

    public int solution(String numbers) {
        this.numbers = numbers;
        visited = new boolean[numbers.length()];

        backTrack(""); // numbers을 활용하여 순열 생성.
        
        System.out.println("set: " + set);

        int answer = 0;

        for (int num : set) {
            if (isPrime(num)) {
                answer++;
            }
        }

        return answer;
    }
}