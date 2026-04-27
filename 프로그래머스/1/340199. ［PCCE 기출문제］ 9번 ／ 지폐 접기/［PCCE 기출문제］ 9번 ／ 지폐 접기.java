class Solution {
    public static boolean isOver(int wx, int wy, int bx, int by) {
        int minW = Math.min(wx, wy);
        int maxW = Math.max(wx, wy);
        int minB = Math.min(bx, by);
        int maxB = Math.max(bx, by);

        if (minB <= minW && maxB <= maxW) {
            return true;
        } 
        return false;
    }

    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        int wx = wallet[0];
        int wy = wallet[1];
        int bx = bill[0];
        int by = bill[1];

        while (true) {
            // wallet의 길이보다 작으면 종료
            if (isOver(wx, wy, bx, by)) break;

            // 더 긴 길이를 반으로 접음
            if (bx > by) {
                bx = bx / 2;
            }
            else {
                by = by / 2;
            }
            answer++;
        }

        return answer;
    }
}