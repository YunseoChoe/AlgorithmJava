class Solution {
    
    public int[] getFactorCnt(int number) {
        int[] returnArr = new int[number];
        
        for (int i = 0; i < number; i++) {
            int factorCnt = 0;
            for (int j = 1; j <= i + 1; j++) {
                if ((i + 1) % j == 0) {
                    factorCnt++;
                }
            }
            returnArr[i] = factorCnt;
        }
        
        return returnArr;
    }
    
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        int[] factor = getFactorCnt(number);

        for (int i = 0; i < number; i++) {
            if (factor[i] > limit) {
                factor[i] = power;
            }
            answer += factor[i];
        }
        
        return answer;
    }
}