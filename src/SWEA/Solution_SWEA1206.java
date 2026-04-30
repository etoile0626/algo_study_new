package SWEA;

/*
    왼쪽과 오른쪽으로 창문을 열었을 때, 양쪽 모두 거리 2 이상의 공간이 확보될 때 조망권이 확보된다고 말한다.
    빌딩들에 대한 정보가 주어질 때, 조망권이 확보된 세대의 수를 반환하기.
    *맨 왼쪽 두 칸과 맨 오른쪽 두 칸에는 건물이 지어지지 않음

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA1206 {                                //[S/W 문제해결 기본] 1일차 - View
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for(int t = 1; t <= 10; t++){
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            int cnt = 0;                                        //조망권 확보 수

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for(int i = 0; i < n; i++){
                if(arr[i] == 0){
                    continue;
                }

                int max = Math.max(Math.max(arr[i-2], arr[i-1]), Math.max(arr[i+1], arr[i+2]));
                if(max < arr[i]){
                    cnt += arr[i] - max;
                }
            }

            sb.append("#").append(t).append(" ").append(cnt).append("\n");
        }

        System.out.println(sb.toString());
    }
}
