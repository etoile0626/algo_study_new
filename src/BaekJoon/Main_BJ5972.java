package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
    배달을 가기 위해서 길에서 만나는 모든 소들에게 여물을 줘야함. 최소한의 소들만 만나면서 지나가고 싶음.
    n개의 헛간과 m개의 양방향 길이 주어지고, 각각의 길에 c_i 마리 만큼의 소가 존재.
    헛간 1에서 출발해서 헛간 n에 도착하고자 할때, 최소 여물을 구하기
 */

public class Main_BJ5972 {                      //택배 배송

    static int n, m;
    static int[] dist;
    static Queue<int[]>[] graph;

    static void minimum(int start){
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> a[1] - b[1]                   //오름차순 정렬
        );

        pq.offer(new int[] {start, 0});

        while (!pq.isEmpty()){
            int[] arr = pq.poll();
            int s = arr[0];
            int w = arr[1];

            if(dist[s] < w){                                    //이미 가는 거리가 짧으면 넘어가기
                continue;
            }

            for(int[] tmp : graph[s]){
                int nextS = tmp[0];
                int nextW = tmp[1];
                int newW = w + nextW;

                if(newW < dist[nextS]){
                    dist[nextS] = newW;
                    pq.offer(new int[] {nextS, dist[nextS]});
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dist = new int[n+1];
        graph = new ArrayDeque[n+1];

        for(int i = 0; i <= n; i++){
            graph[i] = new ArrayDeque<>();
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[s].offer(new int[] {e, w});
            graph[e].offer(new int[] {s, w});
        }

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        minimum(1);

        System.out.println(dist[n]);
    }
}
