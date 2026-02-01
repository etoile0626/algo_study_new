package Programmers;

/*
    사과를 상태에 따라 1점부터 k점까지 점수를 분류하고자 함.
    사과 상자는 m개씩 포장하고, 상자에 담긴 사과의 최하점 p점이 존재할 때, 상자의 가격을 p * m으로 정의함.
    가능한 많은 상자를 팔 때, 얻을 수 있는 최대 이익 계산하기.
    *사과는 상자 단위로 판매, 남은 사과는 버리기.
 */

import java.util.Arrays;

public class Solution_Pro135808 {                   //과일 장수
    class Solution {
        public int solution(int k, int m, int[] score) {
            int answer = 0;
            int n = score.length;
            int boxNum = n / m;

            Arrays.sort(score);

            if(n % m == 0) {
                for(int i = 0; i < boxNum; i++) {
                    answer += (score[i * m]) * m * 1;
                }
            } else {
                int rest = n % m;

                for(int i = 0; i < boxNum; i++) {
                    answer += (score[rest + (i * m)]) * m * 1;
                }
            }

            return answer;
        }
    }
}
