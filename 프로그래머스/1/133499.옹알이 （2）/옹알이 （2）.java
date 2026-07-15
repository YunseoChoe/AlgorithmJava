class Solution {
    public int solution(String[] babbling) {
        int answer = 0;

        for (String str : babbling) {
            int index = 0;
            String prevStr = ""; // 이전 발음을 저장.

            while (index < str.length()) {
                String newStr = str.substring(index);

                if (newStr.startsWith("aya") && !prevStr.equals("aya")) {
                    index += 3;
                    prevStr = "aya";
                }
                else if (newStr.startsWith("ye") && !prevStr.equals("ye")) {
                    index += 2;
                    prevStr = "ye";
                }
                else if (newStr.startsWith("woo") && !prevStr.equals("woo")) {
                    index += 3;
                    prevStr = "woo";
                }
                else if (newStr.startsWith("ma") && !prevStr.equals("ma")) {
                    index += 2;
                    prevStr = "ma";
                }
                else {
                    break;
                }
            }

            if (index == str.length()) {
                answer++;
            }
        }

        return answer;
    }
}