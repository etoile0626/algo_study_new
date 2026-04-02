package Programmers;

/*
    n명의 사람이 하는 영어 끝말잇기 규칙
        1. 1번부터 번호 순서대로 한 사람씩 차례대로 단어를 말합니다.
        2. 마지막 사람이 단어를 말한 다음에는 다시 1번부터 시작합니다.
        3. 앞사람이 말한 단어의 마지막 문자로 시작하는 단어를 말해야 합니다.
        4. 이전에 등장했던 단어는 사용할 수 없습니다.
        5. 한 글자인 단어는 인정되지 않습니다.
    사람의 수 n과 사람들이 순서대로 말한 단어 words 가 매개변수로 주어질 때,
    가장 먼저 탈락하는 사람의 번호와 그 사람이 자신의 몇 번째 차례에 탈락하는지 구하기.
 */

import java.util.HashMap;
import java.util.Map;

public class Solution_Pro12981 {                                        //영어 끝말잇기
    class Solution {
        public boolean isTrue(String s1, String s2){
            if(s1.charAt(s1.length()-1) == s2.charAt(0)){
                return true;
            }

            return false;
        }

        public int[] solution(int n, String[] words) {
            int[] answer = new int[2];
            Map<String, Integer> map = new HashMap<>();

            for(int i = 0; i < words.length; i++){
                map.put(words[i], map.getOrDefault(words[i], 0) + 1);

                if((map.get(words[i]) > 1) || (i > 0 && !isTrue(words[i-1], words[i]))){
                    answer[0] = (i+1) % n;

                    if(answer[0] == 0){
                        answer[0] = n;
                        answer[1] = (i+1) / n;
                    } else{
                        answer[1] = ((i+1) / n) + 1;
                    }

                    break;
                }
            }

            return answer;
        }
    }
}
