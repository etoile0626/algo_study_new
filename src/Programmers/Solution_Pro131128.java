package Programmers;

/*
    정수 2개가 주어질 때, 임의의 자리에서 공통으로 나타나는 정수 k들을 이용해 만들 수 있는 가장 큰 수를 두 정수의 짝꿍이라고 함
    *짝꿍이 존재하지 않으면, 짝꿍은 -1로 취급
    *0으로만 구성되어 있다면, 짝꿍은 0
    두 정수 X, Y가 주어졌을 때, X, Y의 짝꿍을 구하기
 */

public class Solution_Pro131128 {                                           //숫자 짝꿍
    class Solution {
        public String solution(String X, String Y) {
            int[] cntX = new int[10];
            int[] cntY = new int[10];

            for(int i = 0; i < X.length(); i++){
                int num = X.charAt(i) - '0';
                cntX[num]++;
            }

            for(int i = 0; i < Y.length(); i++){
                int num = Y.charAt(i) - '0';
                cntY[num]++;
            }

            StringBuilder sb = new StringBuilder();
            for(int i = 9; i >= 0; i--){
                int cnt = Math.min(cntX[i], cntY[i]);

                for(int j = 0; j < cnt; j++){
                    sb.append(i);
                }
            }

            String answer = sb.toString();
            if(answer.equals("")){
                answer = "-1";
            } else if(answer.startsWith("0")){
                answer = "0";
            }

            return answer;
        }
    }
}
