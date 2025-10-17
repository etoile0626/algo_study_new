package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
    정해진 총액 이하에서 가능한 최대의 총 예산을 배정하는 방법
    1. 모든 요청이 배정될 수 있는 경우에 요청한 금액을 그대로 배정
    2. 모든 요청이 배정될 수 없는 경우에는 특정한 '정수' 상한액을 계산, 그 이상의 예산 요청에는 모두 상한액을 배정.
    n개의 예산 요청과 국가예산의 총액 m이 주어졌을 때, 위의 조건을 모두 만족하도록 예산을 배정하는 프로그램 작성하기.
    * 3 <= n <= 10000, n <= m <= 1,000,000,000
 */

public class Main_BJ2512 {                      //예산
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int start = 0;
        int end = arr[n-1];

        int max = 0;

        long sum = 0;
        for(int i = 0; i < n; i++){
            sum += arr[i];
        }

        if(sum <= m){                   //1. 모든 요청이 배정될 수 있는 경우에 요청한 금액을 그대로 배정
            max = arr[n-1];
        } else {                        //2. 모든 요청이 배정될 수 없는 경우에는 특정한 '정수' 상한액을 계산
            long sum_2 = 0;

            while (start < end) {
                int mid = (start + end) / 2;            //특정한 '정수' 상한액
                long tmp = 0;                           //배정한 예산 액

                for(int i = 0; i < n; i++){
                    if(arr[i] > mid){
                        tmp += mid;
                    } else{
                        tmp += arr[i];
                    }
                }

                if(tmp <= m) {
                    if(sum_2 < tmp){
                        sum_2 = tmp;
                        max = Math.max(max, mid);
                    }

                    start = mid+1;
                }
                else{
                    end = mid;
                }
            }
        }

        System.out.println(max);
    }
}
