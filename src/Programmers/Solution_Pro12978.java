package Programmers;

/*
    N개의 마을이 양방향으로 통행할 수 있는 도로로 연결되어 있는데, 서로 다른 마을 간에 이동할 때는 이 도로를 지나야 함.
    *지날 때 걸리는 시간은 도로별로 다름.
    1번 마을에 있는 음식점에서 각 마을로 음식 배달을 하려고 하는데,
    N개의 마을 중에서 K 시간 이하로 배달이 가능한 마을에서만 주문을 받으려고 함.
    음식 주문을 받을 수 있는 마을의 개수를 구하기.
 */

import java.util.ArrayList;
import java.util.List;

public class Solution_Pro12978 {                            //배달
    class Solution {
        public int solution(int N, int[][] road, int K) {
            int answer = 0;
            int[] dist = new int[N+1];
            boolean[] visit = new boolean[N+1];
            List<int[]>[] graph = new ArrayList[N+1];

            //그래프 초기화
            for(int i = 0; i <= N; i++){
                graph[i] = new ArrayList<>();
                dist[i] = Integer.MAX_VALUE;
            }

            //그래프 간선추가
            for(int i = 0; i < road.length; i++){
                int s = road[i][0];
                int e = road[i][1];
                int w = road[i][2];

                graph[s].add(new int[] {e, w});
                graph[e].add(new int[] {s, w});
            }

            //시작 노드 설정(1번노드에서 시작)
            for(int[] arr : graph[1]){
                int e = arr[0];
                int w = arr[1];

                dist[e] = Math.min(dist[e], w);
            }

            dist[1] = 0;
            visit[1] = true;

            //n-1개의 노드를 방문해야하므로 n-1번 반복
            for(int i = 0; i < N -1; i++){
                int idx = 0;
                int min = Integer.MAX_VALUE;

                //안 간 노드들 중 가장 짧은 거리의 노드 선택
                for(int j = 1; j <= N; j++){
                    if(!visit[j] && dist[j] < min){
                        min = dist[j];
                        idx = j;
                    }
                }

                visit[idx] = true;

                //선택한 노드에서 다음 노드로 가는 갈 때 갱신 가능한 것들 갱신
                for(int[] arr : graph[idx]){
                    int e = arr[0];
                    int w = arr[1];

                    if(dist[idx] + w < dist[e]){
                        dist[e] = dist[idx] + w;
                    }
                }
            }

            //조건에 만족하는 노드 개수 찾기
            for(int i = 1; i <= N; i++){
                if(dist[i] <= K){
                    answer++;
                }
            }

            return answer;
        }
    }
}
