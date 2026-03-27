package Programmers;

/*
    길이가 같은 두 배열에서 한 개씩 숫자를 뽑아 두 수를 곱함.
    이 과정을 배열의 길이만큼 반복, 두 수를 곱한 값을 누적해서 더함.
    이때, 누적된 값이 최소가 되도록 하고자 함. (단, 이미 뽑은수는 다시 뽑을 수 없음.)
    최종적으로 누적된 최솟값 구하기.
 */

import java.util.Arrays;

public class Solution_Pro12941 {                                        //최솟값 만들기
    class Solution
    {
        public int solution(int []A, int []B)
        {
            int answer = 0;
            int n = A.length;

            Arrays.sort(A);
            Arrays.sort(B);

            for(int i = 0; i < n; i++){
                answer += A[i] * B[n - i - 1];                      //매 시도 마다 최댓값 * 최솟값 해주기
            }

            return answer;
        }
    }
}
