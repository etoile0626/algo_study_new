package Programmers;

/*
    String형 배열에서 "Kim"의 위치 x를 찾아, "김서방은 x에 있다"는 String을 반환하는 함수 만들기
    *"Kim"은 반드시 하나만 존재
 */

public class Solution_Pro12919 {                            //서울에서 김서방 찾기
    class Solution {
        public String solution(String[] seoul) {
            StringBuilder sb = new StringBuilder();
            int n = seoul.length;

            sb.append("김서방은 ");
            for(int i = 0; i < n; i++){
                if(seoul[i].equals("Kim")){
                    sb.append(i);
                    break;
                }
            }
            sb.append("에 있다");

            String answer = sb.toString();
            return answer;
        }
    }
}
