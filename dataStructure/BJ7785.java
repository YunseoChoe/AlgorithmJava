// 회사에 있는 사람
package dataStructure;
import java.util.*;
import java.io.*;

public class BJ7785 {
    static int n;
    static Map<String, String> map = new HashMap<>();
    static ArrayList<String> ans = new ArrayList<>();

    public static ArrayList<String> solve() {
        for (String name : map.keySet()) {
            if (map.get(name).equals("enter")) { // == 는 참조값 비교 연산자임.
                ans.add(name);
            }
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            // 사람, 기록
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String record = st.nextToken();

            map.put(name, record); // .put()은 key가 이미 존재하는 경우, 기존 value를 새로 덮어씀.   
        }

        solve();

        // 역순 정렬
        Collections.sort(ans, Collections.reverseOrder());

        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }
    }   
}
