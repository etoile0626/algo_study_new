package Programmers;

public class Solution_Pro147355 {                       //크기가 작은 부분 문자열
    class Solution {
        public int solution(String t, String p) {
            long num = Long.parseLong(p);
            int length = t.length() - p.length();
            int answer = 0;

            for (int i = 0; i <= length; i++) {
                String temp = t.substring(i, i + p.length());

                if (Long.parseLong(temp) <= num) {
                    answer++;
                }
            }

            return answer;
        }
    }
}
