// 링크와 스타트
import java.util.*;

public class BJ15661 {
    static int n;
    static int[][] graph;
    static int minGap = Integer.MAX_VALUE; // 최댓값으로 설정.
    static ArrayList<Integer> teamArr = new ArrayList<>();
    
    public static void main(String[] args) {
        // 입력
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = scanner.nextInt();
            }
        }

        // 팀 생성 (팀원 수가 정해져 있지 않으므로 모든 경우를 봐야 함.)
        for (int i = 1; i <= n / 2; i++) { // n이 아닌 n / 2까지만 봐도 됨.
            makeTeam(i, 0); 
        }
        System.out.println(minGap);
    }
    
    public static void makeTeam(int personNum, int index) {
        // 팀이 완성되면
        if (teamArr.size() == personNum) {
            // 전체 팀 구성
            boolean[] team = new boolean[n]; // 기본값으로 모두 false
            for (int i : teamArr) {
                team[i] = true; // start팀
            }
            
            // 팀 나누기
            ArrayList<Integer> start = new ArrayList<>();
            ArrayList<Integer> link = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                // start 팀
                if (team[i]) {
                    start.add(i);
                }
                // link 팀
                else if (!team[i]) {
                    link.add(i);
                }   
            }
            
            // 능력치 구하고, 최솟값 갱신
            minGap = Math.min(minGap, Math.abs(calculateSkill(start) - calculateSkill(link)));
            return;     
        }
        
        for (int i = index; i < n; i++) {
            if (!teamArr.contains(i)) {
                teamArr.add(i);
                makeTeam(personNum, i + 1);
                teamArr.remove(teamArr.size() - 1);
            }
        }
    }    
    
    // 팀 List가 오면 그 팀의 능력치를 구하는 함수
    public static int calculateSkill(ArrayList<Integer> team) {
        int skill = 0;
        // 팀원이 한 명일 때
        if (team.size() == 1) {
            int index = team.get(0);
            skill += graph[index][index];
        }
        // 팀원이 한 명이 아닐 때 
        else {
            for (int i = 0; i < team.size(); i++) {
                for (int j = i + 1; j < team.size(); j++) {
                    skill += graph[team.get(i)][team.get(j)];
                    skill += graph[team.get(j)][team.get(i)];
                }
            }
        }
        return skill; 
    }
}
