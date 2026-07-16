class Solution {
    public String solution(String X, String Y) {
        int[] cntX = new int[10];
        int[] cntY = new int[10];

        // 각 숫자의 개수 세기
        for (int i = 0; i < X.length(); i++) {
            cntX[X.charAt(i) - '0']++;
        }

        for (int i = 0; i < Y.length(); i++) {
            cntY[Y.charAt(i) - '0']++;
        }

        StringBuilder answer = new StringBuilder();

        // 큰 숫자부터 추가
        for (int num = 9; num >= 0; num--) {
            int count = Math.min(cntX[num], cntY[num]);

            for (int i = 0; i < count; i++) {
                answer.append(num);
            }
        }

        // 공통 숫자가 없는 경우
        if (answer.length() == 0) {
            return "-1";
        }

        // 모두 0인 경우
        if (answer.charAt(0) == '0') {
            return "0";
        }

        return answer.toString();
    }
}