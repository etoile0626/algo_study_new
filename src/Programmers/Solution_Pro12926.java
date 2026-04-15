package Programmers;

public class Solution_Pro12926 {                    //시저 암호
    class Solution {
        public String solution(String s, int n) {
            StringBuilder sb = new StringBuilder();

            for(int i = 0; i < s.length(); i++){
                //공백이면
                if(s.charAt(i) == ' '){
                    sb.append(" ");
                }
                //소문자면
                else if(s.charAt(i) - 'a' >= 0 && s.charAt(i) - 'a' < 26){
                    sb.append((char)((s.charAt(i) - 'a' + n) % 26 + 'a'));
                }
                //대문자면
                else if(s.charAt(i) - 'A' >= 0 && s.charAt(i) - 'A' < 26){
                    sb.append((char)((s.charAt(i) - 'A' + n) % 26 + 'A'));
                }
            }

            String answer = sb.toString();

            return answer;
        }
    }
}
