package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    어떠한 양의 정수 N에 대해서, N과 √N이 모두 팰린드롬이면 이 수를 제곱 팰린드롬 수 라고 부른다.
    예를 들어, 121은 제곱 팰린드롬 수인데, 121이 팰린드롬이며, 121의 제곱근인 11 역시 팰린드롬이기 때문이다.
    A 이상 B 이하 제곱 팰린드롬 수는 모두 몇 개인가?
 */

public class Solution_swea10570 {                       //제곱 팰린드롬 수
    private static boolean isPal(int n){
        String str = Integer.toString(n);

        for(int i = 0; i < (double)str.length()/2; i++){
            if(str.charAt(i) != str.charAt(str.length() - i -1)){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cnt = 0;

            for(int i = a; i <= b; i++){
                if(isPal(i)) {
                    int n = (int)Math.sqrt(i);

                    if (n * n != i) {
                        continue;
                    } else if(isPal(n)){
                        cnt++;
                    }
                }
            }

            sb.append("#").append(t).append(" ").append(cnt).append("\n");
        }

        System.out.println(sb.toString());
    }
}
