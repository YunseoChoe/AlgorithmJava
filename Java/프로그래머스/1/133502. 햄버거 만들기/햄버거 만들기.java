import java.util.*;

class Solution {

    public boolean check(List<Integer> stack, int size) {
        return size >= 4 && 
               stack.get(size - 4) == 1 &&
               stack.get(size - 3) == 2 &&
               stack.get(size - 2) == 3 &&
               stack.get(size - 1) == 1;
    }

    public int solution(int[] ingredient) {
        int answer = 0;
        List<Integer> stack = new ArrayList<>();

        for (int i : ingredient) {
            stack.add(i);
            int size = stack.size();

            if (check(stack, size)) {
                for (int j = 0; j < 4; j++) {
                    stack.remove(stack.size() - 1);
                }
                answer++;
            }
        }

        return answer;
    }
}
