package Programmers;

/*
    롤케이크를 두 조각으로 자르려고 함
    토핑의 개수와 상관없이, '동일한 가짓수의' 토핑이 올려진 두 조각으로 잘리면 공평하다고 판단
    롤케이크를 공평하게 자르는 방법의 수 구하기
 */

import java.util.HashMap;
import java.util.Map;

public class Solution_Pro132265 {                       //롤케이크 자르기
    class Solution {
        public int solution(int[] topping) {
            Map<Integer, Integer> map1 = new HashMap<>();   //왼쪽 케이크
            Map<Integer, Integer> map2 = new HashMap<>();   //오른쪽 케이크

            int answer = 0;
            int n = topping.length;
            int left = 0;
            int right = 0;

            //오른쪽이 모든 조각을 차지하고 시작
            for(int i = 0; i < n; i++){
                map2.put(topping[i], map2.getOrDefault(topping[i], 0) + 1);
            }

            right = map2.size();

            //왼쪽이 한 조각씩 차지하기 (동시에 오른쪽은 하나 뺏기)
            for(int i = 0; i < n-1; i++){
                map1.put(topping[i], map1.getOrDefault(topping[i], 0) + 1);
                if(map1.get(topping[i]) == 1){
                    left++;
                }

                map2.put(topping[i], map2.get(topping[i]) -1);
                if(map2.get(topping[i]) == 0){
                    right--;
                }

                if(left == right){
                    answer++;
                }
            }

            return answer;
        }
    }
}
