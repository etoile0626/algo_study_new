package Programmers;

/*
    푸드 파이터 대회는 음식들을 일렬로 늘여놓고, 각각 가장 왼쪽과 가장 오른쪽 음식부터 순서대로 먹으며 진행됨
    *가장 가운데에는 물이 배치, 물을 먼저 먹는 사람이 승자. (물은 0번 음식)
    두 선수가 먹는 음식의 종류와 양이 같아야 하며, 음식을 먹는 순서도 같아야 함.
    또한, 이번부터는 칼로리가 낮은 음식을 먼저 먹을 수 있게 배치하고자 함.
    조건에 맞지 않은 음식은 버리고 음식의 배치를 문자열로 구하기.
    *food[i]는 i번 음식의 수, food[0]은 물이며, 항상 1입니다.
 */

public class Solution_Pro134240 {                                           //푸드 파이터 대회
    import java.util.*;

    class Solution {
        public String solution(int[] food) {
            StringBuilder sb = new StringBuilder();
            int n = food.length;

            sb.append("0");                             //제일 가운데에 0 넣고 시작

            for(int i = n-1; i > 0; i--){
                if(food[i] == 1){
                    continue;
                }

                int num = (food[i] / 2);                    //홀수개는 버리기
                for(int j = 0; j < num; j++){
                    sb.append(i);
                    sb.insert(0, i);
                }
            }

            String answer = sb.toString();
            return answer;
        }
    }
}
