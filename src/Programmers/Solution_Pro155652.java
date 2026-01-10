package Programmers;

/*
    문자열 s, skip, 자연수 index가 주어질 때,
    1. s의 각 알파벳을 index만큼 뒤의 알파벳으로 교체
    2. index만큼 뒤의 알파벳이 z를 넘어가면, a부터 다시 시작
    3. skip에 있는 알파벳을 제외하고 넘어가기
    위의 규칙을 만족하도록 문자열 s를 변환한 결과 출력
 */

import java.util.HashSet;
import java.util.Set;

public class Solution_Pro155652 {                   //둘만의 암호
    class Solution {
        public String solution(String s, String skip, int index) {
            int n = s.length();
            int m = skip.length();
            Set<Character> set = new HashSet<>();
            String answer = "";

            for(int i = 0; i < m; i++){
                set.add(skip.charAt(i));
            }

            for(int i = 0; i < n; i++){
                char c = s.charAt(i);

                int cnt = 0;
                while(cnt < index){
                    c = (char) ((c - 'a' + 1) % 26 + 'a');              //z 이후로 넘어가면 다시 a로 돌아오게 만들기

                    if(set.contains(c)){
                        continue;
                    }

                    cnt++;
                }

                answer += c;
            }

            return answer;
        }
    }
}
