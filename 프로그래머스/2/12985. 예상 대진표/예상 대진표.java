class Solution
{
    public boolean isSameFloor(int a, int b) {
        // a가 홀수이고, b는 짝수이면서 둘의 차는 1이면
        if (a % 2 == 1 && b % 2 == 0 && b - a == 1) {
            return true;
        }
        return false;
    }
    
    public int solution(int n, int a, int b)
    {
        // a, b 중 작은 값을 a로 설정
        if (a > b) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        int answer = 1;

        // 4, 7 -> 1
        // 2, 4 -> 2
        // 1, 2 -> 3
        
        // 1,2  2로 나눴을때 몫이 0, 1
        // 3,4                1, 2
        // 5,6                2, 3
        // 7,8                3, 4
        // 9,10
        
  
        // 해당 값에서 // 2 -> 나머지 있으면 +1
        while (!isSameFloor(a, b)) {
            // a
            if (a % 2 == 0) {
                a = a / 2;
            }
            else {
                a = a / 2;
                a++;
            }
            
            // b
            if (b % 2 == 0) {
                b = b / 2;
            }
            else {
                b = b / 2;
                b++;
            }
            
            answer++;
        }
        
        return answer;
    }
}