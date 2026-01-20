package Programmers;

/*
    다음 조건을 만족하며 한 기둥에 꽂힌 원판을 다은 기둥으로 옮기고 자 함.
    1. 한 판에 하나의 원판만 옮길 수 있다.
    2. 큰 원판이 작은 원판 위에 있어서는 안 된다.
    3개의 기둥이 있고, n개의 원판을 1번 기둥에서 3번 기둥으로 최소한의 횟수로 옮기는 방법 구하기.
    *정답은 2차원 배열 형태로 제공, 0 < n <= 15
    *[ [1,2], [1,3], [2,3] ] = 1번에서 2번으로, 1번에서 3번으로, 2번에서 3번으로 라는 뜻
 */

import java.util.ArrayList;
import java.util.List;

public class Solution_Pro12946 {                                //하노이의 탑
    class Solution {
        static List<int[]> list;

        private static void move(int n, int start, int mid, int end){   //n개의 원판을 start에서 mid를 거쳐 end로 이동
            //아 마따 탈출조건
            if(n == 0){
                return;
            }

            move(n-1, start, end, mid);                             //1번에서 3번을 경유해서 2번으로 n-1개 쌓기
            list.add(new int[] {start, end});                       //n번 원판 목표위치로 옮김
            move(n-1, mid, start, end);                             //2번에서 1번을 경유해서 3번으로 n-1개 다시 옮김
        }

        public int[][] solution(int n) {
            list = new ArrayList<>();

            move(n, 1, 2, 3);
            int[][] answer = list.stream().toArray(int[][]::new);  //list 내용을 배열로 만듦(이미 내용물이 배열이라 2차원 배열로)

            return answer;
        }
    }
}
