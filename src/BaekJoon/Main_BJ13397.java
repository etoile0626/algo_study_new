package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    n개의 수로 이루어진 1차원 배열이 있을 때, m개 이하의 구간으로 나누어 구간 점수의 최댓값을 최소로 하려고 함
    구간은
    1. 하나 이상의 연속된 수들로 이루어져 있고
    2. 배열의 각 수는 모두 하나의 구간에 포함되어야할 때,
    구간의 점수의 최댓값과 최솟값을 구하는 프로그램을 작성하기
    *구간의 점수 = 구간에 속한 수의 최댓값과 최솟값의 차
 */

public class Main_BJ13397 {                 //구간 나누기 2
    //다시 풀기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int left = 0;
        int right = 0;                                              //탐색 범위(0~원소의 최댓값)
        int answer = Integer.MAX_VALUE;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            right = Math.max(arr[i], right);                            //가장 큰 원소값 찾기
        }

        while (left <= right){
            int mid = (left + right) / 2;

            int min = arr[0];
            int max = arr[0];
            int cnt = 1;                                                //구간 개수

            for(int i = 0; i < n; i++){
                min = Math.min(min, arr[i]);                //현재 구간의 최솟값
                max = Math.max(max, arr[i]);                //현재 구간의 최댓값

                if(max - min > mid){                        //현재 구간의 점수가 mid보다 크다면 새 구간 설정
                    cnt++;
                    min = arr[i];
                    max = arr[i];
                }
            }

            if(cnt > m){
                left = mid + 1;
            } else{
                right = mid - 1;
                answer = Math.min(answer, mid);            //조건을 만족하면 최솟값과 right 값을 갱신해서 탐색
            }
        }

        System.out.println(answer);
    }
}
