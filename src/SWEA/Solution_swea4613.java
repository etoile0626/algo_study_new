package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    깃발은 N행 M열로 나뉘어 있고, 각 칸은 흰색, 파란색, 빨간색 중 하나로 칠해져 있다.
    당신은 몇 개의 칸에 있는 색을 다시 칠해서 이 깃발을 러시아 국기처럼 만들려고 한다. 다음의 조건을 만족해야 한다.
    위에서 몇 줄(한 줄 이상)은 모두 흰색으로 칠해져 있어야 한다.
    다음 몇 줄(한 줄 이상)은 모두 파란색으로 칠해져 있어야 한다.
    나머지 줄(한 줄 이상)은 모두 빨간색으로 칠해져 있어야 한다.
    이렇게 러시아 국기 같은 깃발을 만들기 위해서 새로 칠해야 하는 칸의 개수의 최솟값을 구하기
 */

public class Solution_swea4613 {                                //러시아 국기 같은 깃발
    //다시 풀기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[][] num = new int[n][3];                //i번째 줄에 있는 각 색의 개수, 0-흰색, 1-파란색, 2-붉은색

            for(int i = 0; i < n; i++){
                String str = br.readLine();

                for(int j = 0; j < m; j++){
                    char c = str.charAt(j);

                    if(c == 'W'){
                        num[i][0]++;
                    } else if (c == 'B') {
                        num[i][1]++;
                    } else {
                        num[i][2]++;
                    }
                }
            }

            int cnt = Integer.MAX_VALUE;
            //완전탐색하며 최소인 경우 찾기
            for(int i = 0; i < n-2; i++){                 //하얀 줄
                for(int j = i+1; j < n-1; j++) {           //파란 줄
                    int change = 0;

                    for (int k = 0; k <= i; k++) {             //흰줄로 칠하기
                        change += m - num[k][0];                 //k번째 줄의 하얀색이 아닌 경우만 세기
                    }

                    for (int k = i + 1; k <= j; k++) {           //파란줄로 칠하기
                        change += m - num[k][1];
                    }

                    for (int k = j + 1; k < n; k++) {           //빨간줄로 칠하기
                        change += m - num[k][2];
                    }

                    cnt = Math.min(cnt, change);
                }
            }

            sb.append("#").append(t).append(" ").append(cnt).append("\n");
        }

        System.out.println(sb.toString());
    }
}
