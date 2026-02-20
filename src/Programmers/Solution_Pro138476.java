package Programmers;

/*
    수확한 귤 중 'k'개를 골라 상자 하나에 담아 판매하려고 함.
    그런데 수확한 귤의 크기가 일정하지 않아 귤을 크기별로 분류했을 때 서로 다른 종류의 수를 최소화하고 싶음.
    *최대한 같은 종류의 귤이 한 상자에 들어가도록
    귤 k개를 고를 때 크기가 서로 다른 종류의 수의 최솟값을 return하기.
 */

import java.util.*;

public class Solution_Pro138476 {                       //귤 고르기
    class Solution {
        public int solution(int k, int[] tangerine) {
            int answer = 0;
            Map<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < tangerine.length; i++) {
                map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
            }

            //map에서 value값들만 list로 추출 후 내림차순 정렬
            List<Integer> list = new ArrayList<>(map.values());
            list.sort(Collections.reverseOrder());

            //가장 많은 갯수를 가진 크기부터 상자에 담기
            for (int num : list) {
                answer++;
                k -= num;

                //상자 꽉차면 탈출
                if (k <= 0) {
                    break;
                }
            }

            return answer;
        }
    }
}
