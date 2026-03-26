package Programmers;

/*
    n명이 참여하는 토너먼트 형식의 게임대회가 열렸다.
    1번↔2번, 3번↔4번, ... , N-1번↔N번의 참가자끼리 게임을 진행, 이긴 사람만 다음 라운드로 진출.
    다음 라운드에 진출할 참가자의 번호는 다시 1번부터 N/2번을 차례대로 배정, 게임은 최종 한 명이 남을 때까지 진행.
    게임 참가자 수 N, 참가자 번호 A, 경쟁자 번호 B가 함수 solution의 매개변수로 주어질 때,
    처음 라운드에서 A번을 가진 참가자는 경쟁자로 생각하는 B번 참가자와 몇 번째 라운드에서 만나는지 구하기.
    *A번 참가자와 B번 참가자는 서로 붙게 되기 전까지 항상 이긴다고 가정.
 */

public class Solution_Pro12985 {                            //예상 대진표
    class Solution
    {
        public int solution(int n, int a, int b)
        {
            int answer = 1;

            while(Math.ceil(a/(double)2) != Math.ceil(b/(double)2)){
                a = (int)Math.ceil(a/(double)2);
                b = (int)Math.ceil(b/(double)2);

                answer++;
            }

            return answer;
        }
    }
}
