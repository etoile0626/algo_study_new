package Programmers;

/*
    페인트가 칠해진 n 미터 벽이 있다. 이 벽을 다시 칠하기 위해 n개의 구역으로 나누고 왼쪽부터 1번~n번까지의 번호를 부여함
    페인트를 칠하는 롤러의 길이는 m 미터, 롤러로 '한 번' 페인트를 칠하기 위해서는
    1. 롤러가 벽에서 벗어나면 안 됨.
    2. 구역의 일부분만 칠할 수 없음.
    을 만족해야 한 번 칠했다고 얘기함.
    정수 n, m과 다시 칠할 구역이 section 정수 배열이 주어질 때, 페인트 칠을 해야하는 최소횟수 구하기
 */

public class Solution_Pro161989 {                   //덧칠하기
    class Solution {
        public int solution(int n, int m, int[] section) {
            int answer = 1;

            int start = section[0];
            int paint = start + m - 1;

            int num = section.length;
            for(int i = 0; i < num; i++){
                if(paint >= section[i]){
                    continue;
                }

                start = section[i];
                paint = start + m - 1;
                answer++;
            }

            return answer;
        }
    }
}
