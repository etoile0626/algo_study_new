package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
    도현이의 집 n개가 수직선 위에 존재, 각 집의 좌표는 x1, ... , xn, 좌표가 같은 경우는 미존재
    집에 공유기 c개를 설치하고자 함. 한 집에 하나의 공유기 설치 가능, 인접한 두 공유기 사이의 거리를 최대로 하고자 함.
    * 2 <= n <= 100000, 2 <= c <= n, 0 <= xi <= 1000000000
 */

public class Main_BJ2110 {                                  //공유기 설치
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int max = 0;
        int left = 0;
        int right = arr[n-1];

        while(left <= right){                   //이렇게 조건문 짤거면 left, right값 생신시 mid가 아니라 mid +1, mid -1을 대입해야함
            int mid = (left + right) / 2;
            int cnt = 1;                        //이번 시도에서 설치한 공유기 갯수
            int prev = arr[0];                  //마지막에 설치한 공유기 위치

            for(int i = 1; i < n; i++){
                int next = arr[i];

                if(next - prev >= mid){
                    cnt++;
                    prev = next;
                }
            }

            if(cnt < c){
                right = mid - 1;
            } else {
                max = Math.max(max, mid);
                left = mid + 1;
            }
        }

        System.out.println(max);
    }
}
