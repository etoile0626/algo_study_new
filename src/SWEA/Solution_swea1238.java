package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
    비상연락망과 연락을 시작하는 당번에 대한 정보가 주어질 때,
    가장 나중에 연락을 받게 되는 사람 중 번호가 가장 큰 사람을 구하기
    *동일한 {from, to}쌍이 여러 번 반복되는 경우도 있으며, 한 번 기록된 경우와 여러 번 기록된 경우의 차이는 없다.
    *연락 인원은 최대 100명이며, 부여될 수 있는 번호는 1이상, 100이하이다.
    *중간 중간에 비어있는 번호가 있을 수 있다.
 */

public class Solution_swea1238 {                        //[S/W 문제해결 기본] 10일차 - Contact
    //다시풀기
    static int start, last;
    static boolean[] visit;
    static List<Integer>[] graph;

    private static void bfs(){
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        visit[start] = true;

        while(!q.isEmpty()) {
            int size = q.size();                                    // <- 단계별로 분리, 이 생각을 못함.
            last = 0;

            for(int i = 0; i < size; i++) {
                int node = q.poll();
                last = Math.max(last, node);                        //이번 탐색 단계에서 가장 큰 노드값 찾기

                for (int next : graph[node]) {
                    if (!visit[next]) {
                        q.offer(next);
                        visit[next] = true;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for(int t = 1; t <= 10; t++){
            st = new StringTokenizer(br.readLine());
            int len = Integer.parseInt(st.nextToken());                 //입력받는 데이터의 길이

            start = Integer.parseInt(st.nextToken());               //시작점
            last = 0;                                               //마지막 연락책 중 최댓값
            visit = new boolean[101];
            graph = new ArrayList[101];

            for(int i = 1; i < 101; i++){
                graph[i] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < len/2; i++){
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                if(!graph[from].contains(to)) {
                    graph[from].add(to);
                }
            }

            bfs();

            sb.append("#").append(t).append(" ").append(last).append("\n");
        }

        System.out.println(sb.toString());
    }
}
