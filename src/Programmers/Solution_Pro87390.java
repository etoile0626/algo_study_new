package Programmers;

/*
    n, left, right가 주어집니다. 다음 과정을 거쳐서 1차원 배열을 만들고자 합니다.
        1. n행 n열 크기의 비어있는 2차원 배열을 만듭니다.
        2. i = 1, 2, 3, ..., n에 대해서, 다음 과정을 반복합니다.
            1행 1열부터 i행 i열까지의 영역 내의 모든 빈 칸을 숫자 i로 채웁니다.
        3. 1행, 2행, ..., n행을 잘라내어 모두 이어붙인 새로운 1차원 배열을 만듭니다.
        4. 새로운 1차원 배열을 arr이라 할 때, arr[left], arr[left+1], ..., arr[right]만 남기고 나머지는 지웁니다.
    이렇게 만들어진 1차원 배열 구하기.
 */

public class Solution_Pro87390 {                            //n^2 배열 자르기
    //다시 풀기
    class Solution {
        public int[] solution(int n, long left, long right) {
            int len = (int)(right - left + 1);
            int[] answer = new int[len];

            int idx = 0;
            for(long i = left; i <= right; i++){
                long r = i / n;                     //arr의 i번째 인덱스가 2차원 배열에서 위치한 행
                long c = i % n;                     //arr의 i번째 인덱스가 2차원 배열에서 위치한 열

                answer[idx++] = Math.max((int)r, (int)c) + 1;
            }

            return answer;
        }
    }
}
