package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    직사각형의 네 변 중에서 세 변의 길이가 주어진다.
    나머지 한 변의 길이가 얼마인지 출력하는 프로그램을 작성하라.
    세 변의 길이는 상하좌우 어디든 될 수 있으므로 그 순서는 중요하지 않다.
 */

public class Solution_swea3456 {                    //직사각형 길이 찾기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = 0;

            if(a == b){
                d = c;
            } else if(a == c){
                d = b;
            } else{
                d = a;
            }

            sb.append("#").append(t).append(" ").append(d).append("\n");
        }

        System.out.println(sb.toString());
    }
}
