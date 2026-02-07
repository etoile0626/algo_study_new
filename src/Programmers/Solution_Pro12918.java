package Programmers;

public class Solution_Pro12918 {                                //문자열 다루기 기본
    class Solution {
        public boolean solution(String s) {
            boolean answer = true;
            int n = s.length();

            //길이가 4나 6이 아니면
            if(n != 4){
                if(n != 6){
                    return false;
                }
            }

            for(int i = 0; i < n; i++){
                int tmp = s.charAt(i) - 'a';
                if(tmp < 0){                    //음수 = 대문자 or 숫자라는 뜻
                    tmp = s.charAt(i) - 'A';
                }

                if(tmp >= 0 && tmp < 26){       //문자가 하나라도 있으면 false 처리
                    answer = false;
                    break;
                }
            }

            return answer;
        }
    }
}
