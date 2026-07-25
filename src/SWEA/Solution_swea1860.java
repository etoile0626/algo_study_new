package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
    진기는 0초부터 붕어빵을 만들기 시작하며, M초의 시간을 들이면 K개의 붕어빵을 만들 수 있다.
    N명의 사람이 0초 이후에 언제 도착하는지 주어지면, 모든 손님들에게 "기다리는 시간없이" 붕어빵을 제공할 수 있는지 판별하기.
 */

public class Solution_swea1860 {                                    //진기의 최고급 붕어빵
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for(int i = 0; i <n; i++){
                pq.offer(Integer.parseInt(st.nextToken()));
            }

            boolean flag = true;
            int served = 0;                         //손님에게 제공한 누적 빵수
            while (!pq.isEmpty()){
                int time = pq.poll();
                int bread = (time / m) * k;         //time까지 완성된 빵의 수

                if(bread <= served){
                    flag = false;
                    break;
                }

                served++;
            }

            sb.append("#").append(t).append(" ");
            if(flag){
                sb.append("Possible");
            } else {
                sb.append("Impossible");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
