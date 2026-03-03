class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            int fallSecond = 0;
            
            // 자신보다 가격이 작은 게 있다면
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[i] > prices[j]) {
                    fallSecond = j - i; // 몇초뒤 떨어지는지
                    break;
                }
            }
            
            // 앞으로 가격이 떨어지지 않으면
            if (fallSecond == 0) {
                answer[i] = (prices.length - i) - 1;
            }
            
            // 앞으로 가격이 떨어진다면
            else {
                answer[i] = fallSecond;
            }
        }
        return answer;
    }
}
