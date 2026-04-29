package Programmers;

public class Solution_Pro12917 {                            //문자열 내림차순으로 배치하기
    class Solution {
        public String solution(String s) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String str = new String(c);
            String answer = new StringBuilder(str).reverse().toString();

            return answer;
        }
    }
}
