package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
    0 ~ 9의 값을 순서대로 나타낸 것이다.
    "ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"
    0 ~ 9 의 값을 나타내는 단어가 섞여 있는 문자열을 받아 작은 수부터 차례로 정렬하여 출력하기
 */

public class Solution_swea1221 {                        //[S/W 문제해결 기본] 5일차 - GNS
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        String[] nums = {"ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"};

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            int tc = Integer.parseInt(st.nextToken().substring(1));
            int len = Integer.parseInt(st.nextToken());
            int[] arr = new int[len];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < len; i++){
                String str = st.nextToken();

                for(int j = 0; j < 10; j++){
                    if(str.equals(nums[j])){
                        arr[i] = j;
                        break;
                    }
                }
            }

            Arrays.sort(arr);

            sb.append("#").append(tc).append("\n");
            for(int i = 0; i < len; i++){
                sb.append(nums[arr[i]]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
