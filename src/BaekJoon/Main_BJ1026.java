package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_BJ1026 {                          //보물
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a); // A를 오름차순으로 정렬

        Integer[] b = new Integer[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(b, Comparator.reverseOrder()); // B를 내림차순으로 정렬

        int ans = 0;
        for (int i = 0; i < n; i++) { // A의 가장 작은 값과 B의 가장 큰 값을 곱해서 더해 나감.
            ans += a[i] * b[i];
        }

        System.out.println(ans);
    }
}
