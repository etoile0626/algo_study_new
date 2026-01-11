package Programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution_Pro138477 {                                                               //명예의 전당 (1)
    class Solution {
        public int[] solution(int k, int[] score) {
            int n = score.length;
            int[] answer = new int[n];

            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < n; i++){
                if(i < k){
                    list.add(score[i]);
                } else {
                    if(list.get(0) < score[i]){
                        list.remove(0);
                        list.add(score[i]);
                    }
                }

                Collections.sort(list);
                answer[i] = list.get(0);
            }

            return answer;
        }
    }
}
