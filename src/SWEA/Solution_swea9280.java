package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_swea9280 {                            //진용이네 주차타워
    //다시 풀기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] fees = new int[n];                                //i 주차공간의 요금
            int[] weight = new int[m + 1];                          //무게
            int[] park = new int[m + 1];                            //i번 차량이 주차된 위치

            for (int i = 0; i < n; i++) {
                fees[i] = Integer.parseInt(br.readLine());
            }
            for (int car = 1; car <= m; car++) {
                weight[car] = Integer.parseInt(br.readLine());
            }

            PriorityQueue<Integer> pq = new PriorityQueue<>();  //주차 가능 공간, 번호가 작은 주차 칸을 먼저 사용하기 위해 우선순위 큐.
            for (int i = 0; i < n; i++) {
                pq.offer(i);
            }

            ArrayDeque<Integer> waiting = new ArrayDeque<>();   //대기열
            long fee = 0;

            for (int i = 0; i < 2 * m; i++) {
                int event = Integer.parseInt(br.readLine());            //입출차 명령

                //입차
                if (event > 0) {
                    if (pq.isEmpty()) {                                 //주차할 곳이 없으면 대기
                        waiting.offer(event);
                    } else {
                        int spot = pq.poll();
                        park[event] = spot;
                        fee += (long) fees[spot] * weight[event];
                    }
                }
                //출차
                else {
                    int car = -1 * event;
                    int freedSpot = park[car];

                    if (waiting.isEmpty()) {                                    //대기열이 없으면 빈 공간만 추가
                        pq.offer(freedSpot);
                    } else {                                                    //대기열이 있으면 출차 직후 대기열에서 차 넣기
                        int waitingCar = waiting.poll();
                        park[waitingCar] = freedSpot;
                        fee += (long) fees[freedSpot] * weight[waitingCar];
                    }
                }
            }

            sb.append("#").append(t).append(" ").append(fee).append("\n");
        }

        System.out.println(sb.toString());
    }
}
