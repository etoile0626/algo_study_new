package Programmers;

/*
    최소한의 객실만을 사용하여 예약 손님을 받으려고 함
    사용한 객실은 퇴실시간을 기준으로 10분간 청소 후 사용가능
    예약 시간을 2차원 문자열 배열 형태로 주어질 때, 필요한 최소 객실 수 구하기
    *book_time[i]는 ["HH:MM", "HH:MM"]
    *시각은 HH:MM 형태로 24시간 표기법을 따르며, "00:00" 부터 "23:59"
 */

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution_Pro155651 {                                       //호텔 대실
    class Solution {
        public int solution(String[][] book_time) {
            int n = book_time.length;

            int[][] time = new int[n][2];
            for(int i = 0; i < n; i++){
                String[] tmp1 = book_time[i][0].split(":");                  //시작 시간
                String[] tmp2 = book_time[i][1].split(":");                  //종료 시간

                time[i][0] = Integer.parseInt(tmp1[0]) * 60 + Integer.parseInt(tmp1[1]);
                time[i][1] = Integer.parseInt(tmp2[0]) * 60 + Integer.parseInt(tmp2[1]) + 10;   //청소시간까지 포함
            }

            //시작 시간을 기준으로 정렬
            Arrays.sort(time, (a, b) -> a[0] - b[0]);                   //start 기준 정렬
            PriorityQueue<Integer> pq = new PriorityQueue<>();

            for(int i = 0; i < n; i++){
                int start = time[i][0];
                int end = time[i][1];

                if(!pq.isEmpty() && pq.peek() <= start){    //가장 빠른 종료시간이 현재 예약보다 빠르면(방 사용이 가능하면)
                    pq.poll();                              //큐에서 제거(방 재사용 가능)
                }

                pq.offer(end);                              //현재 예약 배정
            }

            int answer = pq.size();
            return answer;
        }
    }
}
