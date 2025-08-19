package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ10812 {                     //바구니 순서 바꾸기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n+1];
        int[] tmp = new int[n+1];
        for(int i = 1; i <= n; i++){
            arr[i] = i;
            tmp[i] = i;
        }

        for(int t = 0; t < m; t++){
            st = new StringTokenizer(br.readLine());

            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int start = i;

            for (int a = 0; a < j - i + 1; a++){
                if(k + a <= j){                         //mid~end까지 위치 정렬
                    tmp[a + i] = arr[k + a];
                } else{
                    tmp[a + i] = arr[start];              //그 후 start~mid-1까지 위치 정렬
                    start++;
                }
            }

            for (int a = 1; a <= n; a++) {
                arr[a] = tmp[a];
            }
        }

        for (int i = 1; i <= n; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
