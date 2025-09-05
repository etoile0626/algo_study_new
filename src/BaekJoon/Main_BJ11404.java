package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    n개의 도시가 있고, 한 도시에 다른 도시로 도착하는 m개의 버스가 있다. 각 버스는 비용이 존재.
    모든 도시 쌍 (a,b)에 대해 a에서 b로 가는데 필요한 비용의 최솟값 구하기
    * 2 <= n <= 100, 1 <= m <= 100000
    * 시작 도시 = a, 도착 도시 = b, 비용 = c, 1 <= c <= 100000
    * a에서 b로 갈 수 없는 경우 0 출력
    * i번째 줄에 출력하는 j번째 숫자는 도시쌍(i, j)의 최소 비용
 */

public class Main_BJ11404 {                     //플로이드

    static int INF = 100000000;                 //입력값과 너무 비슷하게 INF를 설정 시 INF보다 큰 이동 비용이 나오는 경우 존재

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] arr = new int[n+1][n+1];

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(i == j){
                    continue;
                }
                arr[i][j] = INF;
            }
        }

        for(int i = 0; i < m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());                   //시작점
            int b = Integer.parseInt(st.nextToken());                   //도착점
            int c = Integer.parseInt(st.nextToken());                   //비용

            arr[a][b] = Math.min(arr[a][b], c);                         //시작점과 도착점이 같은 입력값인 경우 더 작은값을 저장 ((중요))
        }

        //플로이드-워셜 알고리즘
        for(int i = 1; i <= n; i++){                                    //i개의 노드 모두 탐색
            for(int a = 1; a <= n; a++){                                //a에서 b까지 가는 길이
                for(int b = 1; b <= n; b++){                            //i번째 노드를 거치는 것보다 빠른지 비교
                    arr[a][b] = Math.min(arr[a][b], arr[a][i] + arr[i][b]);             //기존거랑 i번째를 거치는 것 중 더 빠른거 선정
                }
            }
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(arr[i][j] >= INF){
                    System.out.print(0 + " ");
                } else{
                    System.out.print(arr[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
