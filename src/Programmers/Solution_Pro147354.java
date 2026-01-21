package Programmers;

/*
    어떤 데이터베이스의 한 테이블은 2차원 행렬로 표현할 수 있으며 열은 컬럼을 나타내고, 행은 튜플을 의미.
    첫 번째 컬럼은 기본키로서 모든 튜플에 대해 그 값이 중복되지 않도록 보장.
    만들고자하는 해시 함수가
    1. 해시 함수는 col, row_begin, row_end을 입력받음
    2. 튜플을 col번째 컬럼의 값을 기준으로 오름차순 정렬을 하되, 만약 그 값이 동일하면 기본키인 첫 번째 컬럼의 값을 기준으로 내림차순 정렬.
    3. S_i를 i 번째 행의 튜플에 대해 각 컬럼의 값을 i 로 나눈 나머지들의 합으로 정의.
    4. row_begin ≤ i ≤ row_end 인 모든 S_i를 누적하여 bitwise XOR 한 값을 해시 값으로서 반환
    하는 과정을 거칠 때, 테이블의 해시 값을 return 하도록 solution 함수를 완성하기
 */

import java.util.Arrays;

public class Solution_Pro147354 {                                   //테이블 해시 함수
    class Solution {
        public int solution(int[][] data, int col, int row_begin, int row_end) {
            int n = data.length;
            int m = data[0].length;
            int[] s_i = new int[n];

            Arrays.sort(data, (a, b) -> {
                if (a[col - 1] != b[col - 1]) {     //비교 대상이 값이 다르면
                    return a[col - 1] - b[col - 1]; // 오름차순
                }
                return b[0] - a[0]; // 같은 경우 첫번째 값 기준으로 내림차순
            });

            for(int i = row_begin-1; i < row_end; i++){
                for(int j = 0; j < m; j++){
                    s_i[i] += data[i][j] % (i+1);
                }
            }

            int answer = s_i[row_begin-1];                  //첫번째 탐색값으로 초기화
            for(int i = row_begin; i < row_end; i++){       //2번째 row부터 마지막 row까지 탐색하며
                answer = answer ^ s_i[i];                   //XOR 연산
            }

            return answer;
        }
    }
}
