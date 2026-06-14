package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    N*N 개의 벌통이 정사각형으로 존재, 다음과 같은 과정으로 벌꿀을 채취하여 최대한 많은 수익을 얻으려고 한다.
    ① 꿀을 채취할 수 있는 벌통의 수 M이 주어질 때, 두 명의 일꾼은 가로로 연속되도록 M개의 벌통을 선택하고, 선택한 벌통에서 꿀을 채취할 수 있다.
       *단, 두 명의 일꾼이 선택한 벌통은 서로 겹치면 안 된다.
    ② 하나의 벌통에서 채취한 꿀은 하나의 용기에 담아야 한다.
       *꿀을 채취할 때 일부분만 채취할 수 없고, 두 일꾼이 채취할 수 있는 꿀의 최대 양은 C 이다.
    ③ 각 용기에 있는 꿀의 양의 제곱만큼의 수익이 생긴다.
       *꿀의 양이 6, 1, 8인 세 개의 용기가 얻어지며 이때 수익의 합은, (6*6) + (1*1) + (8*8).
    두 일꾼이 꿀을 채취하여 얻을 수 있는 수익의 합이 최대가 되는 경우를 찾고, 그 때의 최대 수익을 출력하기.
 */

public class Solution_swea2115 {                    //[모의 SW 역량테스트] 벌꿀채취
    //다시 풀기....

    static int n, m, c, sectionMax, max;
    static int[][] arr, profit;

    //m크기의 구역 내 최대 수익을 구하는 메서드
    private static void dfs(int idx, int sum, int profit, int row, int startCol){
        if(sum > c){
            return;
        }

        if(idx == m){
            sectionMax = Math.max(sectionMax, profit);
            return;
        }

        int honey = arr[row][startCol + idx];

        //idx+1 번째 벌통을 고름
        dfs(idx+1, sum + honey, profit + honey * honey, row, startCol);

        //idx+1 번째 벌통을 고르지 않음
        dfs(idx+1, sum, profit, row, startCol);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            sectionMax = 0;                 //구역 내 최대 수익 계산
            max = 0;                        //전체 최대 수익 계산
            arr = new int[n][n];
            profit = new int[n][n-m+1];     //i행 j열에서부터 m개만큼 선택했을 때의 수익 값

            for(int i  = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());

                for(int j = 0; j < n; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            //모든 구간의 최대 수익 계산
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n-m+1; j++) {
                    dfs(0, 0, 0, i, j);
                    profit[i][j] = sectionMax;
                    sectionMax = 0;
                }
            }

            //구간 선택
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n-m+1; j++){
                    int profit1 = profit[i][j];

                    for(int k = 0; k < n; k++){
                        for(int l = 0; l < n-m+1; l++){
                            if(i == k){
                                if(Math.abs(j-l) < m){                      //구간이 겹치는 경우는 패스
                                    continue;
                                }
                            }

                            int profit2 = profit[k][l];
                            max = Math.max(max, profit1+profit2);
                        }
                    }
                }
            }

            sb.append("#").append(t).append(" ").append(max).append("\n");
        }

        System.out.println(sb.toString());
    }
}

