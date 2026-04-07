package Programmers;

/*
    가로, 세로 길이가 n인 정사각형으로된 체스판에서 n개의 퀸이 서로를 공격할 수 없도록 배치하기.
 */

public class Solution_Pro12952 {                                        //N-Queen
    class Solution {
        static boolean[] width;                             //가로열 체크
        static boolean[] diagonal1;                         //대각선 체크 1
        static boolean[] diagonal2;                         //대각선 체크 2

        public int dfs(int n, int cnt){
            int num = 0;

            if(cnt == n){
                num++;
            }
            else{
                for(int i = 0; i < n; i++){
                    //이미 퀸이 있는 경우 스킵
                    if(width[i] || diagonal1[i + cnt] || diagonal2[i - cnt + n]){
                        continue;
                    }

                    //현재 위치에 퀸을 놓는다고 가정
                    width[i] = true;
                    diagonal1[i + cnt] = true;      //i행 cnt열에 퀸이 있으므로 모든 왼쪽 아래 대각선검사
                    diagonal2[i - cnt + n] = true;   //i - cnt가 음수가 될 수 있으므로 양수 인덱스로 만들기 위해 공통적으로 n 더하기

                    num += dfs(n, cnt + 1);             //다음 위치에도 퀸을 넣기

                    //계산 끝났으므로 다시 놓은 거 치우기(백트래킹)
                    width[i] = false;
                    diagonal1[i + cnt] = false;
                    diagonal2[i - cnt + n] = false;
                }
            }

            return num;
        }

        public int solution(int n) {
            width = new boolean[n];
            diagonal1 = new boolean[n*2];                   //넉넉하게 값 잡기
            diagonal2 = new boolean[n*2];

            int answer = dfs(n, 0);

            return answer;
        }
    }
}
