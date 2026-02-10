package Programmers;

public class Solution_Pro12916 {            //문자열 내 p와 y의 개수
    class Solution {
        boolean solution(String s) {
            boolean answer = true;

            int cnt_p = 0;
            int cnt_y = 0;
            int n = s.length();

            String str = s.toLowerCase();

            for(int i = 0; i < n; i++){
                if(str.charAt(i) == 'p'){
                    cnt_p++;
                } else if(str.charAt(i) == 'y'){
                    cnt_y++;
                }
            }

            if(cnt_p != cnt_y){
                answer = false;
            }

            return answer;
        }
    }
}
