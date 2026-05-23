package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 	N개의 상자가 일렬로 놓여 있다.
	각 상자에는 일정 개수의 사탕이 들어 있다.
	*한 번의 작업에서는 한 상자에서 다른 상자로 사탕 1개를 옮길 수 있다.
	모든 상자에 들어 있는 사탕의 개수를 서로 같게 만들려고 한다.
	이때 필요한 작업 횟수의 최솟값을 구하라.
	*단, 항상 모든 상자의 사탕 개수를 같게 만들 수 있는 경우만 입력으로 주어진다.
 */

public class Solution_swea_ss1 {
    public static boolean isEqual(int[] arr, int candy) {							//배열내 모든 요소가 동등하게 분배되었는지 확인하는 메서드
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != candy) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for(int T = 1; T <= t; T++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            int candy = 0;														//인당 분배되는 캔디 수

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                candy += arr[i];
            }

            candy = candy / n;													//이만큼 인당 분배될 예정

            int cnt = 0;														//최소 이동 횟수
            while(!isEqual(arr, candy)) {
                //현재 배열에서 최대, 최솟값 찾기
                int max = arr[0];
                int maxIdx = 0;
                int min = arr[0];
                int minIdx = 0;
                for(int i = 0; i < n; i++) {
                    if(arr[i] > max) {
                        max = arr[i];
                        maxIdx = i;
                    }

                    if(arr[i] < min) {
                        min = arr[i];
                        minIdx = i;
                    }
                }

                //가장 많은 캔디를 가지고 있는 바구니에서 가장 적은 캔디가 있는 애한테 필요한 만큼 주기 / 여기가 문제인가? -> 시간이 늘긴하겠지만 하나씩 주는걸로 바꿔보자 일단
                arr[maxIdx] -= 1;
                arr[minIdx] += 1;

                cnt++;
            }

            sb.append("#").append(T).append(" ").append(cnt).append("\n");
        }

        System.out.println(sb.toString());
    }
}
