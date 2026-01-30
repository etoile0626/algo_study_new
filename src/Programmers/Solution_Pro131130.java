package Programmers;

/*
    임의의 상자 하나를 골라 카드를 확인, 그 후 카드에 적힌 숫자에 해당하는 상자를 열기를 반복
    (이미 연 상자를 고를 때까지 반복 = 처음 연 상자를 고를때까지) / 이렇게 연 상자 그룹을 1번 그룹으로 지칭.
    만약 1번 그룹을 제외한 남은 상자가 없다면 0점.
    그렇지 않다면 다시 임의의 상자를 골라 반복 / 이렇게 연 상자 그룹은 2번 그룹.
    (1번 그룹 수 * 2번 그룹 수) = (게임의 점수)일때, 얻을 수 있는 최고 점수를 구하기.
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution_Pro131130 {                                       //혼자 놀기의 달인
    class Solution {
        public int solution(int[] cards) {
            int n = cards.length;
            int answer = 0;
            List<Integer> list = new ArrayList<>();
            boolean[] visit = new boolean[n];

            for(int i = 0; i < n; i++){
                if(visit[i]){
                    continue;
                }

                int num = cards[i] - 1;
                int cnt = 0;

                //각 상자 그룹 카운팅
                while(!visit[num]){
                    visit[num] = true;
                    num = cards[num] - 1;
                    cnt++;
                }

                list.add(cnt);                  //카운팅한 상자 그룹 리스트에 넣기
            }

            //내림차순 정렬
            list.sort(Comparator.reverseOrder());

            //1번 그룹 하나 밖에없으면 당연히 답은 0
            if(list.size() == 1){
                return 0;
            }

            //가장 큰거 2개만 뽑기
            answer = list.get(0) * list.get(1);
            return answer;
        }
    }
}
