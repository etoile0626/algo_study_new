package Programmers;

import java.util.*;

/*
    https://school.programmers.co.kr/learn/courses/30/lessons/178871
 */
public class Solution_Pro178871 {                               // 달리기 경주
    class Solution {
        public static String[] solution(String[] players, String[] callings) {
            Map<String, Integer> map = new HashMap<>();

            int n = players.length;
            String[] arr = new String[n];
            for(int i = 0; i < n; i++){
                arr[i] = players[i];
                map.put(players[i], i);
            }

            for(String str: callings){
                int idx = map.get(str);

                String tmp = arr[idx-1];
                arr[idx-1] = str;
                arr[idx] = tmp;

                map.put(str, idx - 1);
                map.put(tmp, idx);
            }

            return arr;
        }
    }

    public static void main(String[] args) {
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};

        String[] arr = Solution.solution(players, callings);

        for(String str : arr){
            System.out.println(str);
        }
    }
}
