package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    버스 노선은 N개가 있는데,
    i번째 버스 노선은 번호가 Ai이상이고, Bi이하인 모든 정류장만을 다니는 버스 노선이다.
    P개의 버스 정류장에 대해 각 정류장에 몇 개의 버스 노선이 다니는지 구하기.
    *출력의 j번째 정수는 Cj번 버스 정류장을 지나는 버스 노선의 개수
    *버스정류장은 1~5000까지 존재.
 */

public class Solution_swea6485 {                            //삼성시의 버스노선
    //누적합을 안써도 풀리네..? 누적합으로도 풀어보기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            int n = Integer.parseInt(br.readLine());
            int[] A = new int[n];
            int[] B = new int[n];

            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                A[i] = Integer.parseInt(st.nextToken());
                B[i] = Integer.parseInt(st.nextToken());
            }

            int p = Integer.parseInt(br.readLine());
            int[][] C = new int[p][2];                              //C[j][0] == 버정 번호, C[j][1] == 해당 정류장이 지나는 노선 개수
            for(int j = 0; j < p; j++){
                C[j][0] = Integer.parseInt(br.readLine());
            }

            for(int i = 0; i < n; i++){
                for(int j = 0; j < p; j++){
                    if(C[j][0] >= A[i] && C[j][0] <= B[i]){
                        C[j][1]++;
                    }
                }
            }

            sb.append("#").append(t);
            for(int j = 0; j < p; j++) {
                sb.append(" ").append(C[j][1]);
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
