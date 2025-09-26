package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
    n 종류의 동전이 있을 때, 동전을 적당히 사용해서 가치의 합이 k가 되도록 만들고자 할 때, 그 경우의 수를 구하기
    *사용한 동전의 구성이 같다면 같은 경우로 취급, 각각의 동전은 몇 개라도 사용 가능
    * 1 <= n <= 100, 1 <= k <= 10000
    *동전의 가치는 100000이하, 경우의 수는 2^31보다 작음
 */

public class Main_BJ2293 {                  //동전 1
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for(int i = 0; i < n ;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int[] dp = new int[k+1];                              //i원을 만들 수 있는 경우의 수?

        dp[0] = 1;                                            //0원을 만드는 방법 = 동전을 하나도 쓰지 않는다 = 1가지
        for(int i = 0; i < n; i++) {                          //i원의 동전을 사용할 때 dp[j]의 값 추가해주기
            for (int j = 1; j <= k; j++) {
                if(j - arr[i] < 0) {
                    continue;
                }

                dp[j] += dp[j - arr[i]];
            }
        }

        System.out.println(dp[k]);
    }
}
