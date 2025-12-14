package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
    n개의 도시에 m개의 버스가 존재할 때, a도시에서 b도시로 갈 때 최소비용 구하기
 */

public class Main_BJ1916 {                      //최소비용 구하기
    //다시 풀기

    static int n, m;
    static int[] dist;
    static Queue<int[]>[] graph;

    static void minimum(int start){
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> a[1] - b[1]                   //비용기준 오름차순
        );

        pq.offer(new int[] {start, 0});

        while (!pq.isEmpty()){
            int[] tmp = pq.poll();
            int node = tmp[0];
            int w = tmp[1];

            //이미 최소거리가 갱신되었다면 스킵
            if(w > dist[node]){
                continue;
            }

            for(int[] next : graph[node]){
                int nextNode = next[0];
                int nextW = next[1] + w;                    //방문할 노드까지의 거리 계산

                if(nextW < dist[nextNode]){                 //거리가 dist 값보다 작으면(갱신 가능하면)
                    dist[nextNode] = nextW;
                    pq.offer(new int[] {nextNode, nextW});  //갱신 후 다음 탐색에 저장
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
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
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        minimum(start);

        System.out.println(dist[end]);
    }
}
