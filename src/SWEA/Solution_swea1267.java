package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
    선행 관계를 나타낸 그래프가 주어진다.
    이 그래프에서 각 작업은 하나씩의 정점으로 표시되고 선행 관계는 방향성을 가진 간선으로 표현된다.
    *단, 이 그래프에서 사이클은 존재하지 않는다.
    V개의 작업과 이들 간의 선행 관계가 주어질 때, 일을 끝낼 수 있는 작업 순서를 찾는 프로그램을 작성하라.
    가능한 작업 순서가 여러 가지일 경우, 하나만 제시하면 된다.
 */

public class Solution_swea1267 {                            //[S/W 문제해결 응용] 10일차 - 작업순서
    //다시 풀기, 위상정렬 생각하기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for(int t = 1; t <= 10; t++){
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int[] degree = new int[v+1];                            //진입 차수(i번 노드에 진입하려면 degree[i]만큼 선행작업이 진행되어야 함)

            List<Integer> graph[] = new ArrayList[v+1];
            for(int i = 1; i <= v; i++){
                graph[i] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < e; i++){
                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());

                graph[v1].add(v2);
                degree[v2]++;                                       //위상정렬을 위한 차수 추가
            }

            //위상 정렬, 차수가 0인 애들을 큐에 넣자<<가 핵심
            Queue<Integer> q = new ArrayDeque<>();
            for(int i = 1; i <= v; i++){
                if(degree[i] == 0){
                    q.offer(i);
                }
            }

            sb.append("#").append(t);

            while (!q.isEmpty()){
                int tmp = q.poll();
                sb.append(" ").append(tmp);

                for(int n : graph[tmp]){
                    degree[n]--;

                    if(degree[n] == 0){
                        q.offer(n);
                    }
                }
            }

            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
