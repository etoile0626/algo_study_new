package Programmers;

/*
    핸드폰 번호가 주어지면 뒷자리를 제외한 모든자리를 *으로 바꾸기
 */

public class Solution_Pro12948 {                            //핸드폰 번호 가리기
    class Solution {
        public String solution(String phone_number) {
            String answer = "";
            StringBuilder sb = new StringBuilder();

            int len = phone_number.length();
            for(int i = 0; i < len - 4; i++){
                sb.append("*");
            }

            //뒷 4자리만 추가
            sb.append(phone_number.substring(len-4));
            answer = sb.toString();

            return answer;
        }
    }
}
