package 프로그래머스;

public class PSG방금그곡 {
    public String convertSharp(String s) {
        return s.replaceAll("C#", "c")
                .replaceAll("D#", "d")
                .replaceAll("F#", "f")
                .replaceAll("G#", "g")
                .replaceAll("A#", "a");
    }
    
    public int convertToMin(String time) {
        String[] t = time.split(":");
        return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
    }
    
    public String buildMelody(String melody, int playTime) { 
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < playTime; i++) {
            sb.append(melody.charAt(i % melody.length()));
        }
        return sb.toString();
    }
    
    public boolean check(String m, String playMelody) {       
        return playMelody.contains(m);
    }
    
    public String solution(String m, String[] musicinfos) {
        m = convertSharp(m); // # 처리
        String answer = "(None)";
        int maxPlayTime = -1;
        
        for (String info : musicinfos) {
            String[] arr = info.split(",");
            
            int startTime = convertToMin(arr[0]);
            int endTime = convertToMin(arr[1]);
            int playTime = endTime - startTime;
            
            String title = arr[2];
            String melody = convertSharp(arr[3]); // # 처리
            String playMelody = buildMelody(melody, playTime);
            
            if (check(m, playMelody)) {
                if (playTime > maxPlayTime) {
                    maxPlayTime = playTime;
                    answer = title;
                }
            }
        }
        
        return answer;
    }
}
