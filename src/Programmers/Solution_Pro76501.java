package Programmers;

/*
    정수들의 절댓값을 차례대로 담은 정수 배열 absolutes와 이 정수들의 부호를 차례대로 담은 불리언 배열 signs가 매개변수로 주어집니다. 실제 정수들의 합을 구하기
 */

public class Solution_Pro76501 {                    //음양 더하기
    class Solution {
        public int solution(int[] absolutes, boolean[] signs) {
            int answer = 0;

            for(int i = 0; i < signs.length; i++){
                if(!signs[i]){
                    absolutes[i] *= -1;
                }

                answer += absolutes[i];
            }

            return answer;
        }
    }
}
