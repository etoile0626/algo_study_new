package Programmers;

public class Solution_Pro12903 {                                //가운데 글자 가져오기
    class Solution {
        public String solution(String s) {
            String answer = "";

            int n = s.length();
            int mid = n/2;

            if(n % 2 == 0){
                answer = s.substring(mid - 1, mid + 1);
            } else{
                answer = s.charAt(mid) + "";
            }

            return answer;
        }
    }
}
