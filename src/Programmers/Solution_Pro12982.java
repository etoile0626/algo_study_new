package Programmers;

/*
    전체 예산이 정해져 있기 때문에 최대한 많은 부서의 물품을 구매하고자 함.
    각 부서가 신청한 금액만큼을 모두 지원해 줘야 함.
    부서별로 신청한 금액이 들어있는 배열 d와 예산 budget이 매개변수로 주어질 때, 최대 몇 개의 부서에 물품을 지원할 수 있는지 구하기.
 */

import java.util.Arrays;

public class Solution_Pro12982 {                            //예산
    class Solution {
        public int solution(int[] d, int budget) {
            int answer = 0;

            Arrays.sort(d);
            for(int i = 0; i < d.length; i++){
                if(budget - d[i] >= 0){
                    budget = budget - d[i];
                    answer++;
                }
            }

            return answer;
        }
    }
}
