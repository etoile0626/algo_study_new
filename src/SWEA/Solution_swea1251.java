package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
    모든 섬을 해저터널로 연결하고자 함.
    다만 인도네시아에서는 해저터널 건설로 인해 파괴되는 자연을 위해 다음과 같은 환경 부담금 정책이 있습니다.
    *환경 부담 세율(E)과 각 해저터널 길이(L)의 제곱의 곱(E * L^2)만큼 지불
    총 환경 부담금을 최소로 지불하며, N개의 모든 섬을 연결할 수 있는 교통 시스템을 설계하기.
 */

public class Solution_swea1251 {                //[S/W 문제해결 응용] 4일차 - 하나로
//다시 풀기.
    private static long cost(int x1, int y1, int x2, int y2){
        long x = x2 - x1;
        long y = y2 - y1;
        return x*x + y*y;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1 ; t <= T; t++){
            int n = Integer.parseInt(br.readLine());
            int[] x = new int[n];
            int[] y = new int[n];
            boolean[] visit = new boolean[n];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++) {
                x[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){
                y[i] = Integer.parseInt(st.nextToken());
            }

            double e = Double.parseDouble(br.readLine());
            double min = 0;

            //비용을 기준으로 오름차순 정렬
            PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
            pq.add(new long[] {0, 0});                          //시작 노드 입력

            //프림 알고리즘
            while (!pq.isEmpty()) {
                long[] tmp = pq.poll();
                int node = (int)tmp[0];

                if (visit[node]) {
                    continue;
                } else {            //미방문 노드라면 방문 처리 후 계산ㅁ
                    visit[node] = true;
                    min += tmp[1];
                }

                //아직 방문하지 않은 노드에 대한 정보를 계산 후 pq에 저장
                for (int i = 0; i < n; i++) {
                    if (!visit[i]) {
                        pq.offer(new long[] {i, cost(x[node], y[node], x[i], y[i])});
                    }
                }
            }

            sb.append("#").append(t).append(" ").append(Math.round(e * min)).append("\n");
        }

        System.out.println(sb.toString());
    }
}
