package Programmers;

/*
    https://school.programmers.co.kr/learn/courses/30/lessons/140107

    두 양의 정수 k, d가 주어질 때 다음과 같이 점을 찍으려 함.
    1. 원점(0, 0)으로부터 x축 방향으로 a*k(a = 0, 1, 2, 3 ...), y축 방향으로 b*k(b = 0, 1, 2, 3 ...)만큼 떨어진 위치에 점을 찍기.
    2. 단, 원점과 거리가 d를 넘는 위치에는 점을 찍지 않음.
    정수 k와 원점과의 거리를 나타내는 정수 d가 주어졌을 때, 점이 총 몇 개 찍히는지 구하기.
 */

public class Solution_Pro140107 {                                               //점찍기
    class Solution {

        public long solution(int k, int d) {
            long answer = 0;

            for(int i = 0; i <= d/k; i++){                  // (d/k) => 한 축에서 찍고자하는 점의 개수 최대치
                long a = 1L * i*k;
                long dd = 1L * d*d;                         //오버플로우 방지용 long 타입 변환
                long j = (long)(Math.sqrt(dd - a*a) / k);   //i일때 d 거리내 있을 수 있는 j의 최댓값

                answer += (j + 1);                          //j가 0일때도 포함
            }

            return answer;
        }
    }
}
