package Programmers;

/*
    n명으로 연속되는 적의 공격을 순서대로 막는 게임이 아래와 같은 규칙으로 존재한다.
    1. n명의 병사로 게임시작
    2. emrmy[i]마리의 적이 매 라운드마다 등장, emrmy[i]명의 병사를 소모해 막을 수 있음.
    3. 남은 병사의 수보다 현재 라운드의 적의 수가 더 많으면 게임 종료.
    4. '무적권' 사용시 병사 소모 없이 라운드 진행 가능, 최대 k개 존재.
    일때, 최대 몇라운드까지 막을 수 있을지 구하기.
 */

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution_Pro142085 {                                   //디펜스 게임
    class Solution {
        public int solution(int n, int k, int[] enemy) {
            int answer = 0;
            int num = enemy.length;

            //내림차순 우선순위 큐
            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

            for(int i = 0; i < num; i++){
                pq.offer(enemy[i]);

                //병사 수를 잃을거 같으면
                if(n - enemy[i] < 0){
                    if(k == 0){             //무적권 없으면 탈락처리
                        break;
                    }

                    //지금까지 지나온 라운드 중 가장 큰 적이 있던 라운드에 무적권 사용(인원수 복구)
                    k--;
                    n += pq.poll();
                }

                n -= enemy[i];
                answer++;
            }

            return answer;
        }
    }
}
