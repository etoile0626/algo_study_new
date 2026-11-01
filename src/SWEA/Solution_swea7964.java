package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    부먹 왕국의 특징은 모든 도시들을 건설 할 때 일렬로 이어지게 만들었다.
    어느 도시에 차원 관문을 설치하면 그 도시와 거리 D 이하인 다른 도시에서 차원 관문이 있는 곳으로 들어오거나, 혹은 차원 관문에서 거리 D 이하인 다른 도시로 나가는것이 가능하다.
    모든 차원 관문 사이와 직접적으로 이동이 가능하도록 차원 관문을 재건하려고 한다.
    (단, 0번 위치와 N+1번 위치에는 차원 관문이 존재 한다.)
    도시들마다 차원관문이 남아있는 지에 대한 정보가 주어졌을 때, 이동에 필요한 차원관문의 최소 개수를 구하기.
    *1은 남아있음을 의미하며 0은 파괴 당한 것을 의미한다.
    *i번 도시와 (i+1)번 도시 사이의 거리는 모든 1 ≤ i < N에 대해서 1이다.
 */

public class Solution_swea7964 {                            //부먹왕국의 차원 관문
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int cnt = 0;
            int[] arr = new int[n];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int dist = 0;
            for(int i = 0; i < n; i++){
                dist++;

                if(arr[i] == 0 && dist == d){
                    cnt++;
                    dist = 0;
                } else if(arr[i] == 1){
                    dist = 0;
                }
            }

            sb.append("#").append(t).append(" ").append(cnt).append("\n");
        }

        System.out.println(sb.toString());
    }
}
