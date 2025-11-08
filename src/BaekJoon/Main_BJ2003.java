package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ2003 {                          //수들의 합 2
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        int low = 0, high = 0;
        int sum = arr[low];
        while (true) {
            if (high >= n)
                break;

            if (sum > m) {
                sum -= arr[low++];
            } else if (sum == m) {
                cnt++;
                sum += arr[++high];
            } else {
                sum += arr[++high];
            }
        }

        System.out.println(cnt);
    }
}
