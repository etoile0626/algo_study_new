package Programmers;

/*
    https://school.programmers.co.kr/learn/courses/30/lessons/131705
 */

public class Solution_Pro131705 {                           //삼총사
    class Solution {
        static int[] arr = new int[3];
        static int n, answer;

        //재귀호출
        public void bfs(int cnt, int idx, int[] number){
            //3개의 원소 선정이 끝나면 탈출
            if(cnt == 3){
                if(arr[0] + arr[1] + arr[2] == 0){
                    answer++;
                }
                return;
            }

            //중복 조합을 없애기위해 idx부터 탐색 시작
            for(int i = idx; i < n; i++){
                arr[cnt] = number[i];
                bfs(cnt + 1, i + 1, number);
            }
        }

        public int solution(int[] number) {
            n = number.length;
            answer = 0;

            bfs(0, 0, number);

            return answer;
        }
    }
}
