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
        
        
        
        // number의 각 약수 개수 구하기
        int[] factor = new int[number];
        factor = getFactorCnt(number);

        
        // 약수의 개수가 공격력 제한 수치를 넘는지 확인
        for (int i = 0; i < number; i++) {
            if (factor[i] > limit) {
                factor[i] = power;
            }
        }
        
        // 합 구하기
        for (int i = 0; i < number; i++) {
            answer += factor[i];
        }
        
        return answer;
    }
}