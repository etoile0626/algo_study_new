package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    x에 저장된 값은 A, y에 저장된 값은 B이다. 당신은 “x += y” 또는 “y += x” 연산을 원하는 순서대로 원하는 만큼 수행하여,
    x나 y 둘 중 하나 이상에 저장된 값이 N 초과가 되게 하려고 한다. 연산을 합쳐서 최소 몇 번 수행해야 하는지 계산하기.
 */

public class Solution_swea2145 {                            //+=
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int cnt = 0;

            while(a <= n && b <= n){
                if(a > b){
                    b += a;
                    cnt++;
                } else{
                    a += b;
                    cnt++;
                }
            }

            sb.append(cnt).append("\n");
        }

        System.out.println(sb.toString());
    }
}
