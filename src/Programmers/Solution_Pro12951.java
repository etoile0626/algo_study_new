package Programmers;

/*
   JadenCase = 첫글자가 대문자, 그 외 알파벳은 소문자인 문자열(단, 첫문자가 알파벳이 아니여도 나머지 글자는 소문자)
   문자열이 주어질 때, JadenCase로 바꾼 문자열 반환하기
 */

public class Solution_Pro12951 {                                    //JadenCase 문자열 만들기
    class Solution {
        public String solution(String s) {
            String answer = "";
            int n = s.length();

            for(int i = 0; i < n; i++){
                //현재 방문중인애가 공백이면 그대로
                if(s.charAt(i) == ' '){
                    answer += s.charAt(i);
                    continue;
                }

                //첫문자거나 바로 앞에 공백이였으면 대문자, 아니면 소문자
                if(i == 0 || s.charAt(i-1) == ' '){
                    answer += Character.toUpperCase(s.charAt(i));
                } else{
                    answer += Character.toLowerCase(s.charAt(i));
                }
            }

            return answer;
        }
    }
}
