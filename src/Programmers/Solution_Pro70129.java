package Programmers;

/*
    0과 1로 이루어진 문자열 s에 "1"이 될 때까지 계속해서 s에 이진 변환을 가했을 때,
    이진 변환의 횟수와 변환 과정에서 제거된 모든 0의 개수를 각각 구하기.
    *이진 변환 = x의 모든 0을 제거후, x의 길이를 c라고 하면, x를 "c를 2진법으로 표현한 문자열"로 바꾸는 것
 */

public class Solution_Pro70129 {                                //이진 변환 반복하기
    class Solution {
        public int[] solution(String s) {
            int[] answer = new int[2];

            while(!s.equals("1")){
                for(int i = 0; i < s.length(); i++){
                    if(s.charAt(i) == '0'){
                        answer[1]++;
                    }
                }

                s = s.replace("0", "");
                int len = s.length();

                s = Integer.toBinaryString(len);

                answer[0]++;
            }

            return answer;
        }
    }
}
