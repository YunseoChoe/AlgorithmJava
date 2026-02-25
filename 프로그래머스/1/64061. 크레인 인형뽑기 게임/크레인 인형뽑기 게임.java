class Solution {
    static int[] bucket;
    
    public int[] findEndDoll(int[][] board, int col) {
        // col열에서만 찾기
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (j + 1 == col && board[i][j] != 0) {
                    return new int[] {i, j};
                }
            }
        }
        return null;
    }
    
    public boolean bomb(int[] bucket, int idx) {
        if (idx < 2) return false;
        
        // 끝에 2개만 확인
        if (bucket[idx - 1] == bucket[idx - 2]) {
            bucket[idx - 1] = 0;
            bucket[idx - 2] = 0;
            return true;
        }
        return false;
    }
    
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int[] bucket = new int[1001];
        int bucketIdx = 0;

        // 동작 별로 크레인 이동
        for (int i = 0; i < moves.length; i++) {
            // 가장 끝 인형 찾기
            int[] dolls = findEndDoll(board, moves[i]);
            if (dolls == null) continue; // 예외처리
            
            int dx = dolls[0];
            int dy = dolls[1];
            
            // 인형 바구니에 넣기
            int doll = board[dx][dy];
            board[dx][dy] = 0; // 인형 제거
            bucket[bucketIdx++] = doll;
            
            // 터졌는지 확인
            if (bomb(bucket, bucketIdx)) {
                bucketIdx -= 2;
                answer += 2;
            }     
        }
        return answer;
    }
}
