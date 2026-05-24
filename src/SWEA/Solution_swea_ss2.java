package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 서로 다른 위치에 N개의 보급 창고
 * 야영 위치에서 가장 가까운 '두 개'의 보급 창고로부터 물품을 지원
 * 위험도 = 해당 위치에서 '두 번째'로 가까운 보급 창고까지의 거리
 * 모든 야영 위치 중에서 위험도가 가장 큰 위치를 찾고 그때의 위험도를 구하기.
 * *가장 왼쪽 보급 창고 위치 이상, 가장 오른쪽 보급 창고 사이에서 야영 가능,
 * *보급 창고가 있는 위치에서도 야영 가능
 */

public class Solution_swea_ss2 {
    //미완성, 실패
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for(int T = 1; T <= t; T++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr); 												//혹시 모르니 정렬 한 번

            int left = arr[0];
            int right = arr[n-1];
            int max = 0;

            while(left < right) {
                int mid = (left + right) / 2;
                int idx = 0;

                for(int i = 0; i < n-1; i++) {
                    if(arr[i] <= mid&&mid < arr[i+1]) {
                        //Math.max(mid - arr[i], arr[i+1] - mid) = 위험도
                        max = Math.max(max, Math.max(mid - arr[i], arr[i+1] - mid));		//이번 시행의 위험도와 기존 위험도의 최댓값 중 더 큰 값 찾기
                        idx = i;
                    }
                }

                //현재 남은 영역 중 보급소가 더 적은 영역으로 이동
                if(idx < n/2) {
                    right = mid;
                } else {
                    left = mid;
                }
            }

            sb.append("#").append(T).append(" ").append(max).append("\n");
        }

        System.out.println(sb.toString());
    }
}
