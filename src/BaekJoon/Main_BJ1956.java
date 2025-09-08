package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    v개의 마을과 e개의 도로로 구성되어 있는 도시가 있다.
    도로는 마을과 마을 사이에 놓여 있으며, 일방 통행 도로, 1번~v번까지 번호
    도로를 따라 운동을 하려고 함. 운동을 한 후에는 시작점으로 되돌아와야 하므로 사이클을 찾아야함
    사이클을 이루는 도로의 길이의 합이 최소가 되는 길이의 합 찾기
    *두 마을을 왕복하는 것도 사이클에 포함됨!!!
    *2 <= v <= 400, 0 <= e <= v(v-1)
    *a에서 b로 가는 도로는 한개만 존재
    *경로를 찾는 것이 불가능한 경우에는 -1을 출력
 */

public class Main_BJ1956 {                              //운동

    static int INF = 10000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        int[][] arr = new int[v+1][v+1];
        for(int i = 1; i <= v; i++){
            for(int j = 1; j <= v; j++){
                arr[i][j] = INF;

                if(i == j){
                    arr[i][j] = 0;
                }
            }
        }

        for(int i = 0; i < e; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            arr[a][b] = c;
        }

        //플로이드 워셜
        for(int i = 1; i <= v; i++){
            for(int a = 1; a <= v; a++){
                for(int b = 1; b <= v; b++){
                    arr[a][b] = Math.min(arr[a][b], arr[a][i] + arr[i][b]);
                }
            }
        }

        int min = INF;
        for(int a = 1; a <= v; a++){
            for(int b = 1; b <= v; b++){
                if(arr[a][b] != INF && arr[b][a] != INF && a != b){         //a->b로 가는 길이 있고 b->a로 가는 길이 있으면 a->b->a로 사이클이 있음 (arr[a][b] + arr[b][a])
                    min = Math.min(min, arr[a][b] + arr[b][a]);             //그 때의 최솟값 찾기
                }
            }
        }

        if(min == INF){
            System.out.println(-1);                                         //최솟값 없으면 -1
        } else {
            System.out.println(min);
        }
    }
}
