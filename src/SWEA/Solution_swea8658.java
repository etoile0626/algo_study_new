package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    10개의 자연수가 주어진다.
    각 수마다 그 수의 각 자리 수를 다 더한 값을 계산해야 한다.
    *예를 들어서 주어진 수 중에 1203이 있다면 이 수의 각 자리 수를 모두 더하면 1 + 2 + 0 + 3 = 6이 된다.
    의석이는 동욱이에게 받은 10개의 숫자들 중, 위와 같이 변환했을 때의 최대, 최소값을 대답하기.
 */

public class Solution_swea8658 {                            //Summation
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T= Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            int max = 0;
            int min = Integer.MAX_VALUE;
            int[] arr = new int[10];

            for(int i = 0; i < 10; i++){
                String str = st.nextToken();

                for(int j = 0; j < str.length(); j++){
                    arr[i] += str.charAt(j) - '0';
                }
            }

            for(int i = 0; i < 10; i++){
                max = Math.max(max, arr[i]);
                min = Math.min(min, arr[i]);
            }

            sb.append("#").append(t).append(" ").append(max).append(" ").append(min).append("\n");
        }

        System.out.println(sb.toString());
    }
}
