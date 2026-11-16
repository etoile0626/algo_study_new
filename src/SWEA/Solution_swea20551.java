package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    각 상자에 들어 있는 사탕의 개수가 순증가하기를 원한다.
    세현이는 모든 상자가 비어 있지 않기를 원한다. 즉, 모든 상자에 1개 이상의 사탕이 들어 있기를 원한다.
    세현이가 이 두 조건을 만족시키기 위해 할 수 있는 일은, 상자 속에 들어 있는 사탕을 (0개 이상) 먹어 없애 버리는 것이다.
    세현이가 조건을 만족시킬 수 있는지 판단하고, 만족시킬 수 있다면 최소 몇 개의 사탕을 먹어야 하는지 구하기.
    *조건을 만족할 수 없다면 -1 출력
 */

public class Solution_swea20551 {                   //증가하는 사탕 수열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int eat = 0;

            if(b == 1 || c <= 2){
                eat = -1;
            } else{
                if(c <= b){
                    eat += b - c  + 1;
                    b -= b - c + 1;
                }

                if(b <= a){
                    eat += a - b + 1;
                    a -= a - b + 1;
                }
            }

            if(a == 0 || b == 0 || c == 0 || a == b || b == c){
                eat = -1;
            }

            sb.append("#").append(t).append(" ").append(eat).append("\n");
        }

        System.out.println(sb.toString());
    }
}
