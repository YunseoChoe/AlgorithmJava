package 프로그래머스;

public class PSG방금그곡 {
    public int convertToMin(String time) {
        // 총 분 변환 함수
        // ex) 12:00 -> 720(m)
        
        String[] t = time.split(":");
        int hour = Integer.parseInt(t[0]);
        int min = Integer.parseInt(t[1]);
        
        return hour * 60 + min;
    }
    
    public String buildMelody(String melody, int playTime) { 
        // 최종 재생 멜로디 만들기
        StringBuilder sb = new StringBuilder();
        
        String returnMelody = melody; 
        for (int i = 0; i < playTime; i++) {
            sb.append(melody.charAt(i % melody.length()));
        }
        
        System.out.println("최종 재생된 멜로디: " + sb.toString());
        return sb.toString(); // 문자열로 변화해서 return.
    }
    
    public boolean check(String m, String playMelody, int playTime) {       
        return playMelody.contains(m);
    }
    
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        
        for (String info : musicinfos) {
            String[] arr = info.split(",");
            
            int startTime = convertToMin(arr[0]);
            int endTime = convertToMin(arr[1]);
            String title = arr[2];
            String melody = arr[3];
            String playMelody = buildMelody(melody, endTime - startTime);
            

            if (check(m, playMelody, endTime - startTime)) {
                answer += title;
            }
        }
        
        return answer;
    }
}
