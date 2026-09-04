package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    어떤 k자리 수 X = d1d2…dk 가 d1 ≤ d2 ≤ … ≤ dk 를 만족하면 단조 증가하는 수이다.
    예를 들어 111566, 233359는 단조 증가하는 수이고, 12343, 999888은 단조 증가하는 수
     1 ≤ i < j ≤ N 인 두 i, j에 대해, Ai x Aj값이 단조 증가하는 수인 것들을 구하고 그 중의 최댓값을 출력하기.
     *단조 증가하는 수가 없다면 -1을 출력한다.
 */

public class Solution_swea6190 {                        //정곤이의 단조 증가하는 수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            long max = -1;

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for(int i = 0; i < n-1; i++){
                for(int j = i + 1; j < n; j++){
                    long tmp1 = arr[i] * arr[j];
                    long tmp2 = tmp1;
                    boolean flag = true;

                    int num1 = 9;                           //현재 탐색 중인 자리의 자리수
                    while(tmp1 > 0){
                        int num2 = (int) tmp1 % 10;

                        if(num2 <= num1){
                            num1 = num2;
                            tmp1 = tmp1 / 10;
                        } else {
                            flag = false;
                            break;
                        }
                    }

                    if(flag){
                        max = Math.max(max, tmp2);
                    }
                }
            }

            sb.append("#").append(t).append(" ").append(max).append("\n");
        }

        System.out.println(sb.toString());
    }
}
