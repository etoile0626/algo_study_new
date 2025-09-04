package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    산성 용액은 1000000000 이하의 양의 정수, 알칼리성 용액은 -1000000000 이상의 음의 정수
    같은 양의 두 용액을 혼합한 용액의 특성값은 혼합에 사용된 각 용액의 특성값의 합으로 정의
    산성과 알칼리성 용액이 정렬된 순서로 주어졌을 때, 이 중 2개를 사용하여 특성값이 0에 가장 가까운 용액을 만드는 두 용액 찾기

    * 2 <= n <= 100000
 */

public class Main_BJ2467 {                  //용액
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = n-1;

        int min = Integer.MAX_VALUE;
        int min_s = 0;
        int min_e = n-1;
        while(start < end){
            int sum = arr[start] + arr[end];

            if(Math.abs(sum) < min){
                min = Math.abs(sum);
                min_s = start;
                min_e = end;
            }

            if(sum > 0){
                end--;
            } else if(sum < 0){
                start++;
            } else {
                min_s = start;
                min_e = end;
                break;
            }
        }

        System.out.println(arr[min_s] + " " + arr[min_e]);
    }
}
