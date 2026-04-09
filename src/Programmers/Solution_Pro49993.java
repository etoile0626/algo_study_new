package Programmers;

/*
    선행 스킬 순서 skill과 유저들이 만든 스킬트리1를 담은 배열 skill_trees가 매개변수로 주어질 때, 가능한 스킬트리 개수를 구하기
    *선행 스킬이란 어떤 스킬을 배우기 전에 먼저 배워야 하는 스킬
    *위 순서에 없는 다른 스킬(힐링 등)은 순서에 상관없이 배울 수 있음.
 */

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution_Pro49993 {                                        //스킬트리
    class Solution {
        public int solution(String skill, String[] skill_trees) {
            int answer = 0;

            for(int i = 0; i < skill_trees.length; i++){
                boolean flag = true;
                Queue<Character> q = new ArrayDeque<>();

                for(int k = 0; k < skill.length(); k++){
                    q.offer(skill.charAt(k));
                }

                for(int j = 0; j < skill_trees[i].length(); j++){
                    char c = skill_trees[i].charAt(j);

                    if(!q.contains(c)){
                        continue;
                    }
                    else{
                        if(c != q.peek()){
                            flag = false;
                            break;
                        } else{
                            q.poll();
                        }
                    }
                }

                if(flag){
                    answer++;
                }
            }


            return answer;
        }
    }
}
