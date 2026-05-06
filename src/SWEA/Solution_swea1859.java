package SWEA;

/*
    다음과 같은 조건 하에서 사재기를 하여 최대한의 이득을 얻도록 도와주자.

    1. 원재는 연속된 N일 동안의 물건의 매매가를 예측하여 알고 있다.
    2. 당국의 감시망에 걸리지 않기 위해 하루에 최대 1만큼 구입할 수 있다.
    3. 판매는 얼마든지 할 수 있다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_swea1859 {                    //백만 장자 프로젝트
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for(int T = 1; T <= t; T++){
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            int max = 0;                                //n일 중 가장 매매가가 비싼 값
            long sum = 0;                                //총 투자금액
            int cnt = 0;                                //물건 구매 횟수(몇일간 물건을 샀는가)
            long result = 0;                             //총 이익

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
                max = Math.max(max, arr[i]);
            }

            for(int i = 0; i < n; i++){
                if(arr[i] < max){
                    cnt++;
                    sum += arr[i];
                } else{
                    //최댓값보다 크거나 같은 값을 만나면 이전까지 중 산 게 있으면 팔고, 이후값 중 최댓값 찾기.
                    result += ((long)(max * cnt) - sum);

                    cnt = 0;
                    max = 0;
                    sum = 0;                //팔았으니 초기화

                    for(int j = i + 1; j < n; j++){
                        if(arr[j] > max){
                            max = arr[j];
                        }
                    }
                }
            }

            sb.append("#").append(T).append(" ").append(result).append("\n");
        }

        System.out.println(sb.toString());
    }
}
