package Programmers;

/*
    컨베이어 밸트에 1번부터 n번까지 택배상자가 순서대로 오고, 영재는 이 택배상자들을 트럭에 실어야 함
    트럭에는 정해진 순서로 트럭에 실어야해서, 순서에 맞지 않는 택배상자는 보조 컨베이어 밸트에 놓아둠
    *보조 컨테이너 = 스택
    보조 컨테이너를 이용해도 순서대로 택배를 실지 못한다면, 동작 중단.
    원하는 상자 순서를 나타내는 정수 배열 order가 주어졌을 때, 영재가 몇 개의 상자를 실을 수 있는지 구하기
 */

import java.util.Stack;

public class Solution_Pro131704 {                   //택배상자
    class Solution {
        public int solution(int[] order) {
            Stack<Integer> stack = new Stack<>();

            int n = order.length;
            int answer = 0;
            int idx = 0;
            for(int i = 0; i < n; i++){
                stack.push(i + 1);                      //일단 택배를 보조 컨베이어에 올려!

                //보조 컨베이어 검사
                while(!stack.isEmpty() && stack.peek() == order[idx]){
                    stack.pop();
                    answer++;
                    idx++;
                }

                //order 끝까지 탐색했는지 여부 체크
                if(idx == n){
                    break;
                }
            }

            return answer;
        }
    }
}
