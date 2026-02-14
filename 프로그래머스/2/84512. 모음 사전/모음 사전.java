import java.util.*;

class Solution {
    static String[] words = {"A", "E", "I", "O", "U"};
    static ArrayList<String> list = new ArrayList<>();
    static int answer = 0;
    
    public static void dfs(String str, int depth) {
     
        list.add(str);
        if (depth == 5) {
            return;
        }

        for (int i = 0; i < 5; i++) {
            dfs(str + words[i], depth + 1);
        }
    }
    
    public int solution(String word) {
        dfs("", 0);
        
        return list.indexOf(word);
    }
}