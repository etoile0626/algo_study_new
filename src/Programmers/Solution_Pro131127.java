package Programmers;

/*
    일정금액 지불시 10일간 회원자격을 부여하는 마트가 존재
    회원을 대상으로 제품 할인 행사, 할인 제품은 하루에 하나만 구매가능
    원하는 제품과 수량이 할인하는 날짜와 10일 연속으로 일치하는 경우에 회원 가입을 하려 함
    원하는 제품, 제품의 수량, 할인 제품에 대한 정보가 주어질 때
    원하는 제품을 모두 할인 받을 수 있는 '회원 등록의 날'의 총 일수 구하기
 */

import java.util.HashMap;
import java.util.Map;

public class Solution_Pro131127 {                                       //할인 행사
    class Solution {
        public int solution(String[] want, int[] number, String[] discount) {
            Map<String, Integer> map = new HashMap<>();
            int n = discount.length;
            int answer = 0;

            for(int i = 0; i < want.length; i++){
                map.put(want[i], number[i]);
            }

            for(int i = 0; i < n-9; i++){
                Map<String, Integer> tmp = new HashMap<>();

                for(int j = i; j < i + 10; j++){
                    tmp.put(discount[j], tmp.getOrDefault(discount[j], 0) + 1);

                    if(map.get(discount[j]) == null){
                        break;
                    }
                }

                if(map.equals(tmp)){
                    answer++;
                }
            }

            return answer;
        }
    }
}
