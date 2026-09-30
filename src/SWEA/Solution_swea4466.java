package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
    당신은 N개의 과목에 대한 시험을 쳤다. 각 과목의 점수는 정수이고 만점은 100점이다.
    성적표에는 이 중에서 정확히 K개의 과목을 선택하여 넣을 수 있다. 당신은 기왕이면 성적표에 나타나는 총점이 가장 크도록 성적표를 만들고 싶다.
    최대로 만들 수 있는 총점은 몇점인지 구하여라.
 */

public class Solution_swea4466 {                                //최대 성적표 만들기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int sum = 0;

            //큰 수 기준 우선순위 큐
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){
                pq.offer(Integer.parseInt(st.nextToken()));
            }

            for(int i = 0; i < k; i++){
                sum += pq.poll();
            }

            sb.append("#").append(t).append(" ").append(sum).append("\n");
        }

        System.out.println(sb.toString());
    }
}
