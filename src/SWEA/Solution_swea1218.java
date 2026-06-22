package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/*
    4 종류의 괄호문자들 '()', '[]', '{}', '<>' 로 이루어진 문자열이 주어진다.
    이 문자열에 사용된 괄호들의 짝이 모두 맞는지 판별하기.
    *1-유효함 / 0 - 유효하지 않음.
 */

public class Solution_swea1218 {                            //[S/W 문제해결 기본] 4일차 - 괄호 짝짓기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for(int t = 1; t <= 10; t++){
            int len = Integer.parseInt(br.readLine());
            String str = br.readLine();
            Map<Character, Integer> map = new HashMap<>();
            int flag = 0;

            for(int i = 0; i < len; i++){
                char c = str.charAt(i);

                //여는 괄호를 키값으로 맵에 횟수를 저장
                if(c == '{' || c == '[' || c == '<' || c == '('){
                    map.put(c, map.getOrDefault(c, 0)+1);
                }

                //닫는 괄호가 있으면 횟수 감소
                if(c == ')'){
                    map.put('(', map.getOrDefault('(', 0)-1);
                } else if(c == '>'){
                    map.put('<', map.getOrDefault('<', 0)-1);
                } else if(c == ']'){
                    map.put('[', map.getOrDefault('[', 0)-1);
                } else if (c == '}') {
                    map.put('{', map.getOrDefault('{', 0)-1);
                }
            }

            //여는괄호와 닫는 괄호의 개수가 모두 일치한지 검사
            if(map.getOrDefault('(', 0) == 0 && map.getOrDefault('{', 0) == 0
                    && map.getOrDefault('[', 0) == 0 && map.getOrDefault('<', 0) == 0){
                flag = 1;
            }

            sb.append("#").append(t).append(" ").append(flag).append("\n");
        }

        System.out.println(sb.toString());
    }
}
