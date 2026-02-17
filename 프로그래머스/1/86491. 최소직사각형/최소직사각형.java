class Solution {
    public int solution(int[][] sizes) {
        int n = sizes.length;
        int answer = 0;
        
        // 가로는 최대
        // 세로는 최소
        for (int i = 0; i < n; i++) {
            int width = sizes[i][0];
            int length = sizes[i][1];
            
            if (width < length) {
                // swap
                sizes[i][0] = length;
                sizes[i][1] = width;
            }
        }
        
        // for (int i = 0; i < n; i++) {
        //     System.out.println(sizes[i][0] + " " + sizes[i][1]);
        // }
        
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