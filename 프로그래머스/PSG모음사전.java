package 프로그래머스;
import java.util.*;

public class PSG모음사전 {
    static String[] words = {"A", "E", "I", "O", "U"};
    static ArrayList<String> list = new ArrayList<>();

    public static void dfs(String str, int depth) {
        list.add(str);

        if (depth == 5) {
            return;
        }
        
        for (int i = 0; i < 5; i++) {
            dfs(str + words[i], depth + 1);
        }
    }

    public static int solution(String word) {
        dfs("", 0);
        return list.indexOf(word);
    }
}
