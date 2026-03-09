package Programmers;

/*
    밑변의 길이와 높이가 n인 삼각형에서 맨 위 꼭짓점부터 반시계 방향으로 달팽이 채우기를 진행한 후,
    첫 행부터 마지막 행까지 모두 순서대로 합친 새로운 배열을 구하기
 */

public class Solution_Pro68645 {                                    //삼각 달팽이
    class Solution {
        public int[] solution(int n) {
            int[] answer = new int[(n * (n+1)) / 2];
            int[][] arr = new int[n][n];
            int cnt = 1;
            int idx = 0;
            int x = -1;                             //1번도 이동에 염두
            int y = 0;

            for(int i = 0; i < n; i++){
                for(int j = i; j < n; j++){
                    if(i % 3 == 0){                 //아래로 가는 경우
                        x++;
                    } else if(i % 3 == 1){          //오른쪽으로 가는 경우
                        y++;
                    } else if(i % 3 == 2){          //대각선으로(왼쪽 위로) 가는 경우
                        x--;
                        y--;
                    }

                    arr[x][y] = cnt;
                    cnt++;
                }
            }

            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(arr[i][j] == 0){
                        break;
                    }

                    answer[idx] = arr[i][j];
                    idx++;
                }
            }

            return answer;
        }
    }
}
