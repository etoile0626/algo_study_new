package Programmers;

/*
    2n x 2n 크기의 2차원 정수 배열 arr이 있을 때, 아래와 같은 방식으로 압축하고자 함.
    1. 압축하고자 하는 특정 영역을 S라고 할 때, 내부에 있는 모든 수가 같은 값이라면, S를 해당 수 하나로 압축
    2. 그렇지 않다면, S를 정확히 4개의 균일한 정사각형 영역으로 쪼갠 뒤, 각 정사각형 영역에 대해 같은 방식의 압축을 시도
    arr을 압축했을 때, 배열에 최종적으로 남는 0의 개수와 1의 개수를 배열에 담아서 return하기.
 */

public class Solution_Pro68936 {                                //쿼드압축 후 개수 세기
    class Solution {
        static int zero;
        static int one;

        public void split(int[][] arr, int x, int y, int size){
            int num = arr[x][y];
            boolean flag = true;

            for(int i = x; i < x + size; i++){
                for(int j = y; j < y + size; j++){
                    if(num != arr[i][j]){
                        flag = false;
                        break;
                    }
                }

                if(!flag){
                    break;
                }
            }

            if(flag){
                if(num == 0){
                    zero++;
                }else{
                    one++;
                }
            } else{
                split(arr, x, y, size / 2);
                split(arr, x + size/2, y, size / 2);
                split(arr, x, y + size/2, size / 2);
                split(arr, x + size/2, y + size/2, size / 2);
            }
        }

        public int[] solution(int[][] arr) {
            int[] answer = new int[2];
            int n = arr.length;             //한 변의 길이
            zero = 0;                       //0의 개수
            one = 0;                        //1의 개수

            split(arr, 0, 0, n);

            answer[0] = zero;
            answer[1] = one;

            return answer;
        }
    }
}
