package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    2차원 세계에 블록이 쌓여있다. 비가 오면 '블록 사이에' 빗물이 고인다.
    비가 충분히 많이 올 때, 고이는 빗물의 총량은?
    *바닥은 항상 막혀있다고 가정, 블럭 내부의 빈 공간은 불가
 */

public class Main_BJ14719 {                             //빗물
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int[] arr = new int[w];
        int cnt = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < w; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < w; i++){
            int left_max = 0;
            int right_max = 0;

            for(int j = 0; j < i; j++){
                left_max = Math.max(arr[j], left_max);
            }

            for(int k = i; k < w; k++){
                right_max = Math.max(arr[k], right_max);
            }

            int rain = Math.min(left_max, right_max);

            //rain이 0이 아닌 경우에만 빗물이 고임
            if(rain > arr[i]) {
                cnt += (rain - arr[i]);
            }
        }

        System.out.println(cnt);
    }
}
