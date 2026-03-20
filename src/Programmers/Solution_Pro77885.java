package Programmers;

/*
    f(x) = 'x보다 크고 x와 비트가 1~2개 다른 수들 중 제일 작은 수'라고 정의할때,
    numbers 배열의 모든 수들에 대하여 각 수의 f 값을 배열에 차례대로 담아 구하기.
 */

public class Solution_Pro77885 {                            //2개 이하로 다른 비트
    //다시 풀기
    class Solution {
        public long[] solution(long[] numbers) {
            int n = numbers.length;
            long[] answer = new long[n];

            for(int i = 0; i < n; i++){
                long num = numbers[i];

                if(num % 2 == 0){
                    answer[i] = numbers[i] + 1;             //짝수는 무조건 다음 수가 조건을 만족함
                }
                else {
                    long bit = 1;

                    // 오른쪽부터 처음으로 0이 나오는 위치 찾기
                    while ((num & bit) != 0) {
                        bit <<= 1;                                  //찾은 0을 1로 바꾸기 위해 같은 위치까지 이동
                    }

                    answer[i] = num | bit;                         //오른쪽부터 처음으로 나온 0 1로 바꾸기
                    answer[i] = answer[i] & ~(bit >> 1);            //바꾼 위치의 바로 오른쪽 비트 0으로 변환
                }
            }

            return answer;
        }
    }
}
